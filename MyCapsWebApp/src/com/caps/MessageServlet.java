package com.caps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/msg")
public class MessageServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String msg = req.getParameter("msg");
		
		//System.out.println("User: "+ req.getHeader("User-Agent"));
		System.out.println(msg);
		System.out.println("****************************************");
		
		PrintWriter out = resp.getWriter();
		out.println("<h1>Message Received.</h1>");
	}
}
