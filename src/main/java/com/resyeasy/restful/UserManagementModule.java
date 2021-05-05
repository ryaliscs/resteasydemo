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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

/**
 * Rest Service for User management. Allows to Add, List, Update and Read Users
 * 
 * References :
 * 
 * https://resteasy.github.io/2020/05/22/swagger/
 *
 */
@Path("user-management")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserManagementModule {

	/**
	 * Get all users {@code /users} Returns all the users
	 * 
	 * @return all the users
	 */
	@GET
	@Path("users")
	@Operation(summary = "Get all Users", description = "Get list of users", responses = {
			@ApiResponse(responseCode = "200", description = "List of Users", //
					content = @Content(mediaType = "application/json", //
							schema = @Schema(implementation = PersonPOJO.class))) })
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
	@Path("user/{id}")
	@Operation(summary = "Get user by User Id", description = "Retuns the User", responses = {
			@ApiResponse(responseCode = "200", description = "User found", //
					content = @Content(mediaType = "application/json", //
							schema = @Schema(implementation = PersonPOJO.class))),
			@ApiResponse(responseCode = "204", description = "User not found") })
	public Response getUser(
			@Parameter(description = "The User Id of the User", required = true) @PathParam("id") int id) {
		PersonPOJO user = UserRepository.getUser(id);
		if (user != null) {
			return Response.ok(user).build();
		}
		return Response.noContent().build();
	}

	/**
	 * Create User: Creates the user as per the given aPerson POJO
	 * 
	 * @param aPerson Person to be created
	 * @return the created Person
	 */
	@POST
	@Path("user")
	@Operation(summary = "Create user", description = "Creates a User", responses = {
			@ApiResponse(responseCode = "200", description = "User created", //
					content = @Content(mediaType = "application/json", //
							schema = @Schema(implementation = PersonPOJO.class))),
			@ApiResponse(responseCode = "409", description = "User not found") })
	public Response createUser(@RequestBody(description = "Created user object", required = true, //
			content = @Content(schema = @Schema(implementation = PersonPOJO.class))) PersonPOJO aPerson) {
		PersonPOJO user = UserRepository.createUser(aPerson);
		if (user == null) {
			return Response.status(Response.Status.CONFLICT).build();
		}
		return Response.ok(user).build();

	}

	/**
	 * Update User : updates the user as per aPerson parameter
	 * 
	 * @param aPerson Person data to be updated
	 * @return updated {@link PersonPOJO} as response
	 */
	@PUT
	@Path("user")
	@Operation(summary = "Update User", description = "Updates the User", responses = {
			@ApiResponse(responseCode = "200", description = "User updated", //
					content = @Content(mediaType = "application/json", //
							schema = @Schema(implementation = PersonPOJO.class))),
			@ApiResponse(responseCode = "400", description = "User not found") })
	public Response updateUser(@RequestBody(description = "Updates the User object", required = true, //
			content = @Content(schema = @Schema(implementation = PersonPOJO.class))) PersonPOJO aPerson) {
		PersonPOJO user = UserRepository.updateUser(aPerson);
		if (user == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.ok(user).build();

	}

	/**
	 * Delete User: Delete the user by given User Id
	 * 
	 * @param id Id of the user to be deleted
	 * @return {@link Response.Status.OK} if user is successfully deleted, otherwise
	 *         returns {@link Response.Status.CONFLICT}
	 */
	@DELETE
	@Path("user/{id}")
	@Operation(summary = "Delete user by User Id", description = "Removes the User", responses = {
			@ApiResponse(responseCode = "200", description = "User deleted", //
					content = @Content(mediaType = "application/json", //
							schema = @Schema(implementation = PersonPOJO.class))),
			@ApiResponse(responseCode = "409", description = "User not found") })
	public Response deleteUser(
			@Parameter(description = "The User Id of the User to be removed", required = true) @PathParam("id") int id) {
		if (UserRepository.deleteUser(id)) {
			return Response.ok().build();
		}

		return Response.status(Response.Status.CONFLICT).build();
	}
}
