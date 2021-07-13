# Spring-Boot-Crud-Api-Authentication-JWT
INTRODUCTION:
	I BUILD  A SIMPLE SPRING BOOT APPLICATION WITH HTTP ENDPOINTS THAT EXPOSE AN API.
	I TESTED USING API TESTER.
	IDE – SPRING TOOL SUITE(STS).
	JAVA VERSION: 1.8
	SPRING BOOT VERSION:2.5.1
	SPRING BOOT OFFERS A FAST WAY TO BUILD AN APPLICATIONS.
	WITH SPRING BOOT YOU CAN FOCUS MORE ON BUSSINESS FEATURE AND LESS ON INFRASTRUCTURE.

















ABOUT PACKAGES AND CLASSES:
HERE I CREATED 8 PACKAGES LIKE:
	CONFIGURE
	CONTROLLER
	FILTER
	MODEL
	REPOSITORY
	SERVICE
	UTIL



CONFIGURE:
•	IT’S HAVING SECURITYCONFIG CLASS.
CONTROLLER:
•	IT’S HAVING TWO CLASSES – ALSTONIANRESOURCE  AND TOPICCONTROLLER.
 FILTER:
•	IT’S HAVING JWTREQUESTFILTER CLASSES.
 MODEL:
•	IT’S HAVING THREE CLASSES: AUTHENTICATIONREQUEST,       AUTHENTICATIONRESPONSE AND TOPIC.
REPOSITORY:
•	IT’S HAVING TOPIC REPOSITORY INTERFACE.
SERVIC:
•	IT’S HAVING MYUSERDETAILSSERVICE.
UTIL:
•	IT’S HAVING JWTUTIL CLASS.



 

 OBJECTIVE:    
	CREATE A NEW AUTHENTICATION API ENDPOINT.
	EXAMINE EVERY INCOMING REQUEST FOR VALID JWT AND AUTHORIZE.

CONTROLLER:
            ALSTONIANRESOURCE{ } CONTROLLER CLASS.
                    @REQUESTMAPPING(VALUE="/AUTHENTICATE", METHOD=REQUESTMETHOD.POST)
Authenticate():
	I created an authenticate method an endpoint, which is mapped to create authentication token.
	It does authenticate all I need to do create a JWT token.
	Ability to needs user details in order to create a GWT, so I am going to call the user details service that load user by user name at this point.
	Somebody is authenticated with the username and password.
	FOR EXAMPLE:

  


POST REQUEST: http://localhost:8080 /authenticate
	All I have is username and password, I will get an instance to the user details and pass that into the JWT token and it send an authentication response and send it back now with this I have an endpoint which does authentication.

FOR EXAMPLE:
 
AFTER MAKING POST REQUEST IT’S SEND BACK JWT TOKEN.
 

WITHOUT AUTHENTICATION DOES’T CALL THE API:
TopicController:
POST Request: http://localhost:8080/topics/createTopic

 
AFTER POST THE REQUEST IT’S SHOW ACCESS DENIED.
 
ABOUT JWT TOKEN:
Authorization header and the Bearer and JWT value.
Intercept all incoming request.
{
"jwt": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJmb28iLCJleHAiOjE2MjM2ODc3NDIsImlhdCI6MTYyMzY4NzE0Mn0.xAFkpo1zgdm12pgsRvQbp6S9wd2Unp-d22P330Xk5G8"
}
 
	Extract jwt from the header.
	Validate and set in execution context.
	doFilterInternal() method examine the incoming request.
	Take the Request and Response in the header
	In the filter chain and ending the request.


 
	Looked into the header and see if that gwt is valid, it’s get the user details out of the user detailed service and save it in the security context.
 


	Hence Authentication is success.
	After that I can access all the Api.
 
GET REQUEST: http://localhost:8080/topics/createTopic                           (FOR ALLTOPIC)
 



	It’s gives the all topic present in a database.
 
FIND THE TOPIC BY ID:
GET REQUEST: http://localhost:8080/topics/java

 

Here topic{id} java is id.
Then result is based on the id.
 
notes?title=xyz  
GET: http://localhost:8080/topics?name=java
	In case I am passing @RequestParam to get the value in the form of parameter.
	Here I am using Query Parameter in Tester Api.
 
	In my repository and service layers, the return is Optional<Topics>, i.e. it's either empty or one Topics result.
	There's been a bit of a mix-up here: The verb "create" has no place in the URI, and the structure suggests that the action is identified by the URI, not by the HTTP verb.

Summary:
	To connect to our database we added the wright dependencies Spring data jpa and the Derby database .
Model class:
	I marked our entity class as an entity class by using a couple of annotation.
	It was the identity and the add id for the member variable which is going to correspond to a primary key column.
Repository:
	I created an interface rather than called TopicRepository which extended a corresponding that come out of the box which was a CRUD repository which gives the generic element and that was it this is all we had to do and we got all the CRUD operations just like that.
          Service:
	I use a findAll() method this is actually a slightly more complicated then all those other one line stuff because this returns an interval and I had to iterate over it and that to a list that I created over here and return if but lok at all the other methods fine.
	findOne(),save(),delete() all those ae methods that kinds of come out to the box because we implemented this CRUD repository.
	So that why I find this fascinating you know compared to do using JDBC years ago where they had to write every query manually .
	This is supper easy and very convenient.
Controller:
getAllTopic(){}
	It takes to map the /topics/createTopic request that we get from the app to return the List of Topic.
	The generated Json has key names corresponding to property names of the Topic class.
	The Json values are the values of those properties.
SecurityConfigure{}:
	http.csrf().disable().authorizeRequests().antMatchers("/authenticate").permitAll().anyRequest().authenticated()
o	.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

	(“/authenticate”).permitAll()  after Authentication its permits the All API.
doFilterInternal(){}:
	Examine the incoming request in the header.
