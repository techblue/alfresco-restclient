<#if homeFolder?exists>
{
 "nodeId":"${homeFolder.id}",
 "nodeRef":"${homeFolder.nodeRef}",
 "storeType":"${homeFolder.storeType}",
 "storeId":"${homeFolder.storeId}",
 <#if homeFolder.qNameType?exists>
 "qNameType":"${homeFolder.qNameType}",
 </#if>
 "type":"${homeFolder.type}",
 "typeShort":"${homeFolder.typeShort}",
 "name":"${homeFolder.name}",
 "size":"${homeFolder.size}",
 "isContainer":${homeFolder.isContainer?string},
 "isDocument":${homeFolder.isDocument?string},
 "isCategory":${homeFolder.isCategory?string},
 <#if homeFolder.hasChildren?exists>
 "hasChildren":${homeFolder.hasChildren?string},
 </#if>
 <#if homeFolder.parent?exists>
 "parentNodeId":"${homeFolder.parent.id}",
 "parentNodeRef":"${homeFolder.parent.nodeRef}",
 "parentNodeName":"${homeFolder.parent.name}",
 </#if>
 "displayPath":"${homeFolder.displayPath}"
 }
 </#if>