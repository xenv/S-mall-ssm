<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="js/search.js"></script>

<section class="select-bar">
    <a href="?id=${category.id}" class="${empty param.sort?'selected':''}">综合<span class="glyphicon glyphicon-arrow-down"></span></a>
    <a href="?id=${category.id}&sort=comment" class="${param.sort=='comment'?'selected':''}">人气<span class="glyphicon glyphicon-arrow-down"></span></a>
    <a href="?id=${category.id}&sort=date" class="${param.sort=='date'?'selected':''}">新品<span class="glyphicon glyphicon-arrow-down"></span></a>
    <a href="?id=${category.id}&sort=saleCount" class="${param.sort=='saleCount'?'selected':''}">销量<span class="glyphicon glyphicon-arrow-down"></span></a>
    <a href="?id=${category.id}&sort=${param.sort=='price'?'priceInverse':'price'}" class="${(param.sort=="price"||param.sort=="priceInverse")?'selected':''}">价格<span class="glyphicon glyphicon-resize-vertical"></span></a>
    <span class="price">
        <input type="text" placeholder="￥请输入" class="sortBarPrice beginPrice" id="low_price">
        <span>-</span>
        <input type="text" placeholder="￥请输入" class="sortBarPrice beginPrice" id="high_price">
    </span>
</section>

<%@include file="commonPage.jsp"%>