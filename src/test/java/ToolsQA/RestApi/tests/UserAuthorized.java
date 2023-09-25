package ToolsQA.RestApi.tests;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class UserAuthorized {
	
	public static String basePATH="/Account/V1/Authorized";
	public static String baseUrl = "https://bookstore.toolsqa.com";
	JSONObject jsonObject=new JSONObject();
	static String userIdAndPassword = CreateUser.getUserNameAndPassword();
	@Test(priority = 2)
	public void authorizedUser()
	{
		try {
			RestAssured.baseURI=baseUrl;
			given().
			log().
			all().	
			auth().oauth2(basePATH).
			header("Content-Type","application/json").
			header("accept","application/json").
			body(userIdAndPassword).
			when().
			post(basePATH).
			then().log().all().statusCode(200);
		} catch (Exception e) {
			throw e;
		}
	}

}
