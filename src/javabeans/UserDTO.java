package javabeans;

import java.io.Serializable;

public class UserDTO implements Serializable{
	private int id;
	private String name;
	private String password;

	public UserDTO() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public UserDTO(String name, String password) {
		this.password = password;
		this.name = name;
	}



	public UserDTO(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
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

	public void setId(int id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}
}
