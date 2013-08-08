function main() {

	// Get the user name of the person to get
	var urlElements = url.extension.split("/");
	var userName = urlElements[0];
	// Get the person who has that user name
	var person = people.getPerson(userName);
	if (person != null) {
		model.person = person;
		model.h = person.properties.homeFolder;
	} else {
		status.setCode(status.STATUS_NOT_FOUND, "Person " + userName
				+ " does not exist");
	}
}

main();