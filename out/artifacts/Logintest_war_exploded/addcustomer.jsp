<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%--
  Created by IntelliJ IDEA.
  User: yehen
  Date: 2018/5/18
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加顾客信息</title>
</head>
<body>
    <%
        request.setCharacterEncoding("utf-8");
    %>
    <jsp:useBean id="customer" class="Beans.Customer"></jsp:useBean>
    <jsp:setProperty property="*" name="customer"></jsp:setProperty>

    <%
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/mbti?serverTimezone=UTC&useSSL = false";
            Connection con = DriverManager.getConnection(url, "root", "123456");
            String sql = "insert into test(id, user_id, merchant_id, coupon_id, discount_rate, distance, date_received) values(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, customer.getId());
            ps.setString(2, customer.getUser_id());
            ps.setString(3, customer.getMerchant_id());
            ps.setString(4, customer.getCoupon_id());
            ps.setString(5, customer.getDiscount_rate());
            ps.setString(6, customer.getDistance());
            ps.setString(7, customer.getDate_received());

            int row = ps.executeUpdate();
            if(row > 0){
                out.print("成功添加了" + row + "条数据！");
            }
            ps.close();
            con.close();

        }catch (Exception e){
            System.out.println("连接异常，添加失败！");
            e.printStackTrace();
        }
    %>
    <<br>
    <<a href="index.jsp">返回</a>
</body>
</html>
