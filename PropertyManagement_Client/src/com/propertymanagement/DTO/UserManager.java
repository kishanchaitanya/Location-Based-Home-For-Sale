package com.propertymanagement.DTO;

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

public class UserManager {
	
	private UserInformation userInfo;
	
	public UserInformation getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInformation userInfo) {
		this.userInfo = userInfo;
	}

	public String getUser()
	{

		String result = "";
		try {
			String req = Rest_Info.REST_PATH + "UserInfo/UserLogin?";
			req += "uName=" + userInfo.getuName() + "&";
			req += "uPass=" + userInfo.getuPassword();
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
			while ((output = br.readLine()) != null) 
			{
				result=output;
			}
		
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	
	}

}
