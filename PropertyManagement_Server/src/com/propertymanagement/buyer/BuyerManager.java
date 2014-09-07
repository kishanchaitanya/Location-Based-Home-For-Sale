package com.propertymanagement.buyer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.propertymanagement.DTO.AdvertsimentInfo;
import com.propertymanagement.agent.AgentInfo;
import com.propertymanagemnt.DB.DBManager;

public class BuyerManager {

	
	
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

	public boolean createBuyer(BuyerInfo buyerInfo) {
		boolean flag = false;

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			String query = "INSERT INTO buyer_info (BUYER_ID,FNAME, LNAME, CONTACT_NUMBER, EMAIL_ADDRESS) VALUES (?,?,?,?,?)";
			con = DBManager.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, buyerInfo.getuId());
			ps.setString(2, buyerInfo.getfName());
			ps.setString(3, buyerInfo.getlName());
			ps.setString(4, buyerInfo.getContactInfo());
			ps.setString(5, buyerInfo.getEmailInfo());

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

	public boolean setLocPreference(BuyerLocPreferences bPref) {
		boolean result = false;

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			String query = "INSERT INTO buyer_location_pref (BUYER_ID,LOCATION_ADDRESS, CITY, ZIPCODE,PRICE,HOUSE_PREF) VALUES (?,?,?,?,?,?)";
			con = DBManager.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, bPref.getBuyerId());
			ps.setString(2, bPref.getAddress());
			ps.setString(3, bPref.getCity());
			ps.setString(4, bPref.getZipCode());
			ps.setString(5, bPref.getPrice());
			ps.setString(6, bPref.getHousePref());

			result = ps.execute();	
			System.out.println(ps.toString());
			result=true;
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

		return result;

	}

	public BuyerInfo getUserInfo(String uName, String uPass) {
		BuyerInfo bInfo = new BuyerInfo();

		bInfo.setuName(uName);
		bInfo.setuPassword(uPass);
		bInfo.loginUser();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			String query = "SELECT * FROM buyer_info WHERE BUYER_ID = (?)";
			con = DBManager.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, bInfo.getuId());

			rs = ps.executeQuery();

			while (rs.next()) {
				bInfo.setEmailInfo(rs.getString("EMAIL_ADDRESS"));
				bInfo.setfName(rs.getString("FNAME"));
				bInfo.setlName(rs.getString("LNAME"));
				bInfo.setContactInfo(rs.getString("CONTACT_NUMBER"));
			}

			bInfo.setLocPrefList(getLocationPref(bInfo.getBuyerId()));
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

	public List<BuyerLocPreferences> getLocationPref(String buyerID) {
		List<BuyerLocPreferences> bList = new ArrayList<BuyerLocPreferences>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			String query = "SELECT * FROM buyer_location_pref WHERE BUYER_ID = (?)";
			con = DBManager.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, buyerID);

			rs = ps.executeQuery();

			BuyerLocPreferences bPref;
			while (rs.next()) {
				bPref = new BuyerLocPreferences();
				bPref.setBuyerId(rs.getString("BUYER_ID"));
				bPref.setAddress(rs.getString("LOCATION_ADDRESS"));
				bPref.setZipCode(rs.getString("ZIPCODE"));
				bPref.setCity(rs.getString("CITY"));
				bPref.setPrice(rs.getString("PRICE"));
				bPref.setHousePref(rs.getString("HOUSE_PREF"));
				bList.add(bPref);
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

	public List<AdvertsimentInfo> searchLocation(BuyerSearchCriteria searchCriteria) 
	{
		List<AdvertsimentInfo> addInfo = new ArrayList<AdvertsimentInfo>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			String query = "SELECT * FROM PROPERTY_INFO WHERE ";
			con = DBManager.getConnection();
			if (searchCriteria.getPropertyId() != null
					&& searchCriteria.getPropertyId() != "" && !searchCriteria.getPropertyId().equalsIgnoreCase("null")) {
				query += "PROPERTY_ID like '%" + searchCriteria.getPropertyId()
						+ "%' AND ";
			}
			if (searchCriteria.getAddress() != null
					&& searchCriteria.getAddress() != "" && !searchCriteria.getAddress().equalsIgnoreCase("null")) {
				query += "ADDRESS like '%" + searchCriteria.getAddress() + "%' AND";
			}
			if (searchCriteria.getCity() != null
					&& searchCriteria.getCity() != "" && !searchCriteria.getCity().equalsIgnoreCase("null")) {
				query += " CITYNAME like '%" + searchCriteria.getCity() + "%' AND";
			}
			if (searchCriteria.getZipCode() != null
					&& searchCriteria.getZipCode() != "" && !searchCriteria.getZipCode().equalsIgnoreCase("null")) {
				query += " ZIPCODE like '%" + searchCriteria.getPropertyId()
						+ "%' AND";
			}

			query = query.trim();
			if (query.endsWith("WHERE")) {

				query = query.substring(0, query.lastIndexOf("WHERE"));
			}
			if (query.endsWith("AND")) {
				query = query.substring(0, query.lastIndexOf("AND"));
			}
			
			query+=" ORDER BY "+searchCriteria.getSortingCriteria();
			
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
				addInfo.add(ref);
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
		return addInfo;
	}

	public List<AdvertsimentInfo> getGoogleMap(
			BuyerSearchCriteria searchCriteria) {
		List<AdvertsimentInfo> addInfo = new ArrayList<AdvertsimentInfo>();
		return addInfo;
	}

	public boolean setUpAlert(BuyerInfo buyerInfo,
			BuyerSearchCriteria searchCriteria) {
		boolean flag = false;
		return flag;
	}

	public boolean contactEstateAgent(BuyerInfo buyerInfo, AgentInfo agentInfo,
			String message) {
		boolean flag = false;
		return flag;
	}

}
