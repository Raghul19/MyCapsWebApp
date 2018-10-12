package com.caps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forwardExample")
public class ServForward1 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Got a Request "+ getClass());
		PrintWriter out = resp.getWriter();
		out.println("<h1>Serv 1 respons</h1>");
		RequestDispatcher dispatcher =
				 req.getRequestDispatcher("/forwardExample2");
		dispatcher.include(req,resp);
		
		dispatcher = req.getRequestDispatcher("/date");
		dispatcher.include(req, resp);
	}
	
}