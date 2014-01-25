package ${packageName}.dao.impl.${mypackageName};

import java.util.List;
import ${packageName}.entity.${mypackageName}.${voClassName};
import ${packageName}.dao.${mypackageName}.${voClassName}Dao;
import org.springframework.stereotype.Repository;
import com.yizhilu.os.core.dao.impl.common.GenericDaoImpl;

/**
 *
 * ${voClassName}
 * User: qinggang.liu bis@foxmail.com
 * Date: ${date?string("yyyy-MM-dd")}
 */
 @Repository("${parmString}Dao")
public class ${voClassName}DaoImpl extends GenericDaoImpl implements ${voClassName}Dao{

    public <#if keys?size == 0 >void<#else><#list columnList as column><#if column.key>${column.returnType}</#if></#list></#if> add${voClassName}(${voClassName} ${parmString}) {
        <#if keys?size != 0 && keys?size != 1><#else>
        return </#if>this.insert("${voClassName}Mapper.create${voClassName}",${parmString});
    }

    public void delete${voClassName}ById(<#assign i=0><#list columnList as column><#if column.key><#assign i=i+1><#if (i>1)>,</#if>${column.propertyType} ${column.propertyName}</#if></#list>){
        <#if keys?size != 0 && keys?size != 1>
        java.util.Map keyMap = new java.util.HashMap();
            <#list columnList as column>
                <#if column.key>
        keyMap.put("${column.propertyName}",${column.propertyName});
                </#if>
            </#list>
        this.delete("${voClassName}Mapper.delete${voClassName}ById",keyMap);
        <#else>
            <#list columnList as column>
                <#if column.key>
        this.delete("${voClassName}Mapper.delete${voClassName}ById",${column.propertyName});
                </#if>
            </#list>
        </#if>
    }

    public void update${voClassName}(${voClassName} ${parmString}) {
        this.update("${voClassName}Mapper.update${voClassName}",${parmString});
    }

    public ${voClassName} get${voClassName}ById(<#assign i=0><#list columnList as column><#if column.key><#assign i=i+1><#if (i>1)>,</#if>${column.propertyType} ${column.propertyName}</#if></#list>) {
        <#if keys?size != 0 && keys?size != 1>
        java.util.Map keyMap = new java.util.HashMap();
            <#list columnList as column>
                <#if column.key>
        keyMap.put("${column.propertyName}",${column.propertyName});
                </#if>
            </#list>
        return this.selectOne("${voClassName}Mapper.get${voClassName}ById",keyMap);
        <#else>
            <#list columnList as column>
                <#if column.key>
        return this.selectOne("${voClassName}Mapper.get${voClassName}ById",${column.propertyName});
                </#if>
            </#list>
        </#if>
    }

    public List<${voClassName}> get${voClassName}List(${voClassName} ${parmString}) {
        return this.selectList("${voClassName}Mapper.get${voClassName}List",${parmString});
    }
}
