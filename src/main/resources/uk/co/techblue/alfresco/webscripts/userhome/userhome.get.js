
main();

function main() {

	// Get the user name of the person to get
	var urlElements = url.extension.split("/");
	var userName = urlElements[0];
	if (userName === null || userName == '') {
		status.setCode(status.STATUS_BAD_REQUEST,
				"Username is missing in path.");
		return;
	}
	// Get the person who has this username
	var person = people.getPerson(userName);
	if (person != null) {
		model.homeFolder = person.properties.homeFolder;
	} else {
		status.setCode(status.STATUS_NOT_FOUND, "Person " + userName
				+ " does not exist");
	}
}

function endsWith(str, suffix) {
    return str.indexOf(suffix, str.length - suffix.length) !== -1;
}