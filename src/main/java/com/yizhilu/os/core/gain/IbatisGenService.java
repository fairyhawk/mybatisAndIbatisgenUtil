package com.yizhilu.os.core.gain;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.*;

import lombok.Getter;
import lombok.Setter;

import freemarker.template.Template;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;

public class IbatisGenService extends JdbcDaoSupport {
    @Getter
    @Setter
    private Map<String, List<String>> tableNSMap;
    @Getter
    @Setter
    private String packageName;
    @Getter
    @Setter
    private String ibatisFileDir;
    @Getter
    @Setter
    private String springFileDir;
    @Getter
    @Setter
    private String destDir;
    @Getter
    @Setter
    private String templateDir;
    @Getter
    @Setter
    private int preOrSu;
    @Getter
    @Setter
    private String separator;
    @Getter
    @Setter
    private List<NameSpaceVO> nsvoList;

    public void gen() throws Exception {
        List<TableVO> tableList = new ArrayList<TableVO>();
        Connection conn = null;
        ResultSet rs = null;
        ResultSet rsKey = null;
        ResultSet rsImpKey = null;
        ResultSet rsExtKey = null;
        try {
            conn = getDataSource().getConnection();
            DatabaseMetaData dmd = conn.getMetaData();
            rs = dmd.getTables(null, null, null, new String[] { "TABLE" });
            while (rs.next()) {
                TableVO tableVO = new TableVO();
                tableVO.setPreOrSu(preOrSu);
                tableVO.setSeparator(separator);
                String tableName = rs.getString(3);
                tableVO.setTableName(tableName);

                rsKey = dmd.getPrimaryKeys(null, null, tableName);
                while (rsKey.next()) {
                    tableVO.getKeys().add(rsKey.getString(4));
                }

                rsExtKey = dmd.getExportedKeys(null, null, tableName);
                while (rsExtKey.next()) {
                    System.out.println("ext key of " + tableName + ":"
                            + rsExtKey.getString(4));
                }

                rsImpKey = dmd.getImportedKeys(null, null, tableName);
                while (rsImpKey.next()) {
                    System.out.println("imp key of " + tableName + ":"
                            + rsImpKey.getString(4));
                }

                List<ColumnVO> columnList = new ArrayList<ColumnVO>();
                String sql = "select * from " + rs.getString(3) + " where 1=2";
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rsTable = ps.executeQuery();
                ResultSetMetaData rsmd = rsTable.getMetaData();
                int mdCnt = rsmd.getColumnCount();
                for (int i = 1; i <= mdCnt; i++) {
                    ColumnVO columnVO = new ColumnVO();
                    columnVO.setColumnName(rsmd.getColumnName(i));
                    columnVO.setColumnType(rsmd.getColumnType(i));
                    if (tableVO.getKeys().contains(columnVO.getColumnName())) {
                        columnVO.setKey(true);
                    }
                    columnList.add(columnVO);
                }
                tableVO.setColumnList(columnList);
                tableList.add(tableVO);
                rsTable.close();
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (rs != null)
                rs.close();
            if (conn != null)
                conn.close();
            if (rsKey != null)
                rsKey.close();
            if (rsImpKey != null)
                rsImpKey.close();
            if (rsExtKey != null)
                rsExtKey.close();
        }
        List<NameSpaceVO> nameSpaceVOList = inNSMap(tableList);
        genIbatisFile(nameSpaceVOList);
        genVOClassFile(nameSpaceVOList);
        genInterfaceFile(nameSpaceVOList);
        genConditionFile(nameSpaceVOList);
        genImplFile(nameSpaceVOList);
        genIbatisResourceFile(nameSpaceVOList);
        genSpringFile(nameSpaceVOList);
        genSpringResourceFile(nameSpaceVOList);
    }

    public void genSpringFile(List<NameSpaceVO> nameSpaceVOList) throws Exception {
        Configuration cfg = new Configuration();
        cfg.setDefaultEncoding("UTF-8");
        cfg.setDirectoryForTemplateLoading(new File(templateDir));
        cfg.setObjectWrapper(new DefaultObjectWrapper());

        Template template = cfg.getTemplate("springBeanTemplate.ftl");

        for (NameSpaceVO nameSpaceVO : nameSpaceVOList) {
            for (TableVO tableVO : nameSpaceVO.getTableList()) {
                tableVO.setPackageName(packageName.replaceAll("\\\\", "."));
            }

            File configFileDir = new File(destDir + File.separator + springFileDir
                    + File.separator + nameSpaceVO.getName());
            if (!configFileDir.exists()) {
                configFileDir.mkdirs();
            }

            String filePath = configFileDir.getPath() + File.separator + "aContext_"
                    + nameSpaceVO.getName() + ".xml";
            File file = new File(filePath);
            Writer out = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            template.process(nameSpaceVO, out);
            out.flush();
        }
    }

    public void genSpringResourceFile(List<NameSpaceVO> nameSpaceVOList) throws Exception {
        setNsvoList(nameSpaceVOList);
        Configuration cfg = new Configuration();
        cfg.setDefaultEncoding("UTF-8");
        cfg.setDirectoryForTemplateLoading(new File(templateDir));
        cfg.setObjectWrapper(new DefaultObjectWrapper());

        Template template = cfg.getTemplate("springResource.ftl");

        File configFileDir = new File(destDir + File.separator + springFileDir);
        if (!configFileDir.exists()) {
            configFileDir.mkdirs();
        }

        String filePath = configFileDir.getPath() + File.separator + "aContext.xml";
        File file = new File(filePath);
        Writer out = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
        template.process(this, out);
        out.flush();
    }

    public void genIbatisResourceFile(List<NameSpaceVO> nameSpaceVOList) throws Exception {
        setNsvoList(nameSpaceVOList);
        Configuration cfg = new Configuration();
        cfg.setDefaultEncoding("UTF-8");
        cfg.setDirectoryForTemplateLoading(new File(templateDir));
        cfg.setObjectWrapper(new DefaultObjectWrapper());

        Template template = cfg.getTemplate("sqlMapResource.ftl");

        File configFileDir = new File(destDir + File.separator + ibatisFileDir);
        if (!configFileDir.exists()) {
            configFileDir.mkdirs();
        }

        String filePath = configFileDir.getPath() + File.separator + "SqlMapClient.xml";
        File file = new File(filePath);
        Writer out = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
        template.process(this, out);
        out.flush();
    }

    public void genIbatisFile(List<NameSpaceVO> nameSpaceVOList) throws Exception {
        Configuration cfg = new Configuration();
        cfg.setDefaultEncoding("UTF-8");
        cfg.setDirectoryForTemplateLoading(new File(templateDir));
        cfg.setObjectWrapper(new DefaultObjectWrapper());

        Template template = cfg.getTemplate("ibatisTemplate.ftl");

        for (NameSpaceVO nameSpaceVO : nameSpaceVOList) {
            for (TableVO tableVO : nameSpaceVO.getTableList()) {
                tableVO.setPackageName(packageName.replaceAll("\\\\", "."));

                File configFileDir = new File(destDir + File.separator + ibatisFileDir
                        + File.separator + nameSpaceVO.getName());
                if (!configFileDir.exists()) {
                    configFileDir.mkdirs();
                }

                String filePath = configFileDir.getPath() + File.separator
                        + tableVO.getVoClassName() + ".xml";
                File file = new File(filePath);
                Writer out = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
                template.process(tableVO, out);
                out.flush();
            }
        }
    }

    public void genVOClassFile(List<NameSpaceVO> nameSpaceVOList) throws Exception {
        Configuration cfg = new Configuration();
        cfg.setDefaultEncoding("UTF-8");
        cfg.setDirectoryForTemplateLoading(new File(templateDir));
        cfg.setObjectWrapper(new DefaultObjectWrapper());

        Template template = cfg.getTemplate("javaClassTemplate.ftl");

        File voPackageDir = new File(destDir + File.separator + packageName
                + File.separator + "domain");
        if (!voPackageDir.exists()) {
            voPackageDir.mkdirs();
        }

        for (NameSpaceVO nameSpaceVO : nameSpaceVOList) {
            for (TableVO tableVO : nameSpaceVO.getTableList()) {
                tableVO.setPackageName(packageName.replaceAll("\\\\", "."));
                String filePath = destDir + File.separator + packageName + File.separator
                        + "domain" + File.separator + tableVO.getVoClassName() + ".java";
                File file = new File(filePath);
                Writer out = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
                template.process(tableVO, out);
                out.flush();
            }
        }
    }

    public void genInterfaceFile(List<NameSpaceVO> nameSpaceVOList) throws Exception {
        Configuration cfg = new Configuration();
        cfg.setDefaultEncoding("GBK");
        cfg.setDirectoryForTemplateLoading(new File(templateDir));
        cfg.setObjectWrapper(new DefaultObjectWrapper());

        Template template = cfg.getTemplate("javaInterfaceTemplate.ftl");
        template.setEncoding("GBK");

        File voPackageDir = new File(destDir + File.separator + packageName
                + File.separator + "service");
        if (!voPackageDir.exists()) {
            voPackageDir.mkdirs();
        }

        for (NameSpaceVO nameSpaceVO : nameSpaceVOList) {
            for (TableVO tableVO : nameSpaceVO.getTableList()) {
                tableVO.setPackageName(packageName.replaceAll("\\\\", "."));
                String filePath = destDir + File.separator + packageName + File.separator
                        + "service" + File.separator + "I" + tableVO.getVoClassName()
                        + ".java";
                File file = new File(filePath);
                Writer out = new OutputStreamWriter(new FileOutputStream(file), "GBK");
                template.process(tableVO, out);
                out.flush();
            }
        }
    }

    public void genImplFile(List<NameSpaceVO> nameSpaceVOList) throws Exception {
        Configuration cfg = new Configuration();
        cfg.setDefaultEncoding("GBK");
        cfg.setDirectoryForTemplateLoading(new File(templateDir));
        cfg.setObjectWrapper(new DefaultObjectWrapper());

        Template template = cfg.getTemplate("javaImplTemplate.ftl");
        template.setEncoding("GBK");

        File voPackageDir = new File(destDir + File.separator + packageName
                + File.separator + "service");
        if (!voPackageDir.exists()) {
            voPackageDir.mkdirs();
        }

        for (NameSpaceVO nameSpaceVO : nameSpaceVOList) {
            for (TableVO tableVO : nameSpaceVO.getTableList()) {
                tableVO.setPackageName(packageName.replaceAll("\\\\", "."));
                String filePath = destDir + File.separator + packageName + File.separator
                        + "service" + File.separator + tableVO.getVoClassName()
                        + "Impl.java";
                File file = new File(filePath);
                Writer out = new OutputStreamWriter(new FileOutputStream(file), "GBK");
                template.process(tableVO, out);
                out.flush();
            }
        }
    }

    public void genConditionFile(List<NameSpaceVO> nameSpaceVOList) throws Exception {
        Configuration cfg = new Configuration();
        cfg.setDefaultEncoding("UTF-8");
        cfg.setDirectoryForTemplateLoading(new File(templateDir));
        cfg.setObjectWrapper(new DefaultObjectWrapper());

        Template template = cfg.getTemplate("javaConditionTemplate.ftl");

        File voPackageDir = new File(destDir + File.separator + packageName
                + File.separator + "condition");
        if (!voPackageDir.exists()) {
            voPackageDir.mkdirs();
        }

        for (NameSpaceVO nameSpaceVO : nameSpaceVOList) {
            for (TableVO tableVO : nameSpaceVO.getTableList()) {
                tableVO.setPackageName(packageName.replaceAll("\\\\", "."));
                String filePath = destDir + File.separator + packageName + File.separator
                        + "condition" + File.separator + "Query"
                        + tableVO.getVoClassName() + "Condition.java";
                File file = new File(filePath);
                Writer out = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
                template.process(tableVO, out);
                out.flush();
            }
        }
    }

    public List<NameSpaceVO> inNSMap(List<TableVO> tableList) {
        List<NameSpaceVO> nameSpaceVOList = new ArrayList<NameSpaceVO>();
        List<TableVO> defaultTalbeVOList = new ArrayList<TableVO>();
        for (String nameSpaceName : tableNSMap.keySet()) {
            NameSpaceVO nameSpaceVO = new NameSpaceVO();
            nameSpaceVO.setName(nameSpaceName);
            for (TableVO tableVO : tableList) {
                if (tableNSMap.get(nameSpaceName).contains(tableVO.getTableName())) {
                    nameSpaceVO.getTableList().add(tableVO);
                }
            }
            nameSpaceVOList.add(nameSpaceVO);
        }
        for (String nameSpaceName : tableNSMap.keySet()) {
            for (TableVO tableVO : tableList) {
                if (tableNSMap.get(nameSpaceName).contains(tableVO.getTableName())) {
                    if (defaultTalbeVOList.contains(tableVO)) {
                        defaultTalbeVOList.remove(tableVO);
                    }
                } else {
                    defaultTalbeVOList.add(tableVO);
                }
            }
        }
        if (defaultTalbeVOList.size() > 0) {
            NameSpaceVO nameSpaceVO = new NameSpaceVO();
            nameSpaceVO.setName("default");
            nameSpaceVO.setTableList(defaultTalbeVOList);
            nameSpaceVOList.add(nameSpaceVO);
        }

        return nameSpaceVOList;
    }

}
