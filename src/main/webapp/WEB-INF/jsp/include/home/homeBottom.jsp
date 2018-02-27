<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>


<main class="index">
    <c:forEach items="${categories}" var="c" varStatus="vs">
        <c:if test="${c.recommend > 0}">
            <div class="products">
                <div class="title-bar">
                    <i class="color-mark"></i>
                    <span class="category-title">${c.name}</span>
                </div>

                <div class="product-items">
                    <c:forEach items="${c.products}" var="p" varStatus="vs">
                    <a href="product?id=${p.id}">
                        <div class="item">
                            <img src="${productImgDir}${p.image.path}">
                            <div class="item-title">${p.name}</div>
                            <div class="item-price">￥${p.nowPrice}</div>
                        </div>
                    </a>
                    </c:forEach>
                </div>
            </div>
        </c:if>
    </c:forEach>

    <img src="img/end.png" class="end-png" id="endpng">
</main>