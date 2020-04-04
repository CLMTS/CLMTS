<%--
  Created by IntelliJ IDEA.
  User: bia
  Date: 2020/4/2
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<head>
    <title>记录订单 - CLMTS宇宙大明星</title>
</head>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script>
    function fun() {
        var div = document.getElementById("order-item");
        var one_item = document.createElement("div");
        div.appendChild(one_item);
        var select = document.createElement("select");
        select.name = "product_id";
        one_item.appendChild(select);
        var option1 = document.createElement("option");
        option1.value = "1";
        var option2 = document.createElement("option");
        option2.value = "2";
        select.appendChild(option1);
        var text1 = document.createTextNode("洗发水");
        option1.appendChild(text1);
        select.appendChild(option2);
        var text2 = document.createTextNode("沐浴露");
        option2.appendChild(text2);
        one_item.appendChild(document.createTextNode("价格"));
        var price = document.createElement("input");
        price.name = "price";
        price.type = "text";
        one_item.appendChild(price);
    }
</script>
<body>
<form action="OrderServlet" method="post">
    用户姓名:<input name="name" type="text"><br>
    用户电话:<input name="phone" type="tel"><br>
    配送地址:<input name="address" type="text"><br><br>
    <div id="order-item"></div>
    <!--
        <select name="product_id">
            <option value="1">洗发水</option>
            <option value="2">沐浴露</option>
        </select>
        价格:<input name="price" type="text">
    -->
    <br>
    <input type="button" value="add" id="button" onclick="fun()">
    <input type="submit" value="提交">
</form>
</body>
</html>
