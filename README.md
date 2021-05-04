# resteasydemo
Example project with RESTEasy and Swagger integration 

## Project Setup (Maven)

clone the project

import as maven project into IDE

run Maven update

run Maven build

## Example end-points
```
http://localhost:8080/resteasydemo/api/user-management/users
http://localhost:8080/resteasydemo/api/user-management/user?{id}
```

## Configuring Swagger as a part of web application 
```
1. Go to the Swagger UI GitHub project [https://github.com/swagger-api/swagger-ui]
2. Click Clone or download
3. Copy the dist folder contents from swagger-ui to your resource folder eg: /src/main/webapp/swagger
4. Inside your swagger folder, open index.html
5. Look for the following code:
	url: "http://petstore.swagger.io/v2/swagger.json"
6. Change the url value to your openapi rest end point URL. 
	For example:url: "http://localhost:8080/resteasydemo/openapi/openapi.json"
7. Deploy the application 	
8. start  your tomcat

open http://localhost:8080/resteasydemo/swagger/index.html in your browser 
```

## Configuring and deploy Swagger outside the web application 
```
1. Go to the Swagger UI GitHub project [https://github.com/swagger-api/swagger-ui]
2. Click Clone or download
3. Copy the dist folder from swagger-ui to your tomcat/webapps folder
4. rename dist to your preferred name, eg:swagger-ui
5. Inside your swagger-ui folder, open index.html
6. Look for the following code:
	url: "http://petstore.swagger.io/v2/swagger.json"
7. Change the url value to your openapi rest end point URL. 
	For example:url: "http://localhost:8080/resteasydemo/openapi/openapi.json"
8. start  your tomcat

open http://localhost:8080/swagger-ui/index.html in your browser 
```

## References
```
https://resteasy.github.io/2020/05/22/swagger/
https://github.com/swagger-api/swagger-samples/tree/2.0/java/java-jaxrs2-openapiservlet
https://github.com/swagger-api/swagger-core/wiki/Swagger-2.X---Annotations
```