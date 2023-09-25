package api.pojo.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import api.Model.Book;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Books {
	public List<Book> books;

}
