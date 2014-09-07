package com.propertymanagement.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.propertymanagement.agent.AgentAddSearchCriteria;
import com.propertymanagement.agent.AgentManager;
import com.propertymanagement.buyer.BuyerInfo;

/**
 * Servlet implementation class SearchAdd
 */
@WebServlet("/SearchAdd")
public class SearchAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		AgentAddSearchCriteria agentAddSearch=new AgentAddSearchCriteria();
		System.out.println(request.getParameter("pAddress"));
		agentAddSearch.setCity(request.getParameter("pCity"));
		agentAddSearch.setZipCode(request.getParameter("pZip"));
		
		AgentManager aManager=new AgentManager();
		List<BuyerInfo> bInfo=aManager.searchBuyer(agentAddSearch);
		session.setAttribute("searchedBuyer", bInfo);
		response.sendRedirect("BuyerValue.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		AgentAddSearchCriteria agentAddSearch=new AgentAddSearchCriteria();
		agentAddSearch.setPropertyId(request.getParameter("pId"));
		System.out.println(request.getParameter("pAddress"));
		agentAddSearch.setAddress(request.getParameter("pAddress"));
		agentAddSearch.setCity(request.getParameter("pCity"));
		agentAddSearch.setZipCode(request.getParameter("pZip"));
		agentAddSearch.setSortingCriteria(request.getParameter("pSort"));
		
		AgentManager aManager=new AgentManager();
		agentAddSearch=aManager.searchOnCriteria(agentAddSearch);
		session.setAttribute("searchObj", agentAddSearch);
		response.sendRedirect("AddDisplay.jsp");
	}

}
