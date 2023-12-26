package com.vladproduction.servletstarter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Date;

@WebServlet(name = "hello2Servlet", value = {"/hello2-servlet"})
public class Hello2Servlet extends HttpServlet {
    private String message;


    public void init() {
        message = "Hello2 Servlet welcome now!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello2
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>" + message + "</h3>");
        out.println("</body></html>");
    }


    public void destroy() {
    }
}