main();

function main() {
	var searchRequest = json;
	if (searchRequest === null) {
		status.setCode(status.STATUS_BAD_REQUEST,
				"Request json parameters are missing.");
		return;
	}
	if ((searchRequest.isNull("query"))
			|| (searchRequest.get("query").length() == 0)) {
		status.setCode(status.STATUS_BAD_REQUEST,
				"query is missing in request parameter");
		return;
	}
	var requestObject = jsonUtils.toObject(searchRequest);
	var results = search.query(requestObject);
	model.searchResult = results;
}

function jsonToObject(p_name) {
	var object = {};
	var jsonObj = json.get(p_name);
	var names = jsonObj.names();
	var name;
	for ( var i = 0, j = names.length(); i < j; i++) {
		name = names.get(i);
		object[name] = jsonObj.get(name);
	}
	return object;
}

function jsonToArray(p_name) {
	var array = [];
	var jsonArray = json.get(p_name);
	for ( var i = 0, j = jsonArray.length(); i < j; i++) {
		array.push(jsonArray.get(i));
	}
	return array;
}


