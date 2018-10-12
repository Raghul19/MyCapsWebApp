package com.caps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caps.ServContext;
//import com.caps.random.jokes.RandomJokeGeneratorPrototype;

@WebServlet("/forwardExample2")
public class ServForward2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Got a Request "+ getClass());
		
		PrintWriter out = resp.getWriter();
		out.println("/ServContext");
		
	}
	
}
