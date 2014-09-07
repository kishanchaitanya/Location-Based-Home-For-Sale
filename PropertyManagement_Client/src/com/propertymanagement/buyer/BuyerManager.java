package com.propertymanagement.buyer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.propertymanagement.agent.AgentInfo;
import com.propertymanagement.utils.Rest_Info;

public class BuyerManager {

	private BuyerInfo bInfo = new BuyerInfo();
	private BuyerLocPreferences bPref = new BuyerLocPreferences();

	public BuyerInfo getbInfo() {
		return bInfo;
	}

	public void setbInfo(BuyerInfo bInfo) {
		this.bInfo = bInfo;
	}

	public BuyerLocPreferences getbPref() {
		return bPref;
	}

	public void setbPref(BuyerLocPreferences bPref) {
		this.bPref = bPref;
	}

	public String validateUser(String uName, String uPass) {
		String result = "";
		try {
			String req = Rest_Info.REST_PATH + "BuyerOp/ValidateUser?";
			req += "uName=" + bInfo.getuName() + "&";
			req += "uPass=" + bInfo.getuPassword();
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

	public String createUser() {

		String result = "";
		try {
			String req = Rest_Info.REST_PATH + "BuyerOp/CreateBuyer?";

			req += "uName=" + bInfo.getuName() + "&";
			req += "uPass=" + bInfo.getuPassword() + "&";
			req += "FirstName=" + bInfo.getfName() + "&";
			req += "LastName=" + bInfo.getlName() + "&";
			req += "EMailAddress=" + bInfo.getEmailInfo() + "&";
			req += "ContactNumber=" + bInfo.getContactInfo();

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
				if (output.endsWith("true")) {
					System.out.println(output);
					String[] op = output.split("#");
					this.bInfo.setBuyerId(op[0]);
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

		String result = "";
		try {
			String req = Rest_Info.REST_PATH + "BuyerOp/BuyerLogin?";

			req += "uName=" + bInfo.getuName() + "&";
			req += "uPass=" + bInfo.getuPassword();

			System.out.println(req);
			URL url = new URL(req);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			JAXBContext jaxbContext = JAXBContext.newInstance(BuyerInfo.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			this.bInfo = (BuyerInfo) jaxbUnmarshaller.unmarshal(conn
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

	public String updateLocPref(BuyerLocPreferences bPref) {

		String result = "";
		try {
			String req = Rest_Info.REST_PATH + "BuyerOp/LocPref?";

			req += "buyerId=" + bPref.getBuyerId() + "&";
			req += "Address=" + bPref.getAddress() + "&";
			req += "City=" + bPref.getCity() + "&";
			req += "Zip=" + bPref.getZipCode() + "&";
			req += "Price=" + bPref.getPrice() + "&";
			req += "HousePref=" + bPref.getHousePref();

			req = req.trim();
			req = req.replaceAll(" ", "%20");
			System.out.println(req);
			URL url = new URL(req);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			// if (conn.getResponseCode() != 200) {
			// throw new RuntimeException("Failed : HTTP error code : "
			// + conn.getResponseCode());
			//
			// }

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				if (output.endsWith("true")) {
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
}
