<%--
  Created by IntelliJ IDEA.
  User: bia
  Date: 2020/4/2
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            /*
                var option1 = document.createElement("option");
                option1.value = "1";
                select.appendChild(option1);
                var text1 = document.createTextNode("洗发水");
                option1.appendChild(text1);

             */
                <c:forEach items="${requestScope.productList}" var="product" varStatus="status">
                    var option${status.index+1} = document.createElement("option");
                    option${status.index+1}.value = "${status.index+1}";
                    select.appendChild(option${status.index+1});
                    var text${status.index+1} = document.createTextNode("${product.pname}"+"(￥${product.price})");
                    option${status.index+1}.appendChild(text${status.index+1});
                </c:forEach>
        one_item.appendChild(document.createTextNode("价格"));
        var price = document.createElement("input");
        price.name = "price";
        price.type = "text";
        one_item.appendChild(price);
    }
    function fun1() {
        var list = document.getElementById("order-item");
        list.removeChild(list.childNodes[list.childNodes.length-1]);
    }
</script>
<body>
<div style="text-align: center;">
<form action="${pageContext.request.contextPath}/order/addOrder.do" method="post">
    用户姓名:<input name="name" type="text"><br>
    用户电话:<input name="phone" type="tel"><br>
    配送地址:<input name="address" type="text"><br><br>
    <div id="order-item">
    <!--
    <div id="one-item">
        <select name="product_id">
            <option value="1">洗发水</option>
            <option value="2">沐浴露</option>
        </select>
        价格:<input name="price" type="text">
    </div>
    -->
    </div>
    <br>
    <input type="button" value="添加商品" id="button" onclick="fun()">
    <input type="button" value="移除商品" id="button1" onclick="fun1()"><br>
    <input type="submit" value="提交">
</form>
</div>
</body>
</html>
