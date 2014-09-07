package com.propertymanagement.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.propertymanagement.buyer.BuyerInfo;
import com.propertymanagement.buyer.BuyerManager;

/**
 * Servlet implementation class BuyerSignup
 */
@WebServlet("/BuyerSignup")
public class BuyerSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuyerSignup() {
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
		BuyerManager bManager = new BuyerManager();
		HttpSession session = request.getSession();
		BuyerInfo bInfo = new BuyerInfo();
		bInfo.setUserGrp(Integer.parseInt((String)session.getAttribute("uType")));
		bInfo.setuName((String) session.getAttribute("uName"));
		bInfo.setuPassword((String) session.getAttribute("uPass"));
		bInfo.setUserGrp(1);
		bInfo.setfName(request.getParameter("fName"));
		bInfo.setlName(request.getParameter("lName"));
		bInfo.setEmailInfo(request.getParameter("eMail"));
		bInfo.setContactInfo(request.getParameter("cNumber"));
		bManager.setbInfo(bInfo);
		bManager.createUser();
		session.setAttribute("manager", bManager);
		response.sendRedirect("Buyer_Signup_LocPref.jsp");
	}

}
