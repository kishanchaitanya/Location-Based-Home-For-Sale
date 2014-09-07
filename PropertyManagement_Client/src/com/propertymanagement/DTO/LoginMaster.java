package com.propertymanagement.DTO;

public class LoginMaster {

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
