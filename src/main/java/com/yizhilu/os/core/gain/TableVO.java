package com.yizhilu.os.core.gain;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import org.mybatis.generator.internal.util.StringUtility;
import org.springframework.util.StringUtils;

public class TableVO {
    private String tableName;
    private String packageName;// 统一的包
    private List<ColumnVO> columnList;
    private List<String> keys = new ArrayList<String>();
    private int preOrSu;
    private String separator;
    private String mypackageName;// 自己的包

    /**
     * @return the mypackageName
     */
    public String getMypackageName() {
        return mypackageName;
    }

    /**
     * @param mypackageName
     *            the mypackageName to set
     */
    public void setMypackageName(String mypackageName) {
        this.mypackageName = mypackageName;
    }

    public String getTableName() {
        return tableName.toLowerCase();
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getVoClassName() {
        String tn = tableName.toLowerCase();
        switch (preOrSu) {
        case -1:
            tn = tn.substring(tn.indexOf(separator));
            break;
        case 1:
            tn = tn.substring(0, tn.length() - tn.lastIndexOf(separator));
            break;
        case 2:
            String tempTn = tn.substring(tn.indexOf(separator) + 1);
            tn = tempTn.substring(0, tempTn.lastIndexOf(separator) + 1);
            break;
        }
        String[] tn_split = tn.split(separator);
        StringBuffer sbClassName = new StringBuffer();
        for (String tn_sub : tn_split) {
            if(!StringUtils.isEmpty(tn_sub)){
                sbClassName.append(tn_sub.substring(0, 1).toUpperCase()).append(
                        tn_sub.substring(1));
            }
            
        }
        return sbClassName.toString();
    }

    public List<ColumnVO> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<ColumnVO> columnList) {
        this.columnList = columnList;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public List<String> getKeys() {
        return keys;
    }

    public void setKeys(List<String> keys) {
        this.keys = keys;
    }

    public int getPreOrSu() {
        return preOrSu;
    }

    public void setPreOrSu(int preOrSu) {
        this.preOrSu = preOrSu;
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public String getParmString() {
        String temp = getVoClassName();
        temp = temp.substring(0, 1).toLowerCase() + temp.substring(1);
        return temp;
    }

    public Date getDate() {
        return new Date(System.currentTimeMillis());
    }
}
