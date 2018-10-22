package com.revature.ERSProject.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ERSProject.model.ErsUser;
import com.revature.ERSProject.repository.ReimbursementsDao;

@SuppressWarnings("serial")
@WebServlet("/approveRequest")
public class ApproveRequestServlet extends HttpServlet {
	
	ReimbursementsDao rdao = new ReimbursementsDao();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ErsUser user = (ErsUser) req.getSession().getAttribute("user");
		
		req.getRequestDispatcher("approve.html").forward(req, resp);
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ErsUser user = (ErsUser) req.getSession().getAttribute("user");
				
		 Integer requestId = Integer.parseInt(req.getParameter("request"));
		 rdao.approveReimbursementRequest(user, requestId);		
		
		 resp.sendRedirect("manager");
	}
	

}
