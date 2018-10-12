package com.caps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServGetContext extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletConfig config = getServletConfig();
		String email = config.getInitParameter("email");

		ServletContext ctx = config.getServletContext();
		String email2 = ctx.getInitParameter("Email");
		
		PrintWriter out = resp.getWriter();
		out.println(email);
		out.println(email2); 
	}
}