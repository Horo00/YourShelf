package model;

public class userHistoryDTO {
	private int id; // user.idと同値
	private int booksId; // AdminData.booksidと同値
	private int isbn;
	private String checkedOutDate;

	public userHistoryDTO(int id, int booksId, int isbn, String checkedOutDate) {
		this.id = id;
		this.booksId = booksId;
		this.isbn = isbn;
		this.checkedOutDate = checkedOutDate;
	}

	public int getId() {
		return id;
	}

	public int getBooksId() {
		return booksId;
	}

	public int getIsbn() {
		return isbn;
	}

	public String getCheckedOutDate() {
		return checkedOutDate;
	}




}
