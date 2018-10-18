package com.revature.ERSProject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.revature.ERSProject.model.ErsUser;
import com.revature.ERSProject.repository.UserDao;
import com.revature.ERSProject.util.HibernateUtil;

@SuppressWarnings("serial")
@WebServlet("/users")
public class UserServlet extends HttpServlet {

	ErsUser user;
	UserDao udao = new UserDao();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		user = udao.getEmployeeByUsername(req.getParameter("username"));
		resp.setContentType("text/xml");
		/*ObjectMapper om = new XmlMapper();
		String obj = om.writeValueAsString(users);
		PrintWriter pw = resp.getWriter();
		pw.print(obj);
		pw.close();*/
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if(username.equals(user.getUsername()) && password.equals(user.getPassword())) {
			req.getSession().setAttribute("user", user);
			req.getRequestDispatcher("manager-homepage.html").forward(req, resp);
		}
		else
			System.out.println("Login Failed!");
	}

	@Override
	public void destroy() {
		HibernateUtil.shutdown();
	}

}