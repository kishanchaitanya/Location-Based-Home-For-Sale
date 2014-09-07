package com.propertymanagement.agent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.propertymanagement.DTO.AdvertsimentInfo;
import com.propertymanagement.buyer.BuyerInfo;
import com.propertymanagemnt.DB.DBManager;

public class AgentManager {

	public boolean validateUser(String uName, String uPass) {

		boolean flag = true;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DBManager.getConnection();
			String query = "SELECT * FROM USER_LOGIN_MASTER WHERE USER_NAME= (?) AND PASSWORD= (?)";
			ps = con.prepareStatement(query);
			ps.setString(1, uName);
			ps.setString(2, uPass);

			rs = ps.executeQuery();
			if (rs.next()) {
				flag = false;

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return flag;

	}

	public boolean createAgent(AgentInfo agentInfo) {
		boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			String query = "INSERT INTO agent_info (AGENT_ID,AGENCY_NAME, CONTACT_NUMBER, AGENT_ADDRESS, CITY, ZIPCODE, EMAIL_ADDRESS, LONGITUDE, LATITUDE) VALUES (?,?,?,?,?,?,?,?,?)";
			con = DBManager.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, agentInfo.getuId());
			ps.setString(2, agentInfo.getAgencyName());
			ps.setString(3, agentInfo.getContactNumber());
			ps.setString(4, agentInfo.getAgentAddress());
			ps.setString(5, agentInfo.getCity());
			ps.setString(6, agentInfo.getZipCode());
			ps.setString(7, agentInfo.geteMailAddress());
			ps.setString(8, agentInfo.getLongitude());
			ps.setString(9, agentInfo.getLatitude());

			flag = ps.execute();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return flag;
	}

