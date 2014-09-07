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

/**
 * Servlet implementation class PublishAdd
 */
@WebServlet("/PublishAdd")
public class PublishAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PublishAdd() {
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
		AgentManager aManger = (AgentManager) session.getAttribute("manager");
		AdvertsimentInfo aInfo = new AdvertsimentInfo();
		aInfo.setPropertyId(request.getParameter("pId"));
		aInfo.setPropertyInfo(request.getParameter("pInfo"));
		aInfo.setPropertyType(request.getParameter("pType"));
		aInfo.setAddress(request.getParameter("pAddress"));
		aInfo.setCityName(request.getParameter("pCity"));
		aInfo.setZipCode(request.getParameter("pZip"));
		aInfo.setLang(request.getParameter("pLang"));
		aInfo.setLat(request.getParameter("pLat"));
		List<String> iList = new ArrayList<String>();
		iList.add(request.getParameter("pI1"));
		iList.add(request.getParameter("pI2"));
		iList.add(request.getParameter("pI3"));
		aInfo.setImgLocation(iList);

		List<String> vList = new ArrayList<String>();
		vList.add(request.getParameter("pV1"));
		aInfo.setVideoLocation(vList);
		aInfo.setPrice(request.getParameter("pPrice"));
		aManger.setAddInfo(aInfo);
		aManger.createModifyAdd("modify");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		AgentManager aManger = (AgentManager) session.getAttribute("manager");
		AdvertsimentInfo aInfo = new AdvertsimentInfo();
		aInfo.setPropertyId(request.getParameter("pId"));
		aInfo.setPropertyInfo(request.getParameter("pInfo"));
		aInfo.setPropertyType(request.getParameter("pType"));
		aInfo.setAddress(request.getParameter("pAddress"));
		aInfo.setCityName(request.getParameter("pCity"));
		aInfo.setZipCode(request.getParameter("pZip"));
		aInfo.setLang(request.getParameter("pLang"));
		aInfo.setLat(request.getParameter("pLat"));
		List<String> iList = new ArrayList<String>();
		iList.add(request.getParameter("pI1"));
		iList.add(request.getParameter("pI2"));
		iList.add(request.getParameter("pI3"));
		aInfo.setImgLocation(iList);

		List<String> vList = new ArrayList<String>();
		vList.add(request.getParameter("pV1"));
		aInfo.setVideoLocation(vList);
		aInfo.setPrice(request.getParameter("pPrice"));
		aManger.setAddInfo(aInfo);
		aManger.createModifyAdd("new");

	}

}
