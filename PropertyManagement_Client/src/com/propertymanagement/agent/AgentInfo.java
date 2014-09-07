package com.propertymanagement.agent;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.propertymanagement.DTO.AdvertsimentInfo;
import com.propertymanagement.DTO.UserInformation;
import com.sun.xml.internal.txw2.annotation.XmlElement;

@XmlRootElement(name="AgentInfo")
@XmlType(propOrder={"agencyId","agencyName","contactNumber","agentAddress","city","zipCode","eMailAddress","longitude","latitude","addList"})
public class AgentInfo extends UserInformation {
	
	private String agencyId;
	private String agencyName;
	private String contactNumber;
	private String agentAddress;
	private String city;
	private String zipCode;
	private String eMailAddress;
	private String longitude;
	private String latitude;
	private List<AdvertsimentInfo> addList;
	
	public String getAgencyId() {
		return agencyId;
	}
	public void setAgencyId(String agencyId) {
		this.agencyId = agencyId;
	}
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAgentAddress() {
		return agentAddress;
	}
	public void setAgentAddress(String agentAddress) {
		this.agentAddress = agentAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String geteMailAddress() {
		return eMailAddress;
	}
	public void seteMailAddress(String eMailAddress) {
		this.eMailAddress = eMailAddress;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	
	public List<AdvertsimentInfo> getAddList() {
		return addList;
	}
	public void setAddList(List<AdvertsimentInfo> addList) {
		this.addList = addList;
	}
	
	
}
