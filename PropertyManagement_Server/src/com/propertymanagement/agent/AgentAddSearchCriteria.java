package com.propertymanagement.agent;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.propertymanagement.DTO.AdvertsimentInfo;
import com.propertymanagement.buyer.BuyerInfo;

@XmlRootElement(name = "AgentAdSearchCriteria")
public class AgentAddSearchCriteria {
	private String address;
	private String zipCode;
	private String city;
	private String propertyId;
	private String sortingCriteria;
	private List<String> sortingCriteriaList;
	private List<AdvertsimentInfo> searchedList;
	private List<BuyerInfo> buyerList;

	public List<BuyerInfo> getBuyerList() {
		return buyerList;
	}

	public void setBuyerList(List<BuyerInfo> buyerList) {
		this.buyerList = buyerList;
	}

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