	public AgentInfo getUserInfo(String uName, String uPass) {

		AgentInfo agentInfo = new AgentInfo();
		agentInfo.setuName(uName);
		agentInfo.setuPassword(uPass);
		agentInfo.loginUser();

		boolean flag = true;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DBManager.getConnection();
			String query = "SELECT * FROM AGENT_INFO WHERE AGENT_ID = (?)";
			ps = con.prepareStatement(query);
			ps.setString(1, agentInfo.getuId());

			rs = ps.executeQuery();
			if (rs.next()) {
				agentInfo.setAgencyId(rs.getString("AGENT_ID"));
				agentInfo.setAgencyName(rs.getString("AGENCY_NAME"));
				agentInfo.setContactNumber(rs.getString("CONTACT_NUMBER"));
				agentInfo.setAgentAddress(rs.getString("AGENT_ADDRESS"));
				agentInfo.setCity(rs.getString("CITY"));
				agentInfo.setZipCode(rs.getString("ZIPCODE"));
				agentInfo.seteMailAddress(rs.getString("EMAIL_ADDRESS"));
				agentInfo.setLongitude(rs.getString("LONGITUDE"));
				agentInfo.setLatitude(rs.getString("LATITUDE"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		agentInfo.setAddList(getAgentAdds(agentInfo.getAgencyId()));
		return agentInfo;

	}

	public AgentAddSearchCriteria getNewsFeeds() {

		AgentAddSearchCriteria refObj = new AgentAddSearchCriteria();
		List<AdvertsimentInfo> addList = new ArrayList<AdvertsimentInfo>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			String query = "SELECT * FROM property_info order by PROPERTY_ID DESC LIMIT 10";
			con = DBManager.getConnection();
			ps = con.prepareStatement(query);

			rs = ps.executeQuery();
			AdvertsimentInfo ref = null;
			List<String> imgList = null;
			List<String> vidList = null;
			while (rs.next()) {
				ref = new AdvertsimentInfo();

				ref.setPropertyId(rs.getString("PROPERTY_ID"));
				ref.setAgentId(rs.getString("AGENT_ID"));
				ref.setPropertyInfo(rs.getString("PROPERTY_INFO"));
				ref.setPropertyType(rs.getString("PROPERTY_TYPE"));
				ref.setAddress(rs.getString("ADDRESS"));
				ref.setZipCode(rs.getString("ZIPCODE"));
				ref.setCityName(rs.getString("CITYNAME"));
				ref.setLang(rs.getString("LONGITUDE"));
				ref.setLat(rs.getString("LATITUDE"));
				imgList = new ArrayList<String>();
				imgList.add(rs.getString("IMG_1"));
				imgList.add(rs.getString("IMG_2"));
				imgList.add(rs.getString("IMG_3"));
				ref.setImgLocation(imgList);
				vidList = new ArrayList<String>();
				vidList.add(rs.getString("VIDEO"));
				ref.setVideoLocation(vidList);
				ref.setPrice(rs.getString("PRICE"));
				addList.add(ref);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		refObj.setSearchedList(addList);
		return refObj;
	}

	public List<AdvertsimentInfo> getAgentAdds(String agentId) {
		List<AdvertsimentInfo> addList = new ArrayList<AdvertsimentInfo>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			String query = "SELECT * FROM PROPERTY_INFO WHERE AGENT_ID = (?)";
			con = DBManager.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, agentId);

			rs = ps.executeQuery();
			AdvertsimentInfo ref = null;
			List<String> imgList = null;
			List<String> vidList = null;
			while (rs.next()) {
				ref = new AdvertsimentInfo();

				ref.setPropertyId(rs.getString("PROPERTY_ID"));
				ref.setAgentId(rs.getString("AGENT_ID"));
				ref.setPropertyInfo(rs.getString("PROPERTY_INFO"));
				ref.setPropertyType(rs.getString("PROPERTY_TYPE"));
				ref.setAddress(rs.getString("ADDRESS"));
				ref.setZipCode(rs.getString("ZIPCODE"));
				ref.setCityName(rs.getString("CITYNAME"));
				ref.setLang(rs.getString("LONGITUDE"));
				ref.setLat(rs.getString("LATITUDE"));
				imgList = new ArrayList<String>();
				imgList.add(rs.getString("IMG_1"));
				imgList.add(rs.getString("IMG_2"));
				imgList.add(rs.getString("IMG_3"));
				ref.setImgLocation(imgList);
				vidList = new ArrayList<String>();
				vidList.add(rs.getString("VIDEO"));
				ref.setVideoLocation(vidList);
				ref.setPrice(rs.getString("PRICE"));
				addList.add(ref);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return addList;
	}

	public boolean createAdd(AdvertsimentInfo addInfo) {
		boolean flag = false;

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			String query = "INSERT INTO property_info (AGENT_ID, PROPERTY_ID, PROPERTY_INFO, PROPERTY_TYPE, ADDRESS, ZIPCODE, CITYNAME, LATITUDE, LONGITUDE, IMG_1,IMG_2,IMG_3,VIDEO,PRICE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			con = DBManager.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, addInfo.getAgentId());

			if (addInfo.getPropertyId() != null
					&& addInfo.getPropertyId() != "") {
				ps.setString(2, addInfo.getPropertyId());
			} else {
				ps.setString(2,
						"SELECT (MAX(PROPERTY_ID)+1) FROM PROPERTY_INFO");
			}
			ps.setString(3, addInfo.getPropertyInfo());
			ps.setString(4, addInfo.getPropertyType());
			ps.setString(5, addInfo.getAddress());
			ps.setString(6, addInfo.getZipCode());
			ps.setString(7, addInfo.getCityName());
			ps.setString(8, addInfo.getLat());
			ps.setString(9, addInfo.getLang());
			ps.setString(10, addInfo.getImgLocation().get(0));
			ps.setString(11, addInfo.getImgLocation().get(1));
			ps.setString(12, addInfo.getImgLocation().get(2));
			ps.setString(13, addInfo.getVideoLocation().get(0));
			ps.setString(14, addInfo.getPrice());

			flag = ps.execute();
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return flag;
	}

	public boolean modifyAdd(AdvertsimentInfo addInfo) {
		boolean flag = false;

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			String query = "UPDATE property_info SET  PROPERTY_INFO =(?), PROPERTY_TYPE = (?), ADDRESS = (?), ZIPCODE = (?), CITYNAME = (?), LATITUDE = (?), LONGITUDE = (?), IMG_1 = (?),IMG_2 = (?),IMG_3 = (?),VIDEO = (?),PRICE = (?) WHERE AGENT_ID  = (?) AND PROPERTY_ID = (?)";
			con = DBManager.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, addInfo.getPropertyInfo());
			ps.setString(2, addInfo.getPropertyType());
			ps.setString(3, addInfo.getAddress());
			ps.setString(4, addInfo.getZipCode());
			ps.setString(5, addInfo.getCityName());
			ps.setString(6, addInfo.getLat());
			ps.setString(7, addInfo.getLang());
			ps.setString(8, addInfo.getImgLocation().get(0));
			ps.setString(9, addInfo.getImgLocation().get(1));
			ps.setString(10, addInfo.getImgLocation().get(2));
			ps.setString(11, addInfo.getVideoLocation().get(0));
			ps.setString(12, addInfo.getPrice());
			ps.setString(13, addInfo.getAgentId());
			ps.setString(14, addInfo.getPropertyId());

			System.out.println(ps.toString());
			flag = ps.execute();
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return flag;
	}

	public List<BuyerInfo> searchBuyers(AgentAddSearchCriteria searchCriteria) {
		List<BuyerInfo> bList = new ArrayList<BuyerInfo>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			String query = "SELECT * FROM PROPERTY_INFO WHERE";
			con = DBManager.getConnection();
			ps = con.prepareStatement(query);

			if (searchCriteria.getPropertyId() != null
					|| searchCriteria.getPropertyId() != "") {
				query += "PROPERTY_ID =" + searchCriteria.getPropertyId()
						+ " AND ";
			}
			if (searchCriteria.getAddress() != null
					|| searchCriteria.getAddress() != "") {
				query += "ADDRESS = '" + searchCriteria.getAddress() + "' AND";
			}
			if (searchCriteria.getCity() != null
					|| searchCriteria.getCity() != "") {
				query += " CITYNAME ='" + searchCriteria.getCity() + "' AND";
			}
			if (searchCriteria.getZipCode() != null
					|| searchCriteria.getZipCode() != "") {
				query += " ZIPCODE ='" + searchCriteria.getPropertyId()
						+ "' AND";
			}

			if (query.endsWith("WHERE")) {
				query = query.concat("WHERE");
			}
			if (query.endsWith("AND")) {
				query = query.concat("AND");
			}
			System.out.println(ps.toString());
			rs = ps.executeQuery();

			while (rs.next()) {

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return bList;
	}

	public List<AdvertsimentInfo> searchLocationOnCriteria(
			AgentAddSearchCriteria searchCriteria) {
		List<AdvertsimentInfo> addList = new ArrayList<AdvertsimentInfo>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			String query = "SELECT * FROM PROPERTY_INFO WHERE ";
			con = DBManager.getConnection();
			if (searchCriteria.getPropertyId() != null
					&& !searchCriteria.getPropertyId().equalsIgnoreCase("")) {
				query += "PROPERTY_ID like '%" + searchCriteria.getPropertyId()
						+ "%' AND ";
			}
			if (searchCriteria.getAddress() != null
					&& !searchCriteria.getAddress().equalsIgnoreCase("")
					&& !searchCriteria.getAddress().equalsIgnoreCase("null")) {
				query += "ADDRESS like '%" + searchCriteria.getAddress()
						+ "%' AND";
			}
			if (searchCriteria.getCity() != null
					&& !searchCriteria.getCity().equalsIgnoreCase("")
					&& !searchCriteria.getCity().equalsIgnoreCase("null")) {
				query += " CITYNAME like '%" + searchCriteria.getCity()
						+ "%' AND";
			}
			if (searchCriteria.getZipCode() != null
					&& !searchCriteria.getZipCode().equalsIgnoreCase("")
					&& !searchCriteria.getZipCode().equalsIgnoreCase("null")) {
				query += " ZIPCODE like '%" + searchCriteria.getZipCode()
						+ "%' AND";
			}

			query = query.trim();
			if (query.endsWith("WHERE")) {

				query = query.substring(0, query.lastIndexOf("WHERE"));
			}
			if (query.endsWith("AND")) {
				query = query.substring(0, query.lastIndexOf("AND"));
			}

			query += " ORDER BY " + searchCriteria.getSortingCriteria();

			System.out.println(query);
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			AdvertsimentInfo ref = null;
			List<String> imgList = null;
			List<String> vidList = null;
			while (rs.next()) {
				ref = new AdvertsimentInfo();

				ref.setPropertyId(rs.getString("PROPERTY_ID"));
				ref.setAgentId(rs.getString("AGENT_ID"));
				ref.setPropertyInfo(rs.getString("PROPERTY_INFO"));
				ref.setPropertyType(rs.getString("PROPERTY_TYPE"));
				ref.setAddress(rs.getString("ADDRESS"));
				ref.setZipCode(rs.getString("ZIPCODE"));
				ref.setCityName(rs.getString("CITYNAME"));
				ref.setLang(rs.getString("LONGITUDE"));
				ref.setLat(rs.getString("LATITUDE"));
				imgList = new ArrayList<String>();
				imgList.add(rs.getString("IMG_1"));
				imgList.add(rs.getString("IMG_2"));
				imgList.add(rs.getString("IMG_3"));
				ref.setImgLocation(imgList);
				vidList = new ArrayList<String>();
				vidList.add(rs.getString("VIDEO"));
				ref.setVideoLocation(vidList);
				ref.setPrice(rs.getString("PRICE"));
				addList.add(ref);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return addList;
	}

	public List<AdvertsimentInfo> getGooglMapOnLocation(
			AgentAddSearchCriteria searchCriteria) {
		List<AdvertsimentInfo> addList = new ArrayList<AdvertsimentInfo>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			String query = "SELECT * FROM PROPERTY_INFO WHERE";
			con = DBManager.getConnection();
			ps = con.prepareStatement(query);

			if (searchCriteria.getPropertyId() != null
					&& searchCriteria.getPropertyId() != "") {
				query += "PROPERTY_ID =" + searchCriteria.getPropertyId()
						+ " AND ";
			}
			if (searchCriteria.getAddress() != null
					&& searchCriteria.getAddress() != "") {
				query += "ADDRESS = '" + searchCriteria.getAddress() + "' AND";
			}
			if (searchCriteria.getCity() != null
					&& searchCriteria.getCity() != "") {
				query += " CITYNAME ='" + searchCriteria.getCity() + "' AND";
			}
			if (searchCriteria.getZipCode() != null
					&& searchCriteria.getZipCode() != "") {
				query += " ZIPCODE ='" + searchCriteria.getPropertyId()
						+ "' AND";
			}

			if (query.endsWith("WHERE")) {
				query = query.concat("WHERE");
			}
			if (query.endsWith("AND")) {
				query = query.concat("AND");
			}

			rs = ps.executeQuery();
			AdvertsimentInfo ref = null;
			List<String> imgList = null;
			List<String> vidList = null;
			while (rs.next()) {
				ref = new AdvertsimentInfo();

				ref.setPropertyId(rs.getString("PROPERTY_ID"));
				ref.setAgentId(rs.getString("AGENT_ID"));
				ref.setPropertyInfo(rs.getString("PROPERTY_INFO"));
				ref.setPropertyType(rs.getString("PROPERTY_TYPE"));
				ref.setAddress(rs.getString("ADDRESS"));
				ref.setZipCode(rs.getString("ZIPCODE"));
				ref.setCityName(rs.getString("CITYNAME"));
				ref.setLang(rs.getString("LONGITUDE"));
				ref.setLat(rs.getString("LATITUDE"));
				imgList = new ArrayList<String>();
				imgList.add(rs.getString("IMG_1"));
				imgList.add(rs.getString("IMG_2"));
				imgList.add(rs.getString("IMG_3"));
				ref.setImgLocation(imgList);
				vidList = new ArrayList<String>();
				vidList.add(rs.getString("VIDEO"));
				ref.setVideoLocation(vidList);
				ref.setPrice(rs.getString("PRICE"));
				addList.add(ref);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return addList;
	}

	public List<BuyerInfo> searchBuyer(AgentAddSearchCriteria searchCriteria) {
		System.out.println("dbdskbdsdsbfidsbdsibfdsifbdsifbdskdsbkdshvdsivsdiv");
		List<BuyerInfo> bInfo = new ArrayList<BuyerInfo>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BuyerInfo ref = null;
		try {

			String query = "SELECT * FROM BUYER_INFO as bInfo ,buyer_location_pref as loc WHERE ";
			con = DBManager.getConnection();
			System.out.println(searchCriteria.getCity());
	
			String query2="";
			
			if (searchCriteria.getAddress() != null
					&& !searchCriteria.getAddress().equalsIgnoreCase("") && !searchCriteria.getAddress().equalsIgnoreCase("null")) {
				query2 += "LOCATION_ADDRESS like '%"+searchCriteria.getAddress()+"%' AND";
				
			}
			if (searchCriteria.getCity() != null
					&& !searchCriteria.getCity().equalsIgnoreCase("") && !searchCriteria.getCity().equalsIgnoreCase("null")) {
				query2 += "CITY like '%" + searchCriteria.getCity() + "%' AND ";
			}
			if (searchCriteria.getZipCode() != null
					&& !searchCriteria.getZipCode().equalsIgnoreCase("") && !searchCriteria.getZipCode().equalsIgnoreCase("null")) {
				query2 += "ZIPCODE like '%" + searchCriteria.getPropertyId() + " %' ";
			}
			
			query2=query2.trim();
			query+=query2+" bInfo.buyer_id=loc.buyer_id GROUP BY loc.BUYER_ID";
			if (query2.endsWith("WHERE")) {

				query2 = query.substring(0, query2.lastIndexOf("WHERE"));
			}
			if (query2.endsWith("AND")) {
				query2 = query2.substring(0, query2.lastIndexOf("AND"));
			}

//			query2 += "')";
//			System.out.println(query2);
//			System.out.println(query);
//			query+="("+query2+")";
			ps = con.prepareStatement(query);
			System.out.println(ps.toString());
			rs = ps.executeQuery();
			while (rs.next()) {
				ref = new BuyerInfo();
				ref.setfName(rs.getString("FNAME"));
				ref.setlName(rs.getString("LNAME"));
				ref.setEmailInfo(rs.getString("EMAIL_ADDRESS"));
				bInfo.add(ref);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return bInfo;

	}

	public String getAgentMailId(String agentId) 
	{

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String result = "";
		try {
			con = DBManager.getConnection();
			String query = "SELECT EMAIL_ADDRESS FROM AGENT_INFO WHERE AGENT_ID = (?)";
			ps = con.prepareStatement(query);
			ps.setString(1, agentId);
			rs = ps.executeQuery();

			while (rs.next()) {
				result = rs.getString("EMAIL_ADDRESS");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		return result;
	}

}
