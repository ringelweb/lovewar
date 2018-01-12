package org.inayat.novo.ringelweb.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.inayat.novo.ringelweb.model.UserModel;
import org.inayat.novo.ringelweb.service.UserService;
import org.inayat.novo.ringelweb.serviceImpl.UserServiceImpl;



@Path("/user")
@Produces(MediaType.APPLICATION_JSON)

public class UserResource {
	
	@POST
	@Path("/signup")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Signup(UserModel user) {
		System.out.println("Entered in resources|signup.");
		UserService service=new UserServiceImpl();
		user=service.doRegister(user);
		return	Response.status(Status.CREATED).entity(user).build();
		
	}

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Login(UserModel user) {
		System.out.println("Entered in resource|login.");
		UserService service = new UserServiceImpl();
		user = service.doLogin(user);
		
		
		
		return	Response.status(Status.CREATED).entity(userModel).build();
		
	}
}
