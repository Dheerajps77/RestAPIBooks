package Others.testAPI;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.Map;

public class RestAPITesting {
	
	String baseURI="https://demoqa.com";
	String baseEndpoint="/BookStore/v1/Books";
	String token=tokenGeneration.authorization();
	String bookISBNId="";
	
	@Test(priority=0)
	public void getBooks()
	{
		try {
			RestAssured.baseURI=baseURI;
			Response response=given().log().all().
			when().
			get(baseEndpoint).
			then().log().all().statusCode(200).
			extract().response();
			
			String stre=response.asString();
			System.out.println(stre);
			
			List<Map<String, String>> books=JsonPath.from(stre).get("books");
			bookISBNId=books.get(0).get("isbn");
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Test(priority=1)
	public void addBooks()
	{		
		try {
			RestAssured.baseURI=baseURI;
			given().log().all().
			header("Content-Type", "application/json").
			header("Authorization", "Bearer " + token).
			body("{\r\n"
					+ "  \"userId\": \""+tokenGeneration.userID+"\",\r\n"
					+ "  \"collectionOfIsbns\": [\r\n"
					+ "    {\r\n"
					+ "      \"isbn\": \""+bookISBNId+"\"\r\n"
					+ "    }\r\n"
					+ "  ]\r\n"
					+ "}").
			when().
			post(baseEndpoint).
			then().
			assertThat().statusCode(200);
			
		} catch (Exception e) {
			throw e;
		}
	}
}
