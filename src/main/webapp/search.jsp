<%--
  Created by IntelliJ IDEA.
  User: xen
  Date: 2017/12/9
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="${keyword}的搜索结果 - 搜索 - ${website_name}" />
<%@include file="include/header.jsp"%>
<%@include file="include/top.jsp"%>
<%@include file="include/search.jsp"%>
<%@include file="include/category/searchPage.jsp"%>
<%@include file="include/footer.jsp"%>