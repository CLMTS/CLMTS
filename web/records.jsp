<%--
  Created by IntelliJ IDEA.
  User: bia
  Date: 2020/4/2
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>记录订单 - CLMTS宇宙大明星</title>
</head>
<script>
    function fun() {
        let block = "<select name=\"product_id\">\n" +
            "        <option value=\"1\">洗发水</option>\n" +
            "        <option value=\"2\">沐浴露</option>\n" +
            "    </select>\n" +
            "    价格:<input name=\"price\" type=\"text\">";
        document.getElementById("order-tiem").innerText=block;
    }
</script>
<body>
<form action="/OrderServlet">
    用户姓名:<input name="name" type="text">
    用户电话:<input name="phone" type="tel">
    配送地址:<input name="address" type="text"><br><br>
    <div id="order-tiem"></div>
    <button onclick="fun()">添加商品</button>
    <select name="product_id">
        <option value="1">洗发水</option>
        <option value="2">沐浴露</option>
    </select>
    价格:<input name="price" type="text">
</form>
</body>
</html>
