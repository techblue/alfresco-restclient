  [
<#list results as res>
{
"objectId":"${res.getPropertyValueByQueryName('cmis:objectId')}",
"name":"${res.getPropertyValueByQueryName('cmis:name')}"
}<#if res_has_next>,</#if>
</#list>
]