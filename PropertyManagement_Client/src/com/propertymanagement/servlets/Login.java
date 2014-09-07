package com.propertymanagement.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

import com.propertymanagement.DTO.AdvertsimentInfo;
import com.propertymanagement.DTO.UserInformation;
import com.propertymanagement.DTO.UserManager;
import com.propertymanagement.agent.AgentInfo;
import com.propertymanagement.agent.AgentManager;
import com.propertymanagement.buyer.BuyerInfo;
import com.propertymanagement.buyer.BuyerManager;

/**
 * Servlet implementation class AgentSignup
 */

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String uName = request.getParameter("uName");
		String uPass = request.getParameter("uPass");
		System.out.println(uPass);
		UserInformation uInfo = new UserInformation();
		uInfo.setuName(uName);
		uInfo.setuPassword(uPass);
		
		UserManager uManger = new UserManager();
		uManger.setUserInfo(uInfo);
		uInfo.setUserGrp(Integer.parseInt(uManger.getUser()));
		
		System.out.println("hfisdihvdcihvdscikbgdcikgbcik"+uInfo.getUserGrp());
		if (uInfo.getUserGrp() == 0) {
			AgentManager aManger = new AgentManager();
			AgentInfo aInfo = new AgentInfo();
			aManger.setAgentInfo(aInfo);
			aInfo.setuName(uName);
			aInfo.setuPassword(uPass);
			aManger.getUserInfo();
			List<AdvertsimentInfo> newsFeeds = aManger.getNewsFeeds();
//			session.setAttribute("centerPage", "Display.jsp");
			session.setAttribute("manager", aManger);
			session.setAttribute("newsFeed", newsFeeds);
			session.setAttribute("usrGrp", "0");
			response.sendRedirect("Display.jsp");
		} else {
			BuyerManager bManger = new BuyerManager();
			BuyerInfo bInfo = new BuyerInfo();
			bInfo.setuName(uName);
			bInfo.setuPassword(uPass);
			bManger.setbInfo(bInfo);
			bManger.getUserInfo();
			AgentManager aManger = new AgentManager();
			List<AdvertsimentInfo> newsFeeds = aManger.getNewsFeeds();
//			session.setAttribute("centerPage", "Display.jsp");
			session.setAttribute("manager", bManger);
			session.setAttribute("newsFeed", newsFeeds);
			session.setAttribute("usrGrp", "1");
			response.sendRedirect("Display.jsp");

		}
	}

}
