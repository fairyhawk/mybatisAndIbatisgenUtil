<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd">
<beans>
<#list tableList as table>
    <bean id="${table.parmString}Service" class="${table.packageName}.service.${table.voClassName}Impl" parent="baseService"/>
</#list>
</beans>