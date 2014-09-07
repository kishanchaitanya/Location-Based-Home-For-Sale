package com.propertymanagement.buyer;

import java.util.List;

import com.propertymanagement.DTO.AdvertsimentInfo;

public class BuyerSearchCriteria {
	private String address;
	private String zipCode;
	private String city;
	private String propertyId;
	private String sortingCriteria;
	private List<String> sortingCriteriaList;
	private List<AdvertsimentInfo> searchedList;

	public List<AdvertsimentInfo> getSearchedList() {
		return searchedList;
	}

	public void setSearchedList(List<AdvertsimentInfo> searchedList) {
		this.searchedList = searchedList;
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

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public String getSortingCriteria() {
		return sortingCriteria;
	}

	public void setSortingCriteria(String sortingCriteria) {
		this.sortingCriteria = sortingCriteria;
	}

	public List<String> getSortingCriteriaList() {
		return sortingCriteriaList;
	}

	public void setSortingCriteriaList(List<String> sortingCriteriaList) {
		this.sortingCriteriaList = sortingCriteriaList;
	}

}
