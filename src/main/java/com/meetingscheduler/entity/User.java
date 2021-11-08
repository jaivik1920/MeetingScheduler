package com.meetingscheduler.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "UserDetails")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private int id;
	@Column(unique = true,nullable = false)
	private String userName;
	@Column(unique = true,nullable = false)
	private String userEmail;
	@Column(unique = true,nullable = false)
	private String userAuthid;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String userName, String userEmail, String userAuthid) {
		super();
		this.id = id;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userAuthid = userAuthid;
	}
	public User(String userName, String userEmail, String userAuthid) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userAuthid = userAuthid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserAuthid() {
		return userAuthid;
	}
	public void setUserAuthid(String userAuthid) {
		this.userAuthid = userAuthid;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userEmail=" + userEmail + ", userAuthid=" + userAuthid
				+ "]";
	}
}
