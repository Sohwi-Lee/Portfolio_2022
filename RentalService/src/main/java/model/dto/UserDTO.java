package model.dto;

import java.sql.Timestamp;

public class UserDTO {
	
	private String id,pw,userNick,userName,tel,email;
	private Timestamp regDate;
	
	public UserDTO(String id, String pw, String userNick, String userName, String tel, String email) {
		this.id=id;this.pw=pw;this.userNick=userNick;this.userName=userName;this.tel=tel;this.email=email;
	}
	public UserDTO(String id, String pw, String userNick, String userName, String tel, String email, Timestamp regDate) {
		this.id=id;this.pw=pw;this.userNick=userNick;this.userName=userName;this.tel=tel;this.email=email; this.regDate=regDate;
	}
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

}
