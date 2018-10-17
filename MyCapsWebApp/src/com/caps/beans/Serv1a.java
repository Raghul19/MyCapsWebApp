package com.caps.beans;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caps.beans.Cat;
import com.caps.beans.Dog;

@WebServlet(urlPatterns="/serv1a", 
		initParams=@WebInitParam(name="pwd",value="root"))
public class Serv1a extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Serv1a");
		Dog d = new Dog();
		d.setName("Bingo");
		d.setColor("White");
		d.setBreed("Pomerian");
		
		req.setAttribute("dog", d);
		
		Cat c = new Cat();
		c.setName("Genie");
		c.setColor("White");
		c.setGender("Unknown");
		
		ServletContext ctx = getServletContext();
		ctx.setAttribute("cat", c);
		
		
		
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/serv2a");
		dispatcher.forward(req, resp);
	}
}