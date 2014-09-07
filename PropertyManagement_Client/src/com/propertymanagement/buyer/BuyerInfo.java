package com.propertymanagement.buyer;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.propertymanagement.DTO.UserInformation;
@XmlRootElement(name="BuyerInfo")
@XmlType(propOrder={"buyerId","fName","lName","emailInfo","contactInfo","locPrefList"})
public class BuyerInfo extends UserInformation {
	private String buyerId;
	private String fName;
	private String lName;
	private String emailInfo;
	private String contactInfo;
	private List<BuyerLocPreferences> locPrefList;

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmailInfo() {
		return emailInfo;
	}

	public void setEmailInfo(String emailInfo) {
		this.emailInfo = emailInfo;
	}

	public List<BuyerLocPreferences> getLocPrefList() {
		return locPrefList;
	}

	public void setLocPrefList(List<BuyerLocPreferences> locPrefList) {
		this.locPrefList = locPrefList;
	}

}
