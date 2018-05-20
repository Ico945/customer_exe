<%@ page import="Beans.Customer" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: yehen
  Date: 2018/5/2
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>所有顾客信息</title>

  </head>
  <body>
  <table align="center" width="450" border="1" height="180"
         bordercolor="white" bgcolor="black" cellpadding="1" cellspacing="1">
    <tr bgcolor="white">
      <td align="center" colspan="7">
        <h2>所有顾客信息</h2>
      </td>
    </tr>
    <tr align="center" bgcolor="#e1ffc1">
      <td><b>id</b></td>
      <td><b>User_id</b></td>
      <td><b>Merchant_id</b></td>
      <td><b>Coupon_id</b></td>
      <td><b>Discount_rate</b></td>
      <td><b>Distance</b></td>
      <td><b>Date_received</b></td>
    </tr>
    <%
      List<Customer> list = (List<Customer>) request.getAttribute("list");
      if (list == null || list.size() < 1) {
        out.print("没有数据！");
      } else {
        for (Customer customer : list) {
    %>
    <tr align="center"  bgcolor="white">
      <td><%=customer.getId()%></td>
      <td><%=customer.getUser_id()%></td>
      <td><%=customer.getMerchant_id()%></td>
      <td><%=customer.getCoupon_id()%></td>
      <td><%=customer.getDiscount_rate()%></td>
      <td><%=customer.getDistance()%></td>
      <td><%=customer.getDate_received()%></td>
      <td >
        <form style="align:center;  background-color: gray" action="UpdateServlet" method="post">
          <input type="hidden" name="id" value="<%=customer.getId()%>">
          <input type="text" name="discount_rate" size="3">
          <input type="submit" value="修改">
        </form>
      </td>
      <td>
        <a href="/Servlet/DeleteServlet?id=<%=customer.getId()%>">删除</a>
      </td>


    </tr>
    <%
        }
      }
    %>
  </table>
  <h2 align="center">
    <a href="/index.jsp">返回添加顾客信息页面</a>
  </h2>
  </body>
</html>
