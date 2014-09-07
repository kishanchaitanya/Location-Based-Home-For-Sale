package com.propertymanagement.agent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.propertymanagement.DTO.AdvertsimentInfo;

import com.propertymanagement.buyer.BuyerInfo;
import com.propertymanagement.utils.Rest_Info;

public class AgentManager {
	private AgentInfo agentInfo = new AgentInfo();
	private AdvertsimentInfo addInfo = new AdvertsimentInfo();

	public AgentInfo getAgentInfo() {
		return agentInfo;
	}

	public void setAgentInfo(AgentInfo agentInfo) {
		this.agentInfo = agentInfo;
	}

	public AdvertsimentInfo getAddInfo() {
		return addInfo;
	}

	public void setAddInfo(AdvertsimentInfo addInfo) {
		this.addInfo = addInfo;
	}

	public String validateUser() {
		String result = "";
		try {
			String req = Rest_Info.REST_PATH + "AgentOp/ValidateUser?";
			req += "uName=" + agentInfo.getuName() + "&";
			req += "uPass=" + agentInfo.getuPassword();
			System.out.println(req);
			URL url = new URL(req);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				if (output.equalsIgnoreCase("0")) {
					result = "Success";
				} else {
					result = "This Username and Password is already used";
				}
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return result;

	}

	public List<AdvertsimentInfo> getNewsFeeds() {
		List<AdvertsimentInfo> newFeed = new ArrayList<AdvertsimentInfo>();
		AgentAddSearchCriteria ref = null;
		try {
			String req = Rest_Info.REST_PATH + "AgentOp/NewsFeeds";

			System.out.println(req);
			URL url = new URL(req);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			JAXBContext jaxbContext = JAXBContext
					.newInstance(AgentAddSearchCriteria.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			ref = (AgentAddSearchCriteria) jaxbUnmarshaller.unmarshal(conn
					.getInputStream());
			newFeed = ref.getSearchedList();
			System.out.println(newFeed.size());
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return newFeed;
	}

	public String createUser() {

		String result = "";
		try {
			String req = Rest_Info.REST_PATH + "AgentOp/CreateAgent?";

			req += "uName=" + agentInfo.getuName() + "&";
			req += "uPass=" + agentInfo.getuPassword() + "&";
			req += "AgencyName=" + agentInfo.getAgencyName() + "&";
			req += "ContactNumber=" + agentInfo.getContactNumber() + "&";
			req += "AgentAdd=" + agentInfo.getAgentAddress() + "&";
			req += "City=" + agentInfo.getCity() + "&";
			req += "Zip=" + agentInfo.getZipCode() + "&";
			req += "Email=" + agentInfo.geteMailAddress() + "&";
			req += "Long=" + agentInfo.getLatitude() + "&";
			req += "Lat=" + agentInfo.getLongitude();

			System.out.println(req);
			req = req.replace(" ", "%20");
			URL url = new URL(req);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				if (output.equalsIgnoreCase("true")) {
					result = "Success";
				} else {
					result = "Error while creating user information";
				}
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return result;
	}

	public void getUserInfo() {

		try {
			String result;
			String req = Rest_Info.REST_PATH + "AgentOp/AgentLogin?";

			req += "uName=" + agentInfo.getuName() + "&";
			req += "uPass=" + agentInfo.getuPassword();

			System.out.println(req);
			URL url = new URL(req);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			System.out.println("Output from Server .... \n");
			JAXBContext jaxbContext = JAXBContext.newInstance(AgentInfo.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			this.agentInfo = (AgentInfo) jaxbUnmarshaller.unmarshal(conn
					.getInputStream());
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public void createModifyAdd(String operation) {

		try {
			String result;
			String req = Rest_Info.REST_PATH + "AgentOp/CreateModAdd?";

			req += "Operation=" + operation + "&";
			req += "AgentId=" + addInfo.getAgentId() + "&";
			req += "PropId=" + addInfo.getPropertyId() + "&";
			req += "PropInfo=" + addInfo.getPropertyInfo() + "&";
			req += "PropType=" + addInfo.getPropertyType() + "&";
			req += "Address=" + addInfo.getAddress() + "&";
			req += "Zip=" + addInfo.getZipCode() + "&";
			req += "City=" + addInfo.getCityName() + "&";
			req += "Long=" + addInfo.getLang() + "&";
			req += "Lat=" + addInfo.getLat() + "&";
			if (addInfo.getImgLocation() != null
					&& addInfo.getImgLocation().size() > 0)
				req += "Img1=" + addInfo.getImgLocation().get(0) + "&";
			if (addInfo.getImgLocation() != null
					&& addInfo.getImgLocation().size() > 1)
				req += "Img2=" + addInfo.getImgLocation().get(1) + "&";
			if (addInfo.getImgLocation() != null
					&& addInfo.getImgLocation().size() > 2)
				req += "Img3=" + addInfo.getImgLocation().get(2) + "&";

			if (addInfo.getVideoLocation() != null
					&& addInfo.getImgLocation().size() > 1)
				req += "Video=" + addInfo.getVideoLocation().get(0) + "&";
			req += "Price=" + addInfo.getPrice();
			req = req.replace(" ", "%20");
			System.out.println(req);
			URL url = new URL(req);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				if (output.equalsIgnoreCase("true")) {
					result = "Success";
				} else {
					result = "Error while creating user information";
				}
			}

			conn.disconnect();
			if (operation.equalsIgnoreCase("new")) {
				this.agentInfo.getAddList().add(addInfo);
			}

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public AgentAddSearchCriteria searchOnCriteria(
			AgentAddSearchCriteria searchCriteria) {

		try {
			String result;
			String req = Rest_Info.REST_PATH + "AgentOp/SearchCriteria?";

			if (searchCriteria.getPropertyId() != null
					&& searchCriteria.getPropertyId() != "null")
				req += "PropertyId=" + searchCriteria.getPropertyId() + "&";
			req += "Address=" + searchCriteria.getAddress() + "&";
			req += "Zip=" + searchCriteria.getZipCode() + "&";
			req += "City=" + searchCriteria.getCity() + "&";
			req += "SortCriteria=" + searchCriteria.getSortingCriteria();

			System.out.println(req);
			req = req.replace(" ", "%20");
			URL url = new URL(req);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			JAXBContext jaxbContext = JAXBContext
					.newInstance(AgentAddSearchCriteria.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			searchCriteria = (AgentAddSearchCriteria) jaxbUnmarshaller
					.unmarshal(conn.getInputStream());
			System.out.println(searchCriteria.getCity());
			System.out.println("dkjbaddbdouubdsoldb"
					+ searchCriteria.getSearchedList().size());
			// BufferedReader br = new BufferedReader(new InputStreamReader(
			// (conn.getInputStream())));
			//
			// String output;
			// System.out.println("Output from Server .... \n");
			// while ((output = br.readLine()) != null) {
			// System.out.println(output);
			// if (output.equalsIgnoreCase("true")) {
			// result = "Success";
			// } else {
			// result = "Error while creating user information";
			// }
			// }

			conn.disconnect();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return searchCriteria;

	}
	
	public void sendMail(
			String aId,String mail) {

		try {
			String result;
			String req = Rest_Info.REST_PATH + "AgentOp/ContactAgent?";
			req += "AgentId=" + aId + "&";
			req += "Mail=" + mail;

			System.out.println(req);
			req = req.replace(" ", "%20");
			URL url = new URL(req);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

//			JAXBContext jaxbContext = JAXBContext
//					.newInstance(AgentAddSearchCriteria.class);
//			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//			searchCriteria = (AgentAddSearchCriteria) jaxbUnmarshaller
//					.unmarshal(conn.getInputStream());
//			System.out.println(searchCriteria.getCity());
//			System.out.println("dkjbaddbdouubdsoldb"
//					+ searchCriteria.getSearchedList().size());
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				if (output.equalsIgnoreCase("true")) {
					result = "Success";
				} else {
					result = "Error while creating user information";
				}
			}

			conn.disconnect();

		} catch (Exception e) {

			e.printStackTrace();

		}
//		return searchCriteria;

	}
	

	public List<BuyerInfo> searchBuyer(AgentAddSearchCriteria searchCriteria) {

		try {
			String result;
			String req = Rest_Info.REST_PATH + "AgentOp/SearchBuyer?";

			if (searchCriteria.getPropertyId() != null
					&& searchCriteria.getPropertyId() != "null")
				req += "PropertyId=" + searchCriteria.getPropertyId() + "&";
			req += "Address=" + searchCriteria.getAddress() + "&";
			req += "Zip=" + searchCriteria.getZipCode() + "&";
			req += "City=" + searchCriteria.getCity();

			System.out.println("ssds"+req);
			req = req.replace(" ", "%20");
			URL url = new URL(req);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			JAXBContext jaxbContext = JAXBContext
					.newInstance(AgentAddSearchCriteria.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			searchCriteria = (AgentAddSearchCriteria) jaxbUnmarshaller
					.unmarshal(conn.getInputStream());
			System.out.println("ssds"+searchCriteria.getCity());
			// System.out.println("dkjbaddbdouubdsoldb"
			// + searchCriteria.getSearchedList().size());
			// BufferedReader br = new BufferedReader(new InputStreamReader(
			// (conn.getInputStream())));
			//
			// String output;
			// System.out.println("Output from Server .... \n");
			// while ((output = br.readLine()) != null) {
			// System.out.println(output);
			// if (output.equalsIgnoreCase("true")) {
			// result = "Success";
			// } else {
			// result = "Error while creating user information";
			// }
			// }

			conn.disconnect();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return searchCriteria.getBuyerList();

	}

	public static void main(String[] args) {
		AgentManager aManger = new AgentManager();
		// System.out.println(aManger.getNewsFeeds().size());
		AgentAddSearchCriteria ac = new AgentAddSearchCriteria();
//		ac
		ac.setCity("San Jose");
		aManger.searchBuyer(ac);
//		aManger.sendMail("1", "TEST MAIL");
		// AgentAddSearchCriteria search = new AgentAddSearchCriteria();
		// search.setSortingCriteria("PROPERTY_ID");
		// aManger.searchOnCriteria(search);
		// AgentInfo aInfo = new AgentInfo();
		// aInfo.setuName("123");
		// aInfo.setuPassword("123");
		// aManger.setAgentInfo(aInfo);
		// aManger.getUserInfo();
	}

}
