package ToolsQA.RestApi.tests;

import static io.restassured.RestAssured.*;

import org.json.JSONObject;

import io.restassured.RestAssured;

public class GenerateToken {

	public static String basePATH="/Account/V1/GenerateToken";
	public static String baseUrl = "https://bookstore.toolsqa.com";
	public static void generateToken()
	
	{
		JSONObject jsonObject=new JSONObject();
		jsonObject=CreateUser.getUserNameAndPassword();
		//jsonObject.
		try {
			RestAssured.baseURI=basePATH;
			given().log().all().
			header("Content-Type","application/json").
			header("accept","application/json").
			body("").
			when().
			post(baseUrl).
			then().log().all().
			assertThat().statusCode(200);
			
	
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static void main(String[] args) {
		generateToken();
	}
	
}
