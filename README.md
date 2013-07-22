Gr8Conf 2013 Hackathon
=========

This project is a hackathon submission.  It's a simple groovy script that prompts the user for inputs, then creates a Target guest account based on those inputs.

*You will need to add your own API key to hackathon.properties.*

Invoke it thusly:

    $groovy createGuest.groovy

You should see something like...

    ## USING PROPERTIES ##
    api.key={api.key}
    api.server.protocol=https
    api.server.hostname=stage-api.target.com

    What is your first name?drew
    What is your middle name?bob
    What is your last name?wills
    What is your email address?{email}
    Please choose a password:{passwd}
    Retype password:{passwd}
    Do you wish to receive email from Target?mmm
    ## REQUEST JSON ##
    {
        "firstName" : "drew",
        "middleName":"bob",
        "lastName" : "wills",
        "logonId" : "drew@unicon.net",
        "logonPassword" : "{passwd}",
        "logonPasswordVerify" : "{passwd}",
        "sendMeEmail" : "false"
    }


    apiUrl=https://stage-api.target.com/guests/v3?key={api.key}
    HTTP STATUS=201

    ## RESPONSE JSON ##

    {
        "city" : "",
         "state" : "",
         "firstName" : "drew",
         "lastName" : "wills",
         "logonId" : "{email}",
         "pluckToken" : "a=drew&amp;u=101263504&amp;e=drew%40unicon.net&amp;t=1374458527&amp;h=c6db0be9434d5ae9175868f7ef9c59fc",
         "screenName" : "drew",
         "personalizationID" : "123456789-727",
         "userId" : "12345678",
         "cartAmount" : "",
         "cartQuantity" : "",
         "accessToken" : "xxx"
    }




