package web;

import DAO.SimulationDao;
import classes.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "Register", value = "/Register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection con = SimulationDao.getConnection();
        PreparedStatement ps= null;
        try {
            ps = con.prepareStatement("insert into login( username,  password) values (?,?)");
            ps.setString(1, request.getParameter("username"));
            ps.setString(2,request.getParameter("password"));
            ps.executeUpdate();
            con.close();
            //request.getRequestDispatcher("login.jsp").forward(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("Login.jsp").forward(request,response);

    }
}
