package com.propertymanagement.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.propertymanagement.DTO.AdvertsimentInfo;
import com.propertymanagement.agent.AgentInfo;
import com.propertymanagement.agent.AgentManager;

/**
 * Servlet implementation class AgentSignup
 */

public class AgentSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AgentSignup() {
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
		HttpSession session = request.getSession();
		// session.setAttribute("feedList", newsFeeds);
		session.setAttribute("centerPage", "../Web-Pages/Display.jsp");
		response.sendRedirect("/Main.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		AgentInfo agentInfo = new AgentInfo();
		HttpSession session = request.getSession();
		agentInfo.setUserGrp(Integer.parseInt((String)session.getAttribute("uType")));
		agentInfo.setuName((String) session.getAttribute("uName"));
		agentInfo.setuPassword((String) session.getAttribute("uPass"));
		agentInfo.setAgencyName(request.getParameter("uAgencyName"));
		agentInfo.setAgentAddress(request.getParameter("uAddress"));
		agentInfo.setCity(request.getParameter("uCity"));
		agentInfo.setZipCode(request.getParameter("uZip"));
		agentInfo.setLongitude(request.getParameter("uLang"));
		agentInfo.setLatitude(request.getParameter("uLat"));
		agentInfo.setContactNumber(request.getParameter("uContactNumber"));

		AgentManager aManger = new AgentManager();
		aManger.setAgentInfo(agentInfo);
		String result = aManger.validateUser();

		if (result.equalsIgnoreCase("success")) {
			String restResult = aManger.createUser();
			if (restResult.equalsIgnoreCase("success")) {
				aManger.getUserInfo();
			}
		}

		List<AdvertsimentInfo> newsFeeds = aManger.getNewsFeeds();
		session.setAttribute("manager", aManger);
		session.setAttribute("newsFeed", newsFeeds);
//		session.setAttribute("centerPage", "Display.jsp");
		session.setAttribute("usrGrp", "0");
		response.sendRedirect("Display.jsp");

	}

}
