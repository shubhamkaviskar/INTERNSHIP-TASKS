package com.servCookie;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


public class SetCookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("userPreference", "darkMode");
        cookie.setMaxAge(60 * 60 * 24); // 1 day
        response.addCookie(cookie);
        response.getWriter().println("Cookie has been set!");
    }
}

