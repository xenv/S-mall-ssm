<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>出错了</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
</head>

<%@include file="include/top.jsp"%>
<main class="search" style="margin-bottom: 10%;margin-top: 5%;">
<div class="alert alert-warning" role="alert">
    <%=exception.toString()%>
</div>
</main>
<%@include file="include/footer.jsp"%>
