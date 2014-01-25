package ${packageName}.entity.${mypackageName};

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ${voClassName} implements Serializable{
    <#list columnList as column>
    private ${column.propertyType} ${column.propertyName};
    </#list>
}
