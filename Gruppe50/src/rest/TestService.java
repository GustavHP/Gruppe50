package rest;

import java.io.UnsupportedEncodingException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;



@Path("test")
public class TestService {
	
	@GET
	public String getTest(){
		return "Helllo 50";
	}
	
	@Path("ct")
	@POST
	public String createToken(String username) {
		
		String token = "empty";
		
		if (!username.equals("Niklas"))
			return "User doesn't exist";
		
		try {
			
			Algorithm algorithmHS = Algorithm.HMAC256("secret");
			token = JWT.create()
					.withClaim("username", username)
					.sign(algorithmHS);
			
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return token;
	}
	
	@Path("vt")
	@POST
	public String verifyToken(String token) {
		
		try {
			Algorithm algorithmHS = Algorithm.HMAC256("secret");
			JWTVerifier verifier = JWT.require(algorithmHS)
					.withIssuer("auth0")
					.build();
			DecodedJWT jwt = verifier.verify(token);
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "";
	}
	

}
