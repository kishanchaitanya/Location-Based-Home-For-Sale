package com.propertymanagement.rest;

import java.io.StringWriter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.propertymanagement.DTO.UserInformation;
import com.propertymanagement.agent.AgentInfo;
import com.propertymanagement.agent.AgentManager;

@Path("/UserInfo")
public class UserRestCall {

	@GET
	@Path("/UserLogin")
	@Produces(MediaType.TEXT_PLAIN)
	public String agentLogin(@QueryParam("uName") String uName,
			@QueryParam("uPass") String uPass) {

		String result = "";
		
		UserInformation uInfo = new UserInformation();
		uInfo.setuName(uName);
		uInfo.setuPassword(uPass);
		uInfo.loginUser();
		System.out.println(uInfo.getUserGrp());
		try {
			
			result += uInfo.getUserGrp()+"";
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	public static void main(String[] args) {
		new UserRestCall().agentLogin("123", "123");
	}
}
