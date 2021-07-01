This is a simple spring boot application for employee Search on various criteria.

This application is create using following software
Java  11
Spring boot
Maven 3


To run this application from command line
mvn clean install
run comman
java -jar target/<jarfileName>


to test application
use postman or any other rest client. this employee search tool has basic authorisation is implemented so one has to provide 
basis authorisation tag on header


basic auth credential are stored inmemory
admin/admin as username and password.

one can get the request body information on
http://localhost:8080/employee-openapi

Open-API is implemented to rest documentation. Also for better performance caching is also implemented.
