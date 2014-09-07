package com.propertymanagement.servlets;

//Import required java libraries

import java.io.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;

import com.propertymanagement.DTO.AdvertsimentInfo;
import com.propertymanagement.agent.AgentManager;

/**
 * Servlet implementation class UploadImage
 */
public class UploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private boolean isMultipart;
	private String filePath;
	private int maxFileSize = 100000 * 1024;
	private int maxMemSize = 4 * 1024;
	private File file;

	public void init() {
		// Get the file location where it would be stored.
		filePath = getServletContext().getInitParameter("file-upload");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadImage() {
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

		throw new ServletException("GET method used with "
				+ getClass().getName() + ": POST method required.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// Check that we have a file upload request
		isMultipart = ServletFileUpload.isMultipartContent(request);
		response.setContentType("text/html");
		java.io.PrintWriter out = response.getWriter();
		if (!isMultipart) {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet upload</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<p>No file uploaded</p>");
			out.println("</body>");
			out.println("</html>");
			return;
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// maximum size that will be stored in memory
		factory.setSizeThreshold(maxMemSize);
		// Location to save data that is larger than maxMemSize.
		factory.setRepository(new File("C:\\temp275"));

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		// maximum file size to be uploaded.
		upload.setSizeMax(maxFileSize);
		List<String> imgName = new ArrayList<String>();

		try {
			// Parse the request to get file items.
			List fileItems = upload.parseRequest(request);

			// Process the uploaded file items
			Iterator i = fileItems.iterator();

			// out.println("<html>");
			// out.println("<head>");
			// out.println("<title>Servlet upload</title>");
			// out.println("</head>");
			// out.println("<body>");
			String fName = "";
			while (i.hasNext()) {
				FileItem fi = (FileItem) i.next();
				if (!fi.isFormField()) {
					// Get the uploaded file parameters
					String fieldName = fi.getFieldName();
					fName = fi.getName();
					String fileName = fi.getName();
					String contentType = fi.getContentType();
					boolean isInMemory = fi.isInMemory();
					long sizeInBytes = fi.getSize();
					// Write the file
					if (fileName.lastIndexOf("\\") >= 0) {
						file = new File(
								filePath
										+ fileName.substring(fileName
												.lastIndexOf("\\")));
					} else {
						file = new File(
								filePath
										+ fileName.substring(fileName
												.lastIndexOf("\\") + 1));
					}
					fi.write(file);
					out.println("Uploaded Filename: "
							+ fileName
							+ " is saved to your location in webapps/images<br>");
				}
			}
			HttpSession session = request.getSession();
			AgentManager aManager = (AgentManager) session
					.getAttribute("manager");
			AdvertsimentInfo aInfo = aManager.getAddInfo();
			if (aInfo.getImgLocation() != null) {
				imgName = aInfo.getImgLocation();
				imgName.add(fName);
			} else {
				imgName = new ArrayList<String>();
				imgName.add(fName);
			}
			System.out.println(fName);
			aInfo.setImgLocation(imgName);
			aManager.setAddInfo(aInfo);
			// out.println("</body>");
			// out.println("</html>");
		} catch (Exception ex) {
			System.out.println(ex);
			ex.printStackTrace();
		}
		if (imgName.size() < 3) {
		response.sendRedirect("Create_Add_Img.jsp");
		} else {
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/CreateAd");
			rd.forward(request, response);
		}
	}

}
