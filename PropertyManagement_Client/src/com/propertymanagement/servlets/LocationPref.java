package com.propertymanagement.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.propertymanagement.DTO.AdvertsimentInfo;
import com.propertymanagement.agent.AgentManager;
import com.propertymanagement.buyer.BuyerInfo;
import com.propertymanagement.buyer.BuyerLocPreferences;
import com.propertymanagement.buyer.BuyerManager;

/**
 * Servlet implementation class LocationPref
 */

public class LocationPref extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LocationPref() {
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
		BuyerLocPreferences bPref = new BuyerLocPreferences();
		bPref.setAddress(request.getParameter("lAddress"));
		bPref.setCity(request.getParameter("lCity"));
		bPref.setZipCode(request.getParameter("lZip"));
		bPref.setPrice(request.getParameter("lPrice"));
		bPref.setHousePref(request.getParameter("lHPref"));
		HttpSession session = request.getSession();
		BuyerManager bManager = (BuyerManager) session.getAttribute("manager");
		BuyerInfo bInfo = bManager.getbInfo();
		bPref.setBuyerId(bInfo.getBuyerId());
		List<BuyerLocPreferences> bPrefList = bInfo.getLocPrefList();

		if (bPrefList == null) {
			bPrefList = new ArrayList<BuyerLocPreferences>();
			bPrefList.add(bPref);
		} else {
			bPrefList.add(bPref);
		}
		bInfo.setLocPrefList(bPrefList);
		bManager.setbInfo(bInfo);
		bManager.updateLocPref(bPref);
		AgentManager aManger=new AgentManager();
		List<AdvertsimentInfo> newsFeeds=aManger.getNewsFeeds();
		System.out.println(newsFeeds.size());
		session.setAttribute("newsFeed", newsFeeds);
		
		session.setAttribute("manager", bManager);
		session.setAttribute("usrGrp", "1");
//		session.setAttribute("centerPage", "Display.jsp");
		response.sendRedirect("Display.jsp");

	}

}
