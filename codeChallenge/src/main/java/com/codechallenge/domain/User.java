package com.codechallenge.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userName;

	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date dob;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

}
