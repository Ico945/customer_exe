package Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        String discount_rate = req.getParameter("discount_rate");


        final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        final String User_name = "root";
        final String Password = "123456";
        final String DB_url = "jdbc:mysql://localhost:3306/mbti?serverTimezone=UTC&useSSL = false";

        Connection con = null;
        PreparedStatement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_url, User_name, Password);

            String sql = "update test set discount_rate = ? where id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, discount_rate);
            stmt.setInt(2, id);

            stmt.executeUpdate();    //执行更新

            stmt.close();
            con.close();

        } catch (Exception e){
            System.out.println("连接异常！(update)");
            e.printStackTrace();
        }

        resp.sendRedirect("FindServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
