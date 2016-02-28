package cn.shan.study.meta;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
	private String username;
	private String nickname;
	private String password;
	private String email;
	public User(String username, String nickname, String password, String email) {
		super();
		this.username = username;
		this.nickname = nickname;
		this.password = password;
		this.email = email;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	@NotNull(message="用户名不能为空")
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@NotNull(message="密码不为空")
	@Size(min=3,max=10,message="密码的长度必须大于3小于10")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Pattern(regexp="(\\w+\\.*)\\w+@\\w+.\\[a-zA-Z]{2,6}",message="邮件格式不正确！")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
