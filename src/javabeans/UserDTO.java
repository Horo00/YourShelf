package javabeans;

import java.io.Serializable;

public class UserDTO implements Serializable{
	private int id;
	private String password;
	private String name;

	public UserDTO() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public UserDTO(String password, String name) {
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
