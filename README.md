# resteasydemo
Example project with RESTEasy and Swagger integration 

## Project Setup (Maven)

clone the project

import as maven project into IDE

run Maven update

run Maven build

```
The above command will compile the project and generate the Swagger JSON file:
target/swagger/jaxrs-api.json
```

## Example end-points
```
http://localhost:8080/resteasydemo/user-management/users
http://localhost:8080/resteasydemo/user-management/user?{id}
```

## Configuring Swagger with rest end-points
```
1. Go to the Swagger UI GitHub project [https://github.com/swagger-api/swagger-ui]
2. Click Clone or download
3. Copy the dist folder from swagger-ui to your tomcat/webapps folder
4. rename dist to your preferred name, eg:swagger-ui
5. Copy jaxrs-api.json to tomcat/webapps/swagger-ui folder 
5. Inside your swagger-ui folder, open index.html
6. Look for the following code:
	url: "http://petstore.swagger.io/v2/swagger.json"
7. Change the url value to your rest end point URL. 
	For example:url: "http://localhost:8080/swagger-ui/jaxrs-api.json"
8. start  your tomcat

open http://localhost:8080/swagger-ui/index.html in your browser 
```

## References
```
https://resteasy.github.io/2020/05/22/swagger/
```