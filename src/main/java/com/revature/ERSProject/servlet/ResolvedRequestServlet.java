package com.revature.ERSProject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ERSProject.model.ErsUser;
import com.revature.ERSProject.model.Reimbursements;
import com.revature.ERSProject.repository.ReimbursementsDao;

@SuppressWarnings("serial")
@WebServlet("/resolvedRequest")
public class ResolvedRequestServlet extends HttpServlet {
	
	ReimbursementsDao rdao = new ReimbursementsDao();
	List<Reimbursements> reimbursements;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ErsUser user = (ErsUser) req.getSession().getAttribute("user");
		reimbursements = rdao.getResolvedReimbursmentByUserId(user.getId());
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("<h1>Your Resolved Request</h1><br>" + reimbursements);
	}

}

