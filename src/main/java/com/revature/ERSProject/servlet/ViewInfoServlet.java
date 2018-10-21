package com.revature.ERSProject.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ERSProject.model.ErsUser;


@SuppressWarnings("serial")
@WebServlet("/accountInfo")
public class ViewInfoServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ErsUser user = (ErsUser) req.getSession().getAttribute("user");
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("<h1>Your Info</h1><br>" + user.toString());
	}
}
