package model;

public class UserDTO {
	private int id;
	private String password;
	private String name;

	public UserDTO(int id, String password, String name) {
		this.id = id;
		this.password = password;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}



}
