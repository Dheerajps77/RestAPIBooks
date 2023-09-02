package ToolsQA.RestApi.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import test1.Utils;

import static io.restassured.RestAssured.*;

import org.json.JSONObject;

public class CreateUser {

	public static String userName = Utils.generateUserName(4);
	public static String userPassword = Utils.generateUserPassword(5);
	static Response response;
	public static String baseUrl = "https://bookstore.toolsqa.com";
	public static String baseEndpoint = "/Account/v1/GenerateToken";
	public static String baseEndPointofUser = "/Account/v1/User";
	

	public static Response createUserToAccess() {
		Response responseBody;
		try {
			RestAssured.baseURI=baseUrl;
			responseBody=given().
			header("Content-Type", "application/json").
			header("accept", "application/json").
			body("{\r\n"
          		+ "  \"userName\": \""+userName+"\",\r\n"
          		+ "  \"password\": \""+userPassword+"\"\r\n"
          		+ "}").
			post(baseEndPointofUser);
			
			responseBody.then().log().all().
			assertThat().statusCode(201).
			extract().asString();			
		} catch (Exception e) {
			throw e;
		}
		return responseBody;
	}
	
	public static JSONObject getUserNameAndPassword() {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("userName", userName);
			jsonObject.put("password", userPassword);
			response = createUserToAccess();
		} catch (Exception e) {
			throw e;
		}
		return jsonObject;
	}
	
	public static String getUserID() {
		String userId = "";
		try {
			userId=Utils.jsonValueRead(response, "userID");
			System.out.println("User ID : "+userId);
		} catch (Exception e) {
			throw e;
		}
		return userId;
	}
	
	public static void main(String[] args) {
		JSONObject getUserNameAndPassInJSOnFormat=new JSONObject();
		getUserNameAndPassInJSOnFormat=getUserNameAndPassword();
		System.out.println(getUserNameAndPassInJSOnFormat);
	}

}
