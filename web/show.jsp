<%@ page import="com.clmts.bean.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="com.clmts.bean.Order_Item" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/4/2
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core %>
<html>
<head>
    <title>订单信息</title>
</head>
<body>
<table border="1px">
    <tr>
        <th>订单id</th>
        <th>订单时间</th>
        <th>下单经理</th>
        <th>顾客姓名</th>
        <th>顾客地址</th>
        <th>顾客电话</th>
        <th>总价</th>
    </tr>
    <c:forEach items="${requestScope.order_list}" var="order">
    <tr>
        <td>${order.order_id}</td>
        <td>${order.time}</td>
        <td>${order.manager.uname}</td>
        <td>${order.custom_name}</td>
        <td>${order.custom_address}</td>
        <td>${order.custom_phone}</td>
        <td>${order.total}</td>
        <td></td>
    </tr>
    </c:forEach>

</table>



</body>
</html>
