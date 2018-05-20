package Servlet;

import Beans.Customer;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

public class FindServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        final String User_name = "root";
        final String Password = "123456";
        final String DB_url = "jdbc:mysql://localhost:3306/mbti?serverTimezone=UTC&useSSL = false";

        Connection con;
        Statement stmt;

        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_url, User_name, Password);
            stmt = con.createStatement();

            String sql = "select * from test";
            ResultSet result = stmt.executeQuery(sql);

            List<Customer> list = new ArrayList<>();

            while (result.next()){
                Customer customer = new Customer();

                customer.setId(result.getInt("id"));
                customer.setUser_id(result.getString("user_id"));
                customer.setMerchant_id(result.getString("merchant_id"));
                customer.setCoupon_id(result.getString("coupon_id"));
                customer.setDiscount_rate(result.getString("discount_rate"));
                customer.setDistance(result.getString("distance"));
                customer.setDate_received(result.getString("date_received"));

                list.add(customer);

            }
            request.setAttribute("list", list);
            result.close();
            stmt.close();
            con.close();

        } catch (Exception e){
            System.out.println("连接异常！(find)");
            e.printStackTrace();
        }

        request.getRequestDispatcher("/customer_list.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
