<#assign curlyBrace = "}">
[
<#if searchResult?exists>
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
 "size":"${scriptNode.size}",
 "displayPath":"${scriptNode.displayPath}",
 "isContainer":${scriptNode.isContainer?string},
 "isDocument":${scriptNode.isDocument?string},
 "isCategory":${scriptNode.isCategory?string},
 <#if scriptNode.hasChildren?exists>
 "hasChildren":${scriptNode.hasChildren?string},
 </#if>
 <#if scriptNode.parent?exists>
 "parentNodeId":"${scriptNode.parent.id}",
 "parentNodeRef":"${scriptNode.parent.nodeRef}",
 "parentNodeName":"${scriptNode.parent.name}",
 </#if>
 "metadata":{
 <#list scriptNode.properties?keys as prop>
    <#if scriptNode.properties[prop]?exists>
     <#assign propertyName = prop?substring(prop?last_index_of(curlyBrace)+1)>
     <#if scriptNode.properties[prop]?is_date>
        "${propertyName}":"${scriptNode.properties[prop]?datetime}"<#if prop_has_next>,</#if>
     <#else>
        "${propertyName}":"${scriptNode.properties[prop]?string}"<#if prop_has_next>,</#if>
     </#if>
    </#if>
 </#list>
 }
 <#if scriptNode.createThumbnail?exists>
 </#if>
 <#if scriptNode.getThumbnails?exists>
 ,"thumbnails":[
 <#list scriptNode.getThumbnails as thumbnail>
  	{
  	"name":"${thumbnail.name}",
  	"type":"${thumbnail.type}",
 	"nodeId":"${thumbnail.id}",
 	"nodeRef":"${thumbnail.nodeRef}",
 	"displayPath":"${thumbnail.displayPath}",
 	"isLinkToDocument":"${thumbnail.isLinkToDocument}",
 	"content":"${thumbnail.properties.content}"
 	}<#if thumbnail_has_next>,</#if>
 </#list>
 ]
 </#if>
}<#if scriptNode_has_next>,</#if>
</#list>
 </#if>
]