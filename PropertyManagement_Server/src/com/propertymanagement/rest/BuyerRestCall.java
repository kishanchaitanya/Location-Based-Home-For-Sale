package com.propertymanagement.rest;

import java.io.StringWriter;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.propertymanagement.agent.AgentAddSearchCriteria;
import com.propertymanagement.agent.AgentInfo;
import com.propertymanagement.agent.AgentManager;
import com.propertymanagement.buyer.BuyerInfo;
import com.propertymanagement.buyer.BuyerLocPreferences;
import com.propertymanagement.buyer.BuyerManager;
import com.propertymanagement.buyer.BuyerSearchCriteria;

@Path("/BuyerOp")
public class BuyerRestCall {

	@GET
	@Path("/ValidateUser")
	@Produces(MediaType.TEXT_PLAIN)
	public String validateUser(@QueryParam("uName") String uName,
			@QueryParam("uPass") String uPass) {
		String result = "";
		BuyerManager manager = new BuyerManager();
		boolean flag = manager.validateUser(uName, uPass);
		if (flag)
			result = "0";
		else
			result = "1";

		return result;
	}

	@POST
	@Path("/CreateBuyer")
	@Produces(MediaType.TEXT_PLAIN)
	public String createBuyer(@QueryParam("uName") String uName,
			@QueryParam("uPass") String uPass,
			@QueryParam("FirstName") String fName,
			@QueryParam("LastName") String lName,
			@QueryParam("EMailAddress") String eMail,
			@QueryParam("ContactNumber") String cNumber) {

		boolean result = false;
		BuyerManager bManager = new BuyerManager();
		BuyerInfo bInfo = new BuyerInfo();
		bInfo.setUserGrp(1);
		bInfo.setuName(uName);
		bInfo.setuPassword(uPass);
		bInfo.setfName(fName);
		bInfo.setlName(lName);
		bInfo.setEmailInfo(eMail);
		bInfo.setContactInfo(cNumber);

		if (bInfo.createUser()) {
			result = bManager.createBuyer(bInfo);
		}

		if (result) {
			System.out.println(bInfo.getuId());
			return (bInfo.getuId() + "#" + "true");
		} else {
			return "false";
		}

	}

	@GET
	@Path("/LocPref")
	@Produces(MediaType.TEXT_PLAIN)
	public String createLocPref(@QueryParam("buyerId") String bId,
			@QueryParam("Address") String lAddress,
			@QueryParam("City") String lCity, @QueryParam("Zip") String lZip,
			@QueryParam("Price") String lPrice,
			@QueryParam("HousePref") String lHousePref) {

		boolean result = false;
		BuyerManager bManager = new BuyerManager();
		BuyerLocPreferences bPref = new BuyerLocPreferences();
		bPref.setBuyerId(bId);
		bPref.setAddress(lAddress);
		bPref.setCity(lCity);
		bPref.setZipCode(lZip);
		bPref.setPrice(lPrice);
		bPref.setHousePref(lHousePref);
		result = bManager.setLocPreference(bPref);
		System.out.println(bPref.getAddress());
		if (result) {
			return ("true");
		} else {
			return "false";
		}

	}

	@GET
	@Path("/BuyerLogin")
	@Produces(MediaType.TEXT_XML)
	public String agentLogin(@QueryParam("uName") String uName,
			@QueryParam("uPass") String uPass) {

		String result = "";
		BuyerManager bManager = new BuyerManager();
		BuyerInfo bInfo = bManager.getUserInfo(uName, uPass);
		bInfo.setLocPrefList(new ArrayList<BuyerLocPreferences>());

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(BuyerInfo.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter string = new StringWriter();
			jaxbMarshaller.marshal(bInfo, string);
			result = string.toString();
			System.out.println(result);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return result;

	}

	@GET
	@Path("/SearchCriteria")
	@Produces(MediaType.TEXT_PLAIN)
	public String searchLocationCriteria(
			@QueryParam("Operation") String operation,
			@QueryParam("Address") String aAddress,
			@QueryParam("Zip") String aZip, @QueryParam("City") String aCity,
			@QueryParam("SortCriteria") String sortCriteria) {

		BuyerManager bManager = new BuyerManager();
		BuyerSearchCriteria searchCriteria = new BuyerSearchCriteria();
		searchCriteria.setAddress(aAddress);
		searchCriteria.setCity(aCity);
		searchCriteria.setZipCode(aZip);
		searchCriteria.setSortingCriteria(sortCriteria);
		searchCriteria.setSearchedList(bManager.searchLocation(searchCriteria));
		System.out.println(searchCriteria.getAddress());
		String result = "";

		try {
			JAXBContext jaxbContext = JAXBContext
					.newInstance(BuyerSearchCriteria.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter string = new StringWriter();
			jaxbMarshaller.marshal(searchCriteria, string);

			result = string.toString();
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return result;

	}

}
