package com.servCookie;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


public class ReadCookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String userPreference = "Not Set";

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userPreference")) {
                    userPreference = cookie.getValue();
                    break;
                }
            }
        }

        response.getWriter().println("User Preference: " + userPreference);
    }
}
