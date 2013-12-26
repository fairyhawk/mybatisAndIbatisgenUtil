package ${packageName}.domain;

import java.io.Serializable;

public class ${voClassName} implements Serializable{
    <#list columnList as column>
    private ${column.propertyType} ${column.propertyName};
    </#list>
    <#list columnList as column>
        
    public ${column.propertyType} get${column.methodName}(){
        return ${column.propertyName};
    }

    public void set${column.methodName}(${column.propertyType} ${column.propertyName}){
        this.${column.propertyName} = ${column.propertyName}; 
    }
    </#list>
}
