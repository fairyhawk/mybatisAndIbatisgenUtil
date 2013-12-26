<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE sqlMap
        PUBLIC "-//ibatis.apache.org//DTD SQL Map 2.0//EN"
        "http://ibatis.apache.org/dtd/sql-map-2.dtd">
<#assign one = 1>
<sqlMap namespace="${voClassName}_NS">
        <!--table:${tableName}-->
        <typeAlias alias="${voClassName}" type="${packageName}.domain.${voClassName}"/>
        

        <resultMap id="${voClassName}Result" class="${voClassName}">
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
            #${column.propertyName}#<#if column_index+1< columnList?size>,</#if>
            </#list>
        </sql>

        <insert id="create${voClassName}" parameterClass="${voClassName}">
            INSERT INTO ${tableName} (<include refid="${voClassName}_NS.${tableName}_columns"/>) VALUES (<include refid="${voClassName}_NS.${tableName}_properties"/>)
            <#if keys?size != 0 && keys?size != 1>
            <#else>
            <selectKey resultClass="<#list columnList as column><#if column.key>${column.propertyType}</#if></#list>" type="post" keyProperty="<#list columnList as column><#if column.key>${column.propertyName}</#if></#list>" >   
                <include refid="public_sql.increment_sql"/>
            </selectKey>
            </#if>
        </insert>

        <delete id="delete${voClassName}ById" parameterClass="<#if keys?size != 0 && keys?size != 1>java.util.Map<#else><#list columnList as column><#if column.key>${column.propertyType}</#if></#list></#if>">
            DELETE FROM ${tableName}
            <#if keys?size!=0>
            WHERE<#assign i=0>
                <#list columnList as column><#if column.key><#assign i=i+1><#if (i>1)> AND </#if>${column.columnName} = #<#if keys?size != 1>${column.propertyName}<#else>value</#if>#</#if>
                </#list>
            </#if>
        </delete>

        <update id="update${voClassName}" parameterClass="${voClassName}">
            UPDATE ${tableName} SET
            <#list columnList as column>
                ${column.columnName} = #${column.propertyName}#<#if column_index+1< columnList?size>,</#if>
            </#list>
            <#if keys?size!=0>
            WHERE<#assign i=0>
                <#list columnList as column><#if column.key><#assign i=i+1><#if (i>1)> AND </#if>${column.columnName} = #${column.propertyName}#</#if>
                </#list>
            </#if>
        </update>

        <select id="get${voClassName}ById" resultMap="${voClassName}_NS.${voClassName}Result" parameterClass="<#if keys?size != 0 && keys?size != 1>java.util.Map<#else><#list columnList as column><#if column.key>${column.propertyType}</#if></#list></#if>">
            SELECT
            <include refid="${voClassName}_NS.${tableName}_columns"/>
            FROM ${tableName}
            <#if keys?size!=0>
            WHERE<#assign i=0>
                <#list columnList as column><#if column.key><#assign i=i+1><#if (i>1)> AND </#if>${column.columnName} = #<#if keys?size != 1>${column.propertyName}<#else>value</#if>#</#if>
                </#list>
            </#if>
        </select>

        <select id="get${voClassName}List" resultMap="${voClassName}_NS.${voClassName}Result" parameterClass="${voClassName}">
            SELECT
            <include refid="${voClassName}_NS.${tableName}_columns"/>
            FROM ${tableName}
        </select>
        <!--end-->
</sqlMap>
