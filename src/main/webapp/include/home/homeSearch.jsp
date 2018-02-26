<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>


<script src="js/index.js"></script>

<header class="index-top">
    <a href="./" class="logo">
        <img src="img/logo.png">
    </a>
    <div class="search">
        <form action="search" >
        <input type="text" value="本网站仅供技术演示，源码见 http://github.com/xenv/S-mall-ssm" name="keyword">
        <button class="search-button" type="submit">搜索</button>
        </form>
        <ul class="search-below">
            <c:forEach items="${categories}" var="c" varStatus="vs">
                <c:if test="${vs.count>=1 and vs.count<=8}">
                    <li><a href="category?id=${c.id}">${c.name}</a></li>
                </c:if>
            </c:forEach>
        </ul>

    </div>

</header>