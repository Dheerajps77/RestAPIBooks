package ToolsQA.RestApi.tests;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import ToolsQA.Utilities.BooksAPI;
import api.Model.Book;
import api.pojo.requests.ISBN;
import api.pojo.responses.Books;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BooksDetails extends BooksAPI {
	
	Book book=new Book();
	ISBN isbnObj;
	String isbn;
	
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
	
	public void addBooks()
	{
		try {
			RestAssured.baseURI=baseURI;
			given().
			header("Content-Type", "application/json").
			header("accept", "application/json").
			body("").
			when().post(booksPath).
			then().log().all().
			assertThat().statusCode(200);
			
		} catch (Exception e) {
			throw e;
		}
	}

}
