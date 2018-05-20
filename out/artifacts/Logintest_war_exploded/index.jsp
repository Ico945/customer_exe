<%--
  Created by IntelliJ IDEA.
  User: yehen
  Date: 2018/5/18
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加顾客信息</title>
    <script type="text/javascript">
        function check(form) {
            with(form){
                if(id.value == ""){
                    alert("id不能空");
                    return false;
                }
                if(user_id.value == ""){
                    alert("User_id不能空");
                    return false;
                }
                if(merchant_id.value == ""){
                    alert("Merchant_id不能空");
                    return false;
                }
                if(coupon_id.value == ""){
                    alert("Coupon_id不能空");
                    return false;
                }
                if(discount_rate.value == ""){
                    alert("Discount_rate不能空");
                    return false;
                }
                if(distance.value == ""){
                    alert("Distance不能空");
                    return false;
                }
            }
        }
    </script>
</head>
<body>
<form action="addcustomer.jsp" method="post" onsubmit="check(this)">
    <table align="center" width="450">
        <tr>
            <td align="center" colspan="2">
                <h2>添加顾客信息</h2>
                <hr>
            </td>
        </tr>

        <tr>
            <td align="right">id:</td>
            <td><input type="text" name="id"></td>
        </tr>

        <tr>
            <td align="right">User_id:</td>
            <td><input type="text" name="user_id"></td>
        </tr>

        <tr>
            <td align="right">Merchant_id:</td>
            <td><input type="text" name="merchant_id"></td>
        </tr>

        <tr>
            <td align="right">Coupon_id:</td>
            <td><input type="text" name="coupon_id"></td>
        </tr>

        <tr>
            <td align="right">Discount_id:</td>
            <td><input type="text" name="discount_rate"></td>
        </tr>

        <tr>
            <td align="right">Distance:</td>
            <td><input type="text" name="distance"></td>
        </tr>

        <tr>
            <td align="right">Date_received:</td>
            <td><input type="text" name="date_received"></td>
        </tr>

        <tr>
            <td align="center" colspan="2"><input type="submit" value="添　加">
            </td>
        </tr>

    </table>
</form>

<h2 align="center">
    <a href="Servlet/FindServlet">查询顾客信息</a>
</h2>
</body>
</html>
