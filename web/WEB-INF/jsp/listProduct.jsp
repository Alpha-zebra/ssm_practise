<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-06-09
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Product</title>

</head>
<body>
<style>
    table{
        border:1px solid deepskyblue;
        text-align: center;
    }
    td{
        width: 200px;
        border:1px solid deepskyblue;
        background-color: lightskyblue;
        background-image: linear-gradient(bottom,lightblue,lightskyblue);
    }
    div{
        margin: 0px auto;
        text-align: center;
        width: 1015px;
        border:1px solid deepskyblue;
        background-color: lightskyblue;
    }
    input{
        background-color: lightskyblue;
    }
</style>
<%--<div id="categoryInfo">${ps.[page.start].category}</div>--%>
<table align="center" cellspacing="0">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>price</td>
        <td>category</td>
        <td>edit</td>
        <td>delete</td>
    </tr>
    <c:forEach items="${ps}" var="p" varStatus="st">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>${p.cid}</td>
            <td><a href="editProduct?id=${p.id}">edit</a> </td>
            <td><a href="deleteProduct?id=${p.id}">delete</a> </td>
        </tr>
    </c:forEach>
</table>
<div style="text-align: center">
    <a href="?start=0">首 页</a>
    <a href="?start=${page.start-page.count}">上一页</a>
    <a href="?start=${page.start+page.count}">下一页</a>
    <a href="?start=${page.last}">末 页</a>
</div>
<div>
    <form method="post" action="addProduct">
        Product Name:<input name="name" value="" type="text"><br>
        Product Price:<input name="price" value="" type="number"><br>
        Product CategoryID:<input name="category.id" value="" type="number"><br>
        <input type="submit" value="add product">
    </form>
</div>
</body>
</html>

