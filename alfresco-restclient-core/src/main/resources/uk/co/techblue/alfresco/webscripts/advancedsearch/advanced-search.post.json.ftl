<#assign curlyBrace = "}">
[
<#list searchResult as scriptNode>
{
 "nodeId":"${scriptNode.id}",
 "nodeRef":"${scriptNode.nodeRef}",
 "storeType":"${scriptNode.storeType}",
 "storeId":"${scriptNode.storeId}",
 <#if scriptNode.qNameType?exists>
 "qNameType":"${scriptNode.qNameType}",
 </#if>
 "type":"${scriptNode.type}",
 "typeShort":"${scriptNode.typeShort}",
 "name":"${scriptNode.name}",
 "isContainer":${scriptNode.isContainer?string},
 "isDocument":${scriptNode.isDocument?string},
 "isCategory":${scriptNode.isCategory?string},
 <#if scriptNode.parent?exists>
 "parentNodeId":"${scriptNode.parent.id}",
 "parentNodeRef":"${scriptNode.parent.nodeRef}",
 "parentNodeName":"${scriptNode.parent.name}",
 </#if>
 "type":"${scriptNode.type}",
 "metadata":{
 <#list scriptNode.properties?keys as prop>
    <#if scriptNode.properties[prop]?exists>
     <#assign propertyName = prop?substring(prop?last_index_of(curlyBrace)+1)>
     <#if scriptNode.properties[prop]?is_date>
        "${propertyName}" = "${scriptNode.properties[prop]?datetime}",
     <#else>
        "${propertyName}" = "${scriptNode.properties[prop]?string}",
     </#if>
    </#if>
 </#list>
 }
}
</#list>
]