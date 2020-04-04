<%--
  Created by IntelliJ IDEA.
  User: bia
  Date: 2020/4/4
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>订单详情 - CLMTS宇宙大明星</title>
</head>
<body>
<div style="text-align: center">
    姓名：${requestScope.order.custom_name}&nbsp;
    电话：${requestScope.order.custom_phone}&nbsp;
    地址：${requestScope.order.custom_address}<br>
    <h4>购物清单</h4>
    <table style="margin:auto" border="1">
        <tr>
            <th>序号</th>
            <th>商品</th>
            <th>售价</th>
            <th>成本</th>
        </tr>
        <c:forEach items="${requestScope.order.orderItemList}" var="item" varStatus="status">
        <tr>
            <td>${status.index+1}</td>
            <td>${item.product.pname}</td>
            <td>${item.price}</td>
            <td>${item.product.price}</td>
        </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
