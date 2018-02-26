<%--
  Created by IntelliJ IDEA.
  User: xen
  Date: 2017/12/3
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>


<div class="container text-center" >
    <nav aria-label="..." >
        <ul class="pagination">

            <li class="page-item ${pagination.hasPrevious ? '':'disabled'}">
                <a class="page-link" href="?start=0${pagination.param}" tabindex="-1">«</a>
            </li>
            <li class="page-item ${pagination.hasPrevious ? '':'disabled'}">
                <a class="page-link" href="?start=${pagination.start-pagination.count<0?0:pagination.start-pagination.count}${pagination.param}" tabindex="-1">‹</a>
            </li>

            <c:forEach begin="0" end="${pagination.totalPage}" varStatus="vs">
            <li class="page-item ${vs.index * pagination.count == pagination.start ? 'active':''}">
                <a class="page-link" href="?start=${vs.index*pagination.count}${pagination.param}">
                        ${vs.count}
                </a>
            </li>
            </c:forEach>

            <li class="page-item" ${pagination.hasNext ? '':'disabled'}>
                <a class="page-link" href="?start=${pagination.start+pagination.count}${pagination.param}">›</a>
            </li>
            <li class="page-item" ${pagination.hasNext ? '':'disabled'}>
                <a class="page-link" href="?start=${pagination.lastPage}${pagination.param}">»</a>
            </li>
        </ul>
    </nav>
</div>
