<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-06-09
  Time: 8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" isELIgnored="false" import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="../../jquery.min.js"></script>
<html>
<head>
    <title>List Category</title>

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
        width: 808px;
        border:1px solid deepskyblue;
        background-color: lightskyblue;
    }
    input{
        background-color: lightskyblue;
    }
</style>
<script type="text/javascript">
    $(function () {
        $(".delete").click(function () {
            var href=$(this).attr("href");
            $("#formdelete").attr("action",href).submit();
            return false;

        })

    })
</script>

<table align="center" cellspacing="0">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>edit</td>
        <td>delete</td>
    </tr>
    <c:forEach items="${cs}" var="c" varStatus="st">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td><a href="categories/${c.id}">edit</a> </td>
            <td><a class="delete" href="categories/${c.id}">delete</a> </td>
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
    <form method="post" action="categories">
        Category Name:<input name="name" value="" type="text"><BR>
        <input type="submit" value="add category">
    </form>
</div>
<form id="formdelete" action="" method="post">
    <input type="hidden" name="_method" value="DELETE">
</form>
</body>
</html>
