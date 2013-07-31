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
	var requestObject = getNativeSearchRequest(searchRequest);
	var results = search.query(requestObject);
	model.searchResult = results;
}

function getNativeSearchRequest(searchJson) {
	var nativeObject = {};
	nativeObject.query = searchJson.get("query");
	if (searchJson.has("store")) {
		nativeObject.store = searchJson.get("store");
	}
	if (searchJson.has("language")) {
		nativeObject.language = searchJson.get("language");
	}
	if (searchJson.has("propertiesNamespace")) {
		nativeObject.propertiesNamespace = searchJson
				.get("propertiesNamespace");
	}
	if (searchJson.has("defaultResponseField")) {
		nativeObject.defaultResponseField = searchJson
				.get("defaultResponseField");
	}
	if (searchJson.has("onerror")) {
		nativeObject.onerror = searchJson.get("onerror");
	}

	if (searchJson.has("templates")) {
		var templateJsonArray = searchJson.getJSONArray("templates");
		if (templateJsonArray !== null) {
			var templateJsArray = [];
			for ( var i = 0; i < templateJsonArray.length(); i++) {
				var templateJson = templateJsonArray.getJSONObject(i);
				if (templateJson !== null) {
					var templateObject = {};
					templateObject.field = templateJson.get("field");
					templateObject.template = templateJson.get("template");
					templateJsArray.push(templateObject);
				}
			}
			nativeObject.templates = templateJsArray;
		}
	}

	if (searchJson.has("sort")) {
		var sortJsonArray = searchJson.getJSONArray("sort");
		if (sortJsonArray !== null) {
			var sortJsArray = [];
			for ( var i = 0; i < sortJsonArray.length(); i++) {
				var sortJson = sortJsonArray.getJSONObject(i);
				if (sortJson !== null) {
					var sortObject = {};
					sortObject.column = sortJson.get("column");
					sortObject.ascending = sortJson.get("ascending");
					sortJsArray.push(sortObject);
				}
			}
			nativeObject.sort = sortJsArray;
		}
	}

	if (searchJson.has("page")) {
		var pageJson = searchJson.get("page");
		if (pageJson !== null) {
			var pageObject = {};
			pageObject.maxItems = pageJson.get("maxItems");
			pageObject.skipCount = pageJson.get("skipCount");
			nativeObject.page = pageObject;
		}
	}
	
	return nativeObject;
}

function jsonToNativeObject(jsonObj) {
	var object = {};
	var names = jsonObj.names();
	for ( var i = 0; i < names.length(); i++) {
		var name = names.get(i);
		var value = jsonObj.get(name);
		if (typeof value.getJSONArray != 'undefined') {
			object[name] = jsonToNativeObject(value);
		} else if (typeof value.length != 'undefined') {
			object[name] = jsonToNativeArray(value);
		} else {
			object[name] = value;
		}
	}
	return object;
}

function jsonToNativeArray(jsonArray) {
	var nativeArray = [];
	for ( var i = 0, j = jsonArray.length(); i < j; i++) {
		var jsonObject = jsonArray.get(i);
		var nativeObject = jsonObject;
		if (typeof jsonObject.getJSONArray != 'undefined') {
			nativeObject = jsonToNativeObject(jsonObject);
		} else if (typeof jsonObject.length != 'undefined') {
			nativeObject = jsonToNativeArray(jsonObject);
		}
		nativeArray.push(nativeObject);
	}
	return nativeArray;
}
