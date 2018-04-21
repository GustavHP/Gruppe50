package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import Classes.User;



@Path("/test")
public class TestService {
	
	@GET
	public String getTest(){
		return "Helllo 50";
	}
	
	@Path("/login")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String login(User u) {
		
		if (u.getUsername().equals("Niklas")) {
			return "Dit navn er Niklas og dit password er: " + u.getPassword();
		}
		else {
			return "Kender ikke dig";
		}
	}
	

}
