package com.caps.beans;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caps.beans.Cat;
import com.caps.beans.Dog;

@WebServlet("/serv3a")
public class Serv3a extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Serv3a");
		Dog d = (Dog)req.getAttribute("dog");
		PrintWriter out = resp.getWriter();
		out.println(d);
		
		ServletContext ctx = getServletContext();
		Cat c = (Cat)ctx.getAttribute("cat");
		out.println(c);
	}
}
