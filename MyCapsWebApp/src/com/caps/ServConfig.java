package com.caps;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServConfig")
public class ServConfig extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstname = req.getParameter("fname");
		String lastname = req.getParameter("lname");
		
		ServletConfig config = getServletConfig();
		String privateEmail = config.getInitParameter("email");
		
		
		System.out.println(firstname);
		System.out.println(lastname);
		PrintWriter out = resp.getWriter();
		out.println("<h1>The Date is: "+ new Date() +"</h1>");
		out.println("The Name is: "+firstname+ " "+ lastname);
		out.println("<br> "+privateEmail);
	}
}
