package com.propertymanagement.DTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = { "uId", "uName", "uPassword", "userGrp" })
public class UserInformation {

	private String uId;
	private String uName;
	private String uPassword;
	private int userGrp;

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public int getUserGrp() {
		return userGrp;
	}

	public void setUserGrp(int userGrp) {
		this.userGrp = userGrp;
	}
}
