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
import com.propertymanagement.agent.AgentAddSearchCriteria;
import com.propertymanagement.agent.AgentManager;

/**
 * Servlet implementation class ViewAdd
 */
@WebServlet("/ViewAdd")
public class ViewAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewAdd() {
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
		AgentAddSearchCriteria aManager = (AgentAddSearchCriteria) session.getAttribute("searchObj");
		List<AdvertsimentInfo> aInfo = aManager.getSearchedList();
		String propId=(String)request.getParameter("pId");
		System.out.println("slnsldjnsodjbsodb"+propId);
		for(AdvertsimentInfo addObj:aInfo)
		{
			if(addObj.getPropertyId().equalsIgnoreCase(propId))
			{
				System.out.println("FOUNFJKBBIKHBB");
				session.setAttribute("addInfo", addObj);
				break;
			}
		}
//		session.setAttribute("addInfo",aManager.getAgentInfo().getAddList().get(0));
		response.sendRedirect("SearchAddView.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		AgentManager aManager = (AgentManager) session.getAttribute("manager");
		List<AdvertsimentInfo> aInfo = aManager.getAgentInfo().getAddList();
		String propId=(String)request.getParameter("pId");
		System.out.println("slnsldjnsodjbsodb"+propId);
		for(AdvertsimentInfo addObj:aInfo)
		{
			if(addObj.getPropertyId().equalsIgnoreCase(propId))
			{
				System.out.println("FOUNFJKBBIKHBB");
				session.setAttribute("addInfo", addObj);
				break;
			}
		}
//		session.setAttribute("addInfo",aManager.getAgentInfo().getAddList().get(0));
		response.sendRedirect("ViewAdd.jsp");
	}

}
