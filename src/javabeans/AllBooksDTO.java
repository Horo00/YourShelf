package javabeans;

import java.io.Serializable;

public class AllBooksDTO implements Serializable{
	private String isbn; // 主キー
	private String title;
	private String authors;
	private String publisher;
	private String imageUrl;

	public AllBooksDTO() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


}
