package javabeans;

import java.io.Serializable;

public class Book implements Serializable{
	private int booksId;
	private String title;
	private String authors;
	private int count;
	private String publisher;
	private String imgUrl;

	//借りられているかどうか。falseで非貸出中。trueで貸出中
	private boolean isCheckedOut;

	public Book() {}

	public Book( String title, String authors, String publisher, String imgUrl) {

		this.title = title;
		this.authors = authors;
		this.publisher = publisher;
		this.imgUrl = imgUrl;
	}


	public int getBooksId() {
		return booksId;
	}
	public void setBooksId(int booksId) {
		this.booksId = booksId;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public boolean isCheckedOut() {
		return isCheckedOut;
	}

	public void setCheckedOut(boolean isCheckedOut) {
		this.isCheckedOut = isCheckedOut;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public Book title(String title) {
		this.title = title;
		return this;
	}

	public Book authors(String authors) {
		this.authors = authors;
		return this;
	}

	public Book count(int count) {
		this.count = count;
		return this;
	}

	public Book publisher(String publisher) {
		this.publisher = publisher;
		return this;
	}
}
