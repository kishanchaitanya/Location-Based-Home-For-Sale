package com.propertymanagement.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.propertymanagement.agent.AgentAddSearchCriteria;
import com.propertymanagement.agent.AgentManager;

/**
 * Servlet implementation class AgentSearch
 */
@WebServlet("/AgentSearch")
public class AgentSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AgentSearch() {
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
		int addNumber = Integer.parseInt(request.getParameter("addInfo"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		AgentAddSearchCriteria searchInfo = new AgentAddSearchCriteria();
		searchInfo.setPropertyId(request.getParameter("sId"));
		searchInfo.setAddress(request.getParameter("sAddress"));
		searchInfo.setCity(request.getParameter("sCity"));
		searchInfo.setZipCode(request.getParameter("sZip"));
		searchInfo.setSortingCriteria(request.getParameter("sCriteria"));

		AgentManager aManger = null;
		if (session.getAttribute("manger") != null) {
			aManger = (AgentManager) session.getAttribute("manger");
		} else {
			aManger = new AgentManager();
		}
		searchInfo=aManger.searchOnCriteria(searchInfo);
		session.setAttribute("searchObj", searchInfo);

	}

}
