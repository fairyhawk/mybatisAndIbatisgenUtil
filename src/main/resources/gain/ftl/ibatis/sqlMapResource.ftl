<#list nsvoList as nsVO>
<#list nsVO.tableList as table>
<sqlMap resource="config/ibatis/${nsVO.name}/${table.voClassName}.xml"/>
</#list>
</#list>