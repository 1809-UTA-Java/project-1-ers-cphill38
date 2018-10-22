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
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ErsUser user = (ErsUser) req.getSession().getAttribute("user");
		
		req.getRequestDispatcher("submit-request.html").forward(req, resp);
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ErsUser user = (ErsUser) req.getSession().getAttribute("user");
		
		 Integer amount = Integer.parseInt(req.getParameter("amount"));
		 String desc = req.getParameter("description");
		
		rdao.insertReimbursementRequest(user, amount, desc);
		
		resp.sendRedirect("employee");
	}

}
