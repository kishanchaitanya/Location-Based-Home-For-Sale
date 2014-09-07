package com.propertymanagement.rest;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.propertymanagement.DTO.AdvertsimentInfo;
import com.propertymanagement.agent.AgentAddSearchCriteria;
import com.propertymanagement.agent.AgentInfo;
import com.propertymanagement.agent.AgentManager;
import com.propertymanagement.utils.MailerSystem;

@Path("/AgentOp")
public class AgentRestCall {

	@GET
	@Path("/ValidateUser")
	@Produces(MediaType.TEXT_PLAIN)
	public String validateUser(@QueryParam("uName") String uName,
			@QueryParam("uPass") String uPass) {
		String result = "";
		AgentManager manager = new AgentManager();
		boolean flag = manager.validateUser(uName, uPass);
		if (flag)
			result = "0";
		else
			result = "1";

		return result;
	}

	@POST
	@Path("/CreateAgent")
	@Produces(MediaType.TEXT_PLAIN)
	public String createAgent(@QueryParam("uName") String uName,
			@QueryParam("uPass") String uPass,
			@QueryParam("AgencyName") String aName,
			@QueryParam("ContactNumber") String cNumber,
			@QueryParam("AgentAdd") String aAddress,
			@QueryParam("City") String aCity, @QueryParam("Zip") String aZip,
			@QueryParam("Email") String aEmail,
			@QueryParam("Long") String aLong, @QueryParam("Lat") String aLat) {

		AgentManager aManager = new AgentManager();
		AgentInfo agentInfo = new AgentInfo();
		agentInfo.setUserGrp(0);
		agentInfo.setuName(uName);
		agentInfo.setuPassword(uPass);
		agentInfo.setAgencyName(aName);
		agentInfo.setContactNumber(cNumber);
		agentInfo.setAgentAddress(aAddress);
		agentInfo.setCity(aCity);
		agentInfo.setZipCode(aZip);
		agentInfo.seteMailAddress(aEmail);
		agentInfo.setLatitude(aLat);
		agentInfo.setLongitude(aLong);
		boolean result = false;
		if (agentInfo.createUser()) {
			result = aManager.createAgent(agentInfo);
		}

		if (result) {
			return "true";
		} else {
			return "false";
		}

	}

