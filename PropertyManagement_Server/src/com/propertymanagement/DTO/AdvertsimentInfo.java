package com.propertymanagement.DTO;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;




@XmlRootElement
public class AdvertsimentInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String agentId;
	private String propertyId;
	private String propertyInfo;
	private String propertyType;
	private String address;
	private String zipCode;
	private String cityName;
	private String lat;
	private String lang;
	private List<String> imgLocation;
	private List<String> videoLocation;

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	private String price;

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public List<String> getImgLocation() {
		return imgLocation;
	}

	public void setImgLocation(List<String> imgLocation) {
		this.imgLocation = imgLocation;
	}

	public List<String> getVideoLocation() {
		return videoLocation;
	}

	public void setVideoLocation(List<String> videoLocation) {
		this.videoLocation = videoLocation;
	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyInfo() {
		return propertyInfo;
	}

	public void setPropertyInfo(String propertyInfo) {
		this.propertyInfo = propertyInfo;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

}
