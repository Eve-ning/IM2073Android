package Servlets;

import DBHandler.DBHandler;
import ServletBridge.ServletChoiceBridge;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "Servlets.ServletChoice", value = "/choice")
public class ServletChoice extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("success", false);
        try {
            String username = request.getParameter("username");
            DBHandler dbHandler = new DBHandler();
            ResultSet resultSet = dbHandler.executeQuery(
                    "SELECT * FROM credentials WHERE username LIKE '" + username + "'");
            if (!resultSet.isBeforeFirst()) {
                throw new SQLException("Cannot find id associated with username, aborting.");
            }

            resultSet.next();
            boolean status = ServletChoiceBridge.addChoice(
                    resultSet.getString("id"),
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
