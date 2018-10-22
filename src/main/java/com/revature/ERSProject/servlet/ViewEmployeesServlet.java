package com.revature.ERSProject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ERSProject.model.ErsUser;
import com.revature.ERSProject.repository.UserDao;



@SuppressWarnings("serial")
@WebServlet("/viewEmployees")
public class ViewEmployeesServlet extends HttpServlet {

	List<ErsUser> employees = new ArrayList<>();
	UserDao udao = new UserDao();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ErsUser user = (ErsUser) req.getSession().getAttribute("user");
		resp.setContentType("text/html");
		employees = udao.getUsers();
		PrintWriter pw = resp.getWriter();
		pw.println("<h1>Employees</h1><br>" + employees);
	}

}
