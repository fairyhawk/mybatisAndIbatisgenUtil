<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<#assign one = 1>
<sqlMap namespace="${voClassName}Mapper">

        <resultMap id="${voClassName}Result" type="${voClassName}">
            <#list columnList as column>
            <result property="${column.propertyName}" column="${column.columnName}"/>
            </#list>
        </resultMap>

        <sql id="${tableName}_columns">
            <#list columnList as column>
            ${tableName}.${column.columnName}<#if column_index+1< columnList?size>,</#if>
            </#list>
        </sql>

        <sql id="${tableName}_properties">
            <#list columnList as column>
            #${"{"}${column.propertyName}${"}"}<#if column_index+1< columnList?size>,</#if>
            </#list>
        </sql>

        <insert id="create${voClassName}" parameterType="${voClassName}" keyColumn="id" keyProperty="id">
            insert INTO ${tableName} (<include refid="${tableName}_columns"/>) VALUES (<include refid="${tableName}_properties"/>)
        </insert>

        <delete id="delete${voClassName}ById" parameterType="<#if keys?size != 0 && keys?size != 1>java.util.Map<#else><#list columnList as column><#if column.key>${column.propertyType}</#if></#list></#if>">
            delete from ${tableName}
            <#if keys?size!=0>
            where<#assign i=0>
                <#list columnList as column><#if column.key><#assign i=i+1><#if (i>1)> AND </#if>${column.columnName} = #${"{"}<#if keys?size != 1>${column.propertyName}<#else>value</#if>${"}"}</#if>
                </#list>
            </#if>
        </delete>

        <update id="update${voClassName}" parameterType="${voClassName}">
            update ${tableName} SET
            <#list columnList as column>
                ${column.columnName} = #${"{"}${column.propertyName}${"}"}<#if column_index+1< columnList?size>,</#if>
            </#list>
            <#if keys?size!=0>
            where<#assign i=0>
                <#list columnList as column><#if column.key><#assign i=i+1><#if (i>1)> AND </#if>${column.columnName} = #${"{"}${column.propertyName}${"}"}</#if>
                </#list>
            </#if>
        </update>

        <select id="get${voClassName}ById" resultMap="${voClassName}Result" parameterType="<#if keys?size != 0 && keys?size != 1>java.util.Map<#else><#list columnList as column><#if column.key>${column.propertyType}</#if></#list></#if>">
            select
            <include refid="${tableName}_columns"/>
            from ${tableName}
            <#if keys?size!=0>
            where<#assign i=0>
                <#list columnList as column><#if column.key><#assign i=i+1><#if (i>1)> AND </#if>${column.columnName} = #<#if keys?size != 1>${column.propertyName}<#else>value</#if>#</#if>
                </#list>
            </#if>
        </select>
		
        <select id="get${voClassName}List" resultMap="${voClassName}Result" parameterType="Query${voClassName}Condition">
            select
            <include refid="${tableName}_columns"/>
            from ${tableName}
        </select>
        
</sqlMap>