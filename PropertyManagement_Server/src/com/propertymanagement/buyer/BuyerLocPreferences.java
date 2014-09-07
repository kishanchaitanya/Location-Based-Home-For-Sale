package com.propertymanagement.buyer;

public class BuyerLocPreferences {
	private String buyerId;
	private String address;
	private String zipCode;
	private String city;
	private String price;
	private String housePref;

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getHousePref() {
		return housePref;
	}

	public void setHousePref(String housePref) {
		this.housePref = housePref;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
