package com.propertymanagement.DTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.propertymanagemnt.DB.DBManager;



public class UserInformation {

	private String uId;
	private String uName;
	private String uPassword;
	private int userGrp;

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public int getUserGrp() {
		return userGrp;
	}

	public void setUserGrp(int userGrp) {
		this.userGrp = userGrp;
	}

	public void getUID() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DBManager.getConnection();
			String query = "SELECT MAX(U_ID) FROM USER_LOGIN_MASTER";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				uId = (rs.getInt("MAX(U_ID)") + 1) + "";
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

	}

	public boolean createUser() {

		getUID();
		Connection con = null;
		PreparedStatement ps = null;
		boolean rs = false;

		try {
			con = DBManager.getConnection();
			String query = "INSERT INTO user_login_master (U_ID,USER_NAME, PASSWORD, USER_GRP) VALUES (?,?,?,?)";
			ps = con.prepareStatement(query);
			ps.setString(1, this.uId);
			ps.setString(2, this.uName);
			ps.setString(3, this.uPassword);
			ps.setInt(4, this.userGrp);
			rs = ps.execute();
			rs=true;
			System.out.println("lfjbdkjbdkbd"+ps.toString());
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
		return rs;

	}

	public void loginUser() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DBManager.getConnection();
			String query = "SELECT U_ID,USER_GRP FROM USER_LOGIN_MASTER WHERE USER_NAME = (?) and PASSWORD = (?)";
			ps = con.prepareStatement(query);
			ps.setString(1, this.uName);
			ps.setString(2, this.uPassword);
			rs = ps.executeQuery();
			System.out.println(ps.toString());
			while (rs.next()) {
				this.uId = rs.getInt("U_ID")+"";
				this.userGrp=rs.getInt("USER_GRP");
				
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
	}
}