	@GET
	@Path("/NewsFeeds")
	@Produces(MediaType.TEXT_XML)
	public String NewsFeeds() {

		String result = "";
		AgentManager aManager = new AgentManager();
		AgentAddSearchCriteria aCriteria = aManager.getNewsFeeds();

		try {
			JAXBContext jaxbContext = JAXBContext
					.newInstance(AgentAddSearchCriteria.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter string = new StringWriter();
			jaxbMarshaller.marshal(aCriteria, string);
			result = string.toString();
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return result;

	}

	@GET
	@Path("/AgentLogin")
	@Produces(MediaType.TEXT_XML)
	public String agentLogin(@QueryParam("uName") String uName,
			@QueryParam("uPass") String uPass) {

		String result = "";
		AgentManager aManager = new AgentManager();
		AgentInfo agentInfo = aManager.getUserInfo(uName, uPass);

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(AgentInfo.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter string = new StringWriter();
			jaxbMarshaller.marshal(agentInfo, string);
			result = string.toString();
			System.out.println(result);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return result;

	}

	@POST
	@Path("/CreateModAdd")
	@Produces(MediaType.TEXT_PLAIN)
	public String createAdd(@QueryParam("Operation") String operation,
			@QueryParam("AgentId") String aId,
			@QueryParam("PropId") String pId,
			@QueryParam("PropInfo") String aInfo,
			@QueryParam("PropType") String aType,
			@QueryParam("Address") String aAddress,
			@QueryParam("Zip") String aZip, @QueryParam("City") String aCity,
			@QueryParam("Long") String aLong, @QueryParam("Lat") String aLat,
			@QueryParam("Img1") String img1, @QueryParam("Img2") String img2,
			@QueryParam("Img3") String img3, @QueryParam("Video") String vid,
			@QueryParam("Price") String price) {

		AgentManager aManager = new AgentManager();
		AdvertsimentInfo addInfo = new AdvertsimentInfo();
		addInfo.setAgentId(aId);
		addInfo.setPropertyId(pId);
		addInfo.setPropertyInfo(aInfo);
		addInfo.setPropertyType(aType);
		addInfo.setAddress(aAddress);
		addInfo.setCityName(aCity);
		addInfo.setZipCode(aZip);
		addInfo.setLang(aLong);
		addInfo.setLat(aLat);
		List<String> iList = new ArrayList<String>();
		iList.add(img1);
		iList.add(img2);
		iList.add(img3);
		addInfo.setImgLocation(iList);

		List<String> vList = new ArrayList<String>();
		vList.add(vid);
		addInfo.setVideoLocation(vList);
		addInfo.setPrice(price);

		boolean result = false;
		if (operation.equalsIgnoreCase("new")) {

			result = aManager.createAdd(addInfo);
		} else if (operation.equalsIgnoreCase("modify")) {
			result = aManager.modifyAdd(addInfo);
		}

		if (result) {
			return "true";
		} else {
			return "false";
		}

	}

	@GET
	@Path("/SearchCriteria")
	@Produces(MediaType.TEXT_XML)
	public String searchLocationCriteria(
			@QueryParam("PropertyId") String propertyId,
			@QueryParam("Operation") String operation,
			@QueryParam("Address") String aAddress,
			@QueryParam("Zip") String aZip, @QueryParam("City") String aCity,
			@QueryParam("SortCriteria") String sortCriteria) {

		AgentManager aManager = new AgentManager();
		AgentAddSearchCriteria searchCriteria = new AgentAddSearchCriteria();
		searchCriteria.setPropertyId(propertyId);
		searchCriteria.setAddress(aAddress);
		searchCriteria.setCity(aCity);
		searchCriteria.setZipCode(aZip);
		searchCriteria.setSortingCriteria(sortCriteria);
		searchCriteria.setSearchedList(aManager
				.searchLocationOnCriteria(searchCriteria));
		System.out.println(searchCriteria.getAddress());
		String result = "";

		try {
			JAXBContext jaxbContext = JAXBContext
					.newInstance(AgentAddSearchCriteria.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter string = new StringWriter();
			jaxbMarshaller.marshal(searchCriteria, string);

			result = string.toString();
			System.out.println(result);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return result;

	}

	@POST
	@Path("/ContactAgent")
	@Produces(MediaType.TEXT_PLAIN)
	public String contactAgent(@QueryParam("AgentId") String aId,
			@QueryParam("Mail") String mail) {

		AgentManager aManager = new AgentManager();
		
		new MailerSystem().mail(aManager.getAgentMailId(aId), mail);
		String result="";
			
		return result;

	}
	
	@GET
	@Path("/SearchBuyer")
	@Produces(MediaType.TEXT_XML)
	public String searchBuyer(
			@QueryParam("Address") String aAddress,
			@QueryParam("Zip") String aZip, @QueryParam("City") String aCity) {
		
		System.out.println("dojbdojdbojdsfnsjlonsdollo");
		AgentManager aManager = new AgentManager();
		AgentAddSearchCriteria searchCriteria = new AgentAddSearchCriteria();
		searchCriteria.setAddress(aAddress);
		searchCriteria.setCity(aCity);
		searchCriteria.setZipCode(aZip);
		
		searchCriteria.setBuyerList(aManager.searchBuyer(searchCriteria));
		System.out.println(searchCriteria.getCity());
		
		String result = "";

		try {
			JAXBContext jaxbContext = JAXBContext
					.newInstance(AgentAddSearchCriteria.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter string = new StringWriter();
			jaxbMarshaller.marshal(searchCriteria, string);

			result = string.toString();
			System.out.println(result);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return result;

	}

}
