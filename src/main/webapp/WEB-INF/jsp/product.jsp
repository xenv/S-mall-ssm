<%--
  Created by IntelliJ IDEA.
  User: xen
  Date: 2017/12/7
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="${product.name} - 产品 - ${website_name}" />
<%@include file="include/header.jsp"%>
<%@include file="include/top.jsp"%>
<%@include file="include/simpleSearch.jsp"%>
<%@include file="include/product/productTop.jsp"%>
<%@include file="include/product/productCenter.jsp"%>
<%@include file="include/product/productBottom.jsp"%>
<%@include file="include/footer.jsp"%>
