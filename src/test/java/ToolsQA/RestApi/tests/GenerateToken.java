package ToolsQA.RestApi.tests;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import ToolsQA.Utilities.BooksAPI;
import api.pojo.responses.Token;
import api.pojo.responses.UserAccount;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GenerateToken extends BooksAPI{
	static String userIdAndPassword = CreateUser.getUserNameAndPassword();
	
	@Test(priority=1)
	public static void createUserToAccess() {
		try {
			RestAssured.baseURI=baseURI;
			Response response=(Response) given().
			header("Content-Type", "application/json").
			header("accept", "application/json").
			body(CreateUser.getUserNameAndPassword()).
			post(creatUserPath);
			response.then().log().all().
			assertThat().statusCode(201);
			response.getBody().as(UserAccount.class);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Test(priority = 2)
	public static void generateToken()
	{
		try {
			RestAssured.baseURI=baseURI;
			Response response=(Response) given().log().all().
			header("Content-Type","application/json").
			header("accept","application/json").
			body(userIdAndPassword).
			when().
			post(generateTokenPath);
			
			response.then().log().all().assertThat().statusCode(200);
			response.getBody().as(Token.class);
			
		} catch (Exception e) {
			throw e;
		}
	}
}
