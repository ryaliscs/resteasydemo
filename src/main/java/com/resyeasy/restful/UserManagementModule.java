package com.resyeasy.restful;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.resyeasy.data.PersonPOJO;
import com.resyeasy.repo.UserRepository;


/**
 * Reference :
 * https://howtodoinjava.com/resteasy/resteasy-tomcat-hello-world-application/
 * 
 * https://www.javainterviewpoint.com/resteasy-hello-world-example/
 *
 */
@Path("/user-management")
public class UserManagementModule {
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getAllUsers() {
		return Response.ok(UserRepository.getAllUsers()).build();
	}

	@GET
	@Path("/user")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@QueryParam("id") int id) {
		PersonPOJO user = UserRepository.getUser(id);
		if (user != null) {
			return Response.ok(user).build();
		}
		return Response.noContent().build();
	}
}
