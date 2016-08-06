var query = args.query;
var cmisConnection = cmis.getConnection();
var cmisSession    = cmisConnection.getSession();
var results = cmisSession.query(query, false);
model.results = results.iterator();