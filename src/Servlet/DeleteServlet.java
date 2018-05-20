package Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));

        final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        final String User_name = "root";
        final String Password = "123456";
        final String DB_url = "jdbc:mysql://localhost:3306/mbti?serverTimezone=UTC&useSSL = false";

        Connection con = null;
        PreparedStatement ps = null;

        try{
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_url, User_name, Password);
            String sql = "delete from test where id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        resp.sendRedirect("FindServlet");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
