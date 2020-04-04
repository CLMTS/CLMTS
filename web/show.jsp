<%@ page import="com.clmts.bean.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="com.clmts.bean.Order_Item" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/4/2
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单信息</title>
</head>
<body>
<%
    List<Order> order = (List<Order>)request.getAttribute("orders");

%>
<table border="1px">
    <tr>

        <th>产品</th>
        <th>产品价格</th>
        <th>订单id</th>
        <th>订单时间</th>
        <th>下单经理</th>
        <th>顾客姓名</th>
        <th>顾客地址</th>
        <th>顾客电话</th>
        <th>总价</th>
    </tr>

    <%
        List<Order> orders = (List<Order>)request.getAttribute("");
    %>

    <%
        List<Order_Item> order_items = (List<Order_Item>)request.getAttribute("");
    %>
    <%
        for (Order_Item order_item:order_items){
    %>
    <td><%=order_item.getProduct_id() %></td>
    <td><%=order_item.getPrice() %></td>


    <%
        }
    %>
    <%
        for(Order order1:orders){
    %>
    <tr>
        <td><%= order1.getOrder_id() %></td>
        <td><%= order1.getTime() %></td>
        <td><%= order1.getManager() %></td>
        <td><%= order1.getCustom_name() %></td>
        <td><%= order1.getCustom_address() %></td>
        <td><%= order1.getCustom_phone() %></td>
        <td><%= order1.getTotal() %></td>
        <%
            }
        %>

    </tr>


</table>



</body>
</html>
