package ToolsQA.RestApi.tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import ToolsQA.Utilities.BooksAPI;
import api.Model.Book;
import api.pojo.requests.AddBooksRequest;
import api.pojo.requests.ISBN;
import api.pojo.responses.Books;
import api.pojo.responses.Token;
import api.pojo.responses.UserAccount;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class EndToEndTest extends BooksAPI {	
	static String userIdAndPassword = CreateUser.getUserNameAndPassword();
	Book book=new Book();
	UserAccount account=new UserAccount();
	Token bearerToken=new Token();
	AddBooksRequest addBooksRequest;
	ISBN isbnObj;
	String isbn;
	
	@Test(priority=1)
	public void createUserToAccess() {		
		String userIdAndPassword="";
		Response response;
		try {
			RestAssured.baseURI=baseURI;
			response=given().
			header("Content-Type", "application/json").
			header("accept", "application/json").
			body(CreateUser.getUserNameAndPassword()).
			post(CreateUser.baseEndPointofUser);
			response.then().log().all().
			assertThat().statusCode(201);
			account=response.getBody().as(UserAccount.class);
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Test(priority = 2)
	public void generateToken()
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
			bearerToken=response.getBody().as(Token.class);
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Test(priority=3)
	public void getBooks()
	{
		try {
			RestAssured.baseURI=baseURI;
			Response response=(Response)given().log().all().
			header("Content-Type", "application/json").
			header("accept", "application/json").
			when().get(booksPath);
			response.then().log().all().assertThat().statusCode(200);			
			Books books=response.getBody().as(Books.class);
			book=books.books.get(0);
			isbn=book.isbn;
			isbnObj = new ISBN(isbn);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Test(priority=4)
	public void addBooks()
	{
		try {
			RestAssured.baseURI=baseURI;
			given().
			header("Content-Type", "application/json").
			header("accept", "application/json").
			header("Authorization", "Bearer " + bearerToken.token).
			body("{\r\n"
					+ "    \"userId\": \""+account.userID+"\",\r\n"
					+ "    \"collectionOfIsbns\": [\r\n"
					+ "        {\r\n"
					+ "            \"isbn\": \""+isbn+"\"\r\n"
					+ "        }\r\n"
					+ "    ]\r\n"
					+ "}").
			when().post(booksPath).
			then().log().all().
			assertThat().statusCode(201);
			
		} catch (Exception e) {
			throw e;
		}
	}
}
