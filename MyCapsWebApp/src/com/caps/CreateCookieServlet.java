package com.caps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createCookie")
public class CreateCookieServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie1 = new Cookie("name", "Aatish");
		cookie1.setMaxAge(60*60*24);
		Cookie cookie2 = new Cookie("address","earth");
		Cookie cookie3 = new Cookie("email", "aatish@gmail.com");
		
		resp.addCookie(cookie1);
		resp.addCookie(cookie2);
		resp.addCookie(cookie3);
		
	
			
		PrintWriter out = resp.getWriter();
		out.println("Cookie Received");
	}
	
}