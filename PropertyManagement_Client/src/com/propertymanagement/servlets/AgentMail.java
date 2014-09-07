package com.propertymanagement.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.propertymanagement.DTO.AdvertsimentInfo;
import com.propertymanagement.agent.AgentManager;
import com.propertymanagement.utils.MailerSystem;

/**
 * Servlet implementation class AgentMail
 */
@WebServlet("/AgentMail")
public class AgentMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgentMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
			String mail=request.getParameter("eMail");
			String message=request.getParameter("mailVal");
			new MailerSystem().mail(mail, message);
			response.sendRedirect("BuyerValue.jsp");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("sdjobaajdbdasibdsib Reched hee");
		HttpSession session = request.getSession();
		AdvertsimentInfo addInfo=(AdvertsimentInfo)session.getAttribute("addInfo");
		AgentManager aManager=new AgentManager();
		aManager.sendMail(addInfo.getAgentId(), (String)request.getParameter("MailC"));
		response.sendRedirect("SearchAddView.jsp");
	}

}
