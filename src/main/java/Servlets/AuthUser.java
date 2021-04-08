package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Servlets.Auth", value = "/auth")
public class AuthUser extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null) {
            username = request.getSession().getAttribute("username").toString();
            if (username == null) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            }
        }
        else {
            request.getSession().setAttribute("username", username);
        }
        if (password == null) {
            password = request.getSession().getAttribute("password").toString();
            if (password == null) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            }
        }
        else {
            request.getSession().setAttribute("password", password);
        }

        if (username.equals("user") &&
            password.equals("xxxx")) {
            request.getRequestDispatcher("WEB-INF/admin/index.jsp").forward(request,response);
        } else {
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
