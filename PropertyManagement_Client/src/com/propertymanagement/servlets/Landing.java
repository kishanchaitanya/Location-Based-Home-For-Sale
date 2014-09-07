package com.propertymanagement.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.propertymanagement.DTO.AdvertsimentInfo;
import com.propertymanagement.agent.AgentManager;

/**
 * Servlet implementation class Landing
 */

public class Landing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Landing() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		System.out.println("Reacgeed haredb");
		
		AgentManager aManger=new AgentManager();
		List<AdvertsimentInfo> newsFeeds=aManger.getNewsFeeds();
		HttpSession session=request.getSession();
		
		System.out.println(newsFeeds.size());
		session.setAttribute("newsFeed", newsFeeds);
//		session.setAttribute("centerDisplayPage", "/Web-Pages/Display.jsp");
		response.sendRedirect("Display.jsp");

	}

}
