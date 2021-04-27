package com.resyeasy.restful;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.resyeasy.data.PersonPOJO;
import com.resyeasy.repo.UserRepository;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

/**
 * References :
 * 
 * https://www.javaguides.net/2020/01/resteasy-crud-example-tutorial.html
 * 
 * http://www.mastertheboss.com/jboss-frameworks/resteasy/swagger-quickstart-tutorial
 * 
 * https://docs.swagger.io/service/java/tomcat-resteasy-2.html
 *
 */
@Path("/user-management")
@Api(value = "user-management", description = "RestEasy demo")
public class UserManagementModule {

	/**
	 * Get all users {@code /users} Returns all the users
	 * 
	 * @return all the users
	 */
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getAllUsers() {
		return Response.ok(UserRepository.getAllUsers()).build();
	}

	/**
	 * get user {@code /user?id=?}
	 * 
	 * @param id ID of the user
	 * @return returns the user with the given ID
	 */
	@GET
	@Path("/user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Get user by user id", response = PersonPOJO.class, position = 0)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User found"),
			@ApiResponse(code = 204, message = "User not found") })
	public Response getUser(@PathParam("id") int id) {
		PersonPOJO user = UserRepository.getUser(id);
		if (user != null) {
			return Response.ok(user).build();
		}
		return Response.noContent().build();
	}

	@POST
	@Path("/user")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser(PersonPOJO aPerson) {
		PersonPOJO user = UserRepository.createUser(aPerson);
		if (user == null) {
			return Response.status(Response.Status.CONFLICT).build();
		}
		return Response.ok(user).build();

	}

	@PUT
	@Path("/user")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUser(PersonPOJO aPerson) {
		PersonPOJO user = UserRepository.updateUser(aPerson);
		if (user == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.ok(user).build();

	}

	@DELETE
	@Path("/user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUser(@PathParam("id") int id) {
		if (UserRepository.deleteUser(id)) {
			return Response.ok().build();
		}

		return Response.status(Response.Status.CONFLICT).build();
	}
}
