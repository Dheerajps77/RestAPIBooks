package api.pojo.requests;

import api.pojo.responses.UserAccount;

public class AddBooksRequest{
	UserAccount account=new UserAccount();
	String userID=account.userID;
	String isbn=account.books.get(0).isbn;
	String[] collectionOfIsbns= {isbn};
	
	public AddBooksRequest(String userID, String isbn) {
		this.userID = userID;
		this.isbn = isbn;
	}	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String[] getCollectionOfIsbns() {
		return collectionOfIsbns;
	}
	public void setCollectionOfIsbns(String[] collectionOfIsbns) {
		this.collectionOfIsbns = collectionOfIsbns;
	}
}
