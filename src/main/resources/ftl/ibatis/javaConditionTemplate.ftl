package ${packageName}.condition;

public class Query${voClassName}Condition {
    <#list columnList as column>
        <#if column.key>
    private ${column.propertyType} ${column.propertyName};
        </#if>
    </#list>
        
    <#list columnList as column>
        <#if column.key>
    public ${column.propertyType} get${column.methodName}(){
        return ${column.propertyName};
    }

    public void set${column.methodName}(${column.propertyType} ${column.propertyName}){
        this.${column.propertyName} = ${column.propertyName};
    }
        </#if>
    </#list>
}