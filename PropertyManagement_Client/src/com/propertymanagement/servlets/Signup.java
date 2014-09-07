package com.propertymanagement.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.propertymanagement.agent.AgentInfo;
import com.propertymanagement.agent.AgentManager;

/**
 * Servlet implementation class Signup
 */

public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Signup() {
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
		// TODO Auto-generated method stub HttpSession
		// session=request.getSession();
		HttpSession session = request.getSession();
		String uName = (String) request.getParameter("uName");
		String uPass = (String) request.getParameter("uPass");
		String uType = (String) request.getParameter("uType");
		System.out.println(uName);
		session.setAttribute("uName", uName);
		session.setAttribute("uPass", uPass);
		session.setAttribute("uType", uType);
		AgentManager aManger = new AgentManager();
		AgentInfo aInfo = new AgentInfo();
		aInfo.setuName(uName);
		aInfo.setuPassword(uPass);
		aManger.setAgentInfo(aInfo);
		System.out.println(aInfo.getuName());
		System.out.println(aInfo.getuPassword());
		String result = aManger.validateUser();
		if (result.equalsIgnoreCase("success")) {
			if (uType.equalsIgnoreCase("0")) {
				response.sendRedirect("Agent_Signup.jsp");
			} else if (uType.equalsIgnoreCase("1")) {
				response.sendRedirect("Buyer_Signup.jsp");
			}
		} else {
			session.setAttribute("Lerror", aManger.validateUser());
			response.sendRedirect("Signup.jsp");
		}

	}

}
