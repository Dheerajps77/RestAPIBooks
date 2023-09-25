package ToolsQA.RestApi.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import test1.Utils;

import static io.restassured.RestAssured.*;

import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import api.pojo.requests.AuthorizationusersRequest;

public class CreateUser {

	public static String userName = Utils.generateUserName(4);
	public static String userPassword = Utils.generateUserPassword(5);
	static Response response;
	public static String baseUrl = "https://bookstore.toolsqa.com";
	public static String baseEndpoint = "/Account/v1/GenerateToken";
	public static String baseEndPointofUser = "/Account/v1/User";
	static AuthorizationusersRequest authorizationusers;
	JSONObject jsonObject=new JSONObject();
	
	public static String getUserNameAndPassword() {
		JSONObject jsonObject = new JSONObject();
		String userIdAndPassowrd="";
		authorizationusers=new AuthorizationusersRequest(userName, userPassword);
		try {
			jsonObject.put("userName", authorizationusers.getUserName());
			jsonObject.put("password", authorizationusers.getPassword());
		} catch (Exception e) {
			throw e;
		}
		userIdAndPassowrd=jsonObject.toString();
		return userIdAndPassowrd;
	}
	
	@Test(priority=1)
	public static void createUserToAccess() {
		String userIdAndPassword="";
		try {
			RestAssured.baseURI=baseUrl;
			userIdAndPassword=given().
			header("Content-Type", "application/json").
			header("accept", "application/json").
			body(getUserNameAndPassword()).
			post(baseEndPointofUser).
			then().log().all().
			assertThat().statusCode(201).
			extract().asString();
		} catch (Exception e) {
			throw e;
		}
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
		System.out.println("userId and password : " + getUserNameAndPassword());
	}
	 

}
