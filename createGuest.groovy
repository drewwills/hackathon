Properties props = evaluate(new File("props.groovy"));

/*
 * Prompt the user for inputs
 */
String firstName = System.console().readLine('What is your first name?');
String middleName = System.console().readLine('What is your middle name?');
String lastName = System.console().readLine('What is your last name?');
String logonId = System.console().readLine('What is your email address?');
String logonPassword = System.console().readLine('Please choose a password:');
String logonPasswordVerify = System.console().readLine('Retype password:');
Boolean sendMeEmail = System.console().readLine('Do you wish to receive email from Target(Y/n)?').equalsIgnoreCase("y");

/*
 * Prepare the JSON payload
 */
String requestJson = """{
	\"firstName\" : \"$firstName\",
	\"middleName\":\"$middleName\",
	\"lastName\" : \"$lastName\",
	\"logonId\" : \"$logonId\",
	\"logonPassword\" : \"$logonPassword\",
	\"logonPasswordVerify\" : \"$logonPasswordVerify\",
	\"sendMeEmail\" : \"$sendMeEmail\"
}
""";
println '## REQUEST JSON ##';
println requestJson;
println '';

/*
 * Invoke the API
 */
String apiUrl = "${props['api.server.protocol']}://${props['api.server.hostname']}/guests/v3?key=${props['api.key']}";
println "apiUrl=$apiUrl";

//ApiInvoker invoker = new ApiInvoker();
def invoker = evaluate(new File("target-api.groovy"));
def response = invoker.invoke(apiUrl, 'application/json', requestJson);
println "HTTP STATUS=$response.status";
println '';
println '## RESPONSE JSON ##';
println response.body;
println '';


