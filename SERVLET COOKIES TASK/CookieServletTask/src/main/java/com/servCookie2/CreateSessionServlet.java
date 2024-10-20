package com.servCookie2;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;


public class CreateSessionServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Create session
		HttpSession session = request.getSession();
		session.setAttribute("name", "John Doe");
		session.setAttribute("email", "john.doe@example.com");

		response.getWriter().println("Session created and attributes set.");
	}
}
