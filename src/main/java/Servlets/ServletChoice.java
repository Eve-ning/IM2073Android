package Servlets;

import ServletBridge.ServletChoiceBridge;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Servlets.ServletChoice", value = "/choice")
public class ServletChoice extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            boolean status = ServletChoiceBridge.addChoice(
                    request.getParameter("userId"),
                    request.getParameter("choice"),
                    request.getParameter("qNo")
            );
            request.setAttribute("success", status);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        request.getRequestDispatcher("choice.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
