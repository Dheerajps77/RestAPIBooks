package Others.testAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeMethod;

import io.restassured.http.ContentType;

public class httpMethods {

	@BeforeMethod
	public static void getMethod() {
		try {

		} catch (Exception e) {
			throw e;
		}
	}

	@BeforeMethod
	public static void postAssertion()
	{
		try {
			given()
            .baseUri("https://api.example.com")
            .basePath("/users/{userId}/profile")
            .pathParam("userId", 123)
            .queryParam("page", 1)
            .header("Authorization", "Bearer <your_token_here>")
            .contentType(ContentType.JSON)
            .body("{\"name\": \"John\", \"email\": \"john@example.com\"}")
        .when()
            .post()
        .then()
            .statusCode(201) // Validate status code
            .statusLine("HTTP/1.1 201 Created") // Validate status line
            .header("Content-Type", "application/json") // Validate header
            .body("id", equalTo(123)) // Validate response body
            .body("name", equalTo("John"))
            .body("email", equalTo("john@example.com"))
            .body("age", greaterThan(18)) // Validate numeric value
            .body("address.city", equalTo("New York")) // Validate nested JSON object
            .body("phones", hasSize(2)) // Validate list size
            .body("phones[0]", equalTo("1234567890")) // Validate list item
            .body("phones[1]", equalTo("9876543210"))
            .body("active", is(true)); // Validate boolean value
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	@BeforeMethod
	public void validateResponseTime()
	{
		try {
			given()
            .baseUri("https://api.example.com")
        .when()
            .get("/endpoint")
        .then()
            .time(lessThan(5000L)) // Assert response time less than 5000 milliseconds
            .time(greaterThan(1000L)) // Assert response time greater than 1000 milliseconds
            .time(equalTo(3000L)) // Assert response time equal to 3000 milliseconds
            .time(both(greaterThan(1000L)).and(lessThan(5000L))) // Assert response time between 1000 and 5000 milliseconds
            .time(not(both(greaterThan(1000L)).and(lessThan(5000L)))); // Assert response time not between 1000 and 5000 milliseconds
			
		} catch (Exception e) {
			throw e;
		}
	}

}
