package homework09;

import java.util.Date;

public class peopleBean {
	public static final int PAGE_SIZE = 2; 	// 每页记录数
	private String userName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPushInfo() {
		return pushInfo;
	}
	public void setPushInfo(String pushInfo) {
		this.pushInfo = pushInfo;
	}
	private String password;
	private String degree;
	private String email;
	private String pushInfo;
	private Date birthday;
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}
