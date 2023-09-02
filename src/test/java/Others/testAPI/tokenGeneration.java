package Others.testAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.json.JSONObject;
import org.testng.Assert;

public class tokenGeneration {
	
	 static String  userID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
	 static String userName = "TOOLSQA-Test";
	 static String password = "Test@@123";
	 static String baseUrl = "https://bookstore.toolsqa.com";
	 static String baseEndpoint= "/Account/v1/GenerateToken";
	 static String token="";
	public static String authorization()
	{
		String token="";
		try {
			
			RestAssured.baseURI=baseUrl;
			String gettoken=given().log().all().
			header("Content-Type", "application/json").
			body("{ \"userName\":\"" + userName + "\", \"password\":\"" + password + "\"}").
            when().
            post(baseEndpoint).
            then().log().all().
            assertThat().statusCode(200).
            extract().response().asString();
			Assert.assertTrue(gettoken.contains("token"));
			token=JsonPath.from(gettoken).get("token");
						
		} catch (Exception e) {
			throw e;
		}
		return token;
	}
	
	public static JSONObject getJSONAuthCreds()
	{JSONObject jsonObject=new JSONObject();
		try {
			jsonObject.put("UserName", "TOOLSQA-Test");
			jsonObject.put("Password", "Test@@123");
			
		} catch (Exception e) {
			throw e;
		}
		return jsonObject;
	}
	
    public static void RegistrationSuccessful() {
        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        Response response=given().log().all().
          body("{\r\n"
          		+ "  \"userName\": \"TOOLSQA-Test\",\r\n"
          		+ "  \"password\": \"Test@@123\"\r\n"
          		+ "}")
        .when()
        .post("/Account/v1/User")
        .then().log().all()
        .statusCode(201)
        .extract().response();
        // We will need the userID in the response body for our tests, please save it in a local variable
        String userID = response.getBody().jsonPath().getString("userID");
        System.out.println(userID);
    }
	
	public static void main(String[] args) {
		RegistrationSuccessful();
	}
	
	

}
