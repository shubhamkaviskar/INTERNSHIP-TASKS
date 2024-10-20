package com.servCookie2;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;


public class ReadSessionServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false); // Get existing session
		if (session != null) {
			String name = (String) session.getAttribute("name");
			String email = (String) session.getAttribute("email");
			response.getWriter().println("User Name: " + name);
			response.getWriter().println("User Email: " + email);
		} else {
			response.getWriter().println("No session found.");
		}
	}
}
