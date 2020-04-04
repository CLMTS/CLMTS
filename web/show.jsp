<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/4/2
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>订单信息 - CLMTS宇宙大明星</title>
</head>
<body>
<div style="text-align: center;">
    <a href="${pageContext.request.contextPath}/ProductServlet" style="text-decoration: none">记录订单</a>
<table border="1" style="margin:auto">
    <tr>
        <th>订单id</th>
        <th>订单时间</th>
        <th>下单经理</th>
        <th>顾客姓名</th>
        <th>总价</th>
    </tr>
    <c:forEach items="${requestScope.orderList}" var="order">
    <tr>
        <td><a href="${pageContext.request.contextPath}/order/searchOne.do?order_id=${order.order_id}" style="text-decoration: none; color: #4a77d4">${order.order_id}</a></td>
        <td>${order.time}</td>
        <td>${order.manager.uname}</td>
        <td>${order.custom_name}</td>
        <td>${order.total}</td>
    </tr>
    </c:forEach>

</table>
</div>
</body>
</html>
