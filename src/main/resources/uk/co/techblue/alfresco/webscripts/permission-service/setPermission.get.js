var folderNode =  search.luceneSearch("@sys\\:node-uuid:"+args.nodeId);
var authority = args.authorityType;
var userGroupType=args.userGroupType;
if(folderNode.length == 1){
folderNode[0].setPermission(authority, userGroupType);
model.permissionStatus = "Permission were set successfully!";
}else  if (folderNode.length == 0){
model.permissionStatus = "Folder not found";
}else{
model.permissionStatus = "Duplicate folder found";
}