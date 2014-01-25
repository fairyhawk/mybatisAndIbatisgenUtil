package ${packageName}.service;

import java.util.List;
import ${packageName}.domain.${voClassName};
import ${packageName}.condition.Query${voClassName}Condition;
import com.shangde.common.service.BaseService;

/**
 * ${voClassName}接口
 * User: qinggang.liu bis@foxmail.com
 * Date: ${date?string("yyyy-MM-dd")}
 */
@SuppressWarnings("unchecked")
public class ${voClassName}Impl extends BaseService implements I${voClassName}{
    public <#if keys?size != 0 && keys?size != 1>void<#else><#list columnList as column><#if column.key>${column.returnType}</#if></#list></#if> add${voClassName}(${voClassName} ${parmString}) {
        <#if keys?size != 0 && keys?size != 1><#else>return </#if>simpleDao.createEntity("${voClassName}_NS.create${voClassName}",${parmString});
    }

    public void del${voClassName}ById(<#assign i=0><#list columnList as column><#if column.key><#assign i=i+1><#if (i>1)>,</#if>${column.propertyType} ${column.propertyName}</#if></#list>){
        <#if keys?size != 0 && keys?size != 1>
        java.util.Map keyMap = new java.util.HashMap();
            <#list columnList as column>
                <#if column.key>
        keyMap.put("${column.propertyName}",${column.propertyName});
                </#if>
            </#list>
        simpleDao.deleteEntity("${voClassName}_NS.delete${voClassName}ById",keyMap);
        <#else>
            <#list columnList as column>
                <#if column.key>
        simpleDao.deleteEntity("${voClassName}_NS.delete${voClassName}ById",${column.propertyName});
                </#if>
            </#list>
        </#if>
    }

    public void update${voClassName}(${voClassName} ${parmString}) {
        simpleDao.updateEntity("${voClassName}_NS.update${voClassName}",${parmString});
    }

    public ${voClassName} get${voClassName}ById(<#assign i=0><#list columnList as column><#if column.key><#assign i=i+1><#if (i>1)>,</#if>${column.propertyType} ${column.propertyName}</#if></#list>) {
        <#if keys?size != 0 && keys?size != 1>
        java.util.Map keyMap = new java.util.HashMap();
            <#list columnList as column>
                <#if column.key>
        keyMap.put("${column.propertyName}",${column.propertyName});
                </#if>
            </#list>
        return simpleDao.getEntity("${voClassName}_NS.get${voClassName}ById",keyMap);
        <#else>
            <#list columnList as column>
                <#if column.key>
        return simpleDao.getEntity("${voClassName}_NS.get${voClassName}ById",${column.propertyName});
                </#if>
            </#list>
        </#if>
    }

    public List<${voClassName}> get${voClassName}List(Query${voClassName}Condition query${voClassName}Condition) {
        return simpleDao.getForList("${voClassName}_NS.get${voClassName}List",query${voClassName}Condition);
    }
}
