package org.inayat.novo.ringelweb.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "USER_TABLE")
public class UserTypeModel {
	@Id
	private int id;	
	private	String fname;
	private	String lname;
	private String username;
	private String password;
	private String email;
	private	String mobile;
	private	String feedback;
	private String userType;
	private String returnedMsg;
	private String exception;
	private String createdon;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCreatedon() {
		return createdon;
	}
	public void setCreatedon(String createdon) {
		this.createdon = createdon;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}

	public String getReturnedMsg() {
		return returnedMsg;
	}
	public void setReturnedMsg(String returnedMsg) {
		this.returnedMsg = returnedMsg;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	}

