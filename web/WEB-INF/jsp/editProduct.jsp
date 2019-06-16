<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-06-09
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Eidt Product</title>

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
    }
    div{
        margin: 10px auto;
        width: 800px;
        border:1px solid deepskyblue;
        background-color: lightskyblue;
    }
    input{
        background-color: lightskyblue;
    }
</style>

<div align="center">
    <form method="post" action="updateProduct">
        Product Name:<input name="name" value="${p.name}" type="text"><br>
        Product Price:<input name="price" value="${p.price}" type="number"><br>
        <input type="hidden" value="${p.id}" name="id"/>
        <input type="submit" value="submit product">
    </form>
</div>
</body>
</html>
