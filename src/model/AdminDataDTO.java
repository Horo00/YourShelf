package model;

public class AdminDataDTO {
	private int booksId;
	private int isbn; //13桁の書籍コード
	private String boughtDate;
	private int count;
	private String checkedOutDate;

	public AdminDataDTO(int booksId, int isbn, String boughtDate, int count, String checkedOutDate) {
		this.booksId = booksId;
		this.isbn = isbn;
		this.boughtDate = boughtDate;
		this.count = count;
		this.checkedOutDate = checkedOutDate;
	}
	public int getBooksId() {
		return booksId;
	}
	public int getIsbn() {
		return isbn;
	}
	public String getBoughtDate() {
		return boughtDate;
	}
	public int getCount() {
		return count;
	}
	public String getCheckedOutDate() {
		return checkedOutDate;
	}


}
