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
@WebServlet("/submitRequest")
public class SubmitRequestServlet extends HttpServlet {
	
	ReimbursementsDao rdao = new ReimbursementsDao();

	public SubmitRequestServlet() {
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ErsUser user = (ErsUser) req.getSession().getAttribute("user");
		
		req.getRequestDispatcher("submit-request.html").forward(req, resp);
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ErsUser user = (ErsUser) req.getSession().getAttribute("user");
		rdao.insertReimbursementRequest(user, 500, "Chirstmas Party");
	}

}
