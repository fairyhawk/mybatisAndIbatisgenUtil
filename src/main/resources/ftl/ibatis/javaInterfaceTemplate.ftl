package ${packageName}.service;

import java.util.List;
import ${packageName}.domain.${voClassName};
import ${packageName}.condition.Query${voClassName}Condition;

/**
 * ${voClassName}管理接口
 * User: guoqiang.liu
 * Date: ${date?string("yyyy-MM-dd")}
 */
public interface I${voClassName} {
    /**
     * 添加${voClassName}
     * @param ${parmString} 要添加的${voClassName}
     * @return id
     */
    public <#if keys?size != 0 && keys?size != 1>void<#else><#list columnList as column><#if column.key>${column.returnType}</#if></#list></#if> add${voClassName}(${voClassName} ${parmString});

    /**
     * 根据id删除一个${voClassName}
<#list columnList as column>
    <#if column.key>
     * @param ${column.propertyName} 要删除的id
    </#if>
</#list>
     */
    public void del${voClassName}ById(<#assign i=0><#list columnList as column><#if column.key><#assign i=i+1><#if (i>1)>,</#if>${column.propertyType} ${column.propertyName}</#if></#list>);

    /**
     * 修改${voClassName}
     * @param ${parmString} 要修改的${voClassName}
     */
    public void update${voClassName}(${voClassName} ${parmString});

    /**
     * 根据id获取单个${voClassName}对象
<#list columnList as column>
    <#if column.key>
     * @param ${column.propertyName} 要查询的id
    </#if>
</#list>
     * @return 年级
     */
    public ${voClassName} get${voClassName}ById(<#assign i=0><#list columnList as column><#if column.key><#assign i=i+1><#if (i>1)>,</#if>${column.propertyType} ${column.propertyName}</#if></#list>);

    /**
     * 根据条件获取${voClassName}列表
     * @param query${voClassName}Condition 查询条件
     * @return 查询结果
     */
    public List<${voClassName}> get${voClassName}List(Query${voClassName}Condition query${voClassName}Condition);
}