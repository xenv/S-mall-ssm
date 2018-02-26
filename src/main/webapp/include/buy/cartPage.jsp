<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>


<script src="js/cart.js"></script>
<main class="cart">
    <form action = "buy">
    <div class="sum-top">
        <div class="pull-right">
            <span>已选商品（不含运费）</span>
            <span class="yen-small">￥</span>
            <span class="cart-sum-price-small cart-sum-price">0.00</span>
            <button class="crate-order-small crate-order">结 算</button>
        </div>
    </div>

    <table class="cart-list">

        <thead>
        <tr>
            <th class="select-and-image">
                <img src="img/noselect.png" class="select-img select-all" select="false">
                <span>全选</span>
            </th>
            <th class="item-info">
                商品信息
            </th>
            <th class="price-per">
                单价
            </th>
            <th class="item-num">
                数量
            </th>
            <th class="item-price">
                金额
            </th>
            <th class="operation">
                操作
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cartItems}" var="item">
            <tr select="false" stock="${item.product.stock}" buy = "${item.number}" price-per="${item.product.nowPrice}" ciid="${item.id}">
                <input type="hidden" name="ciid" value="${item.id}">
                <td>
                    <img src="img/noselect.png" class="select-img">
                    <img src="${productImgDir}${item.product.image.path}" class="cart-item-jpg">
                </td>
                <td class="item-name">
                    <a class="cart-item-title" href="product?id=${item.product.id}">${item.product.name}</a>
                    <div class="cart-item-title-bottom">
                        <img title="支持信用卡支付" src="img/creditcard.png">
                        <img title="消费者保障服务,承诺7天退货" src="img/7day.png">
                        <img title="消费者保障服务,承诺如实描述" src="img/promise.png">
                    </div>
                </td>
                <td>
                    <span class="cart-item-old-price">￥${item.product.originalPrice}</span>
                    <span class="cart-item-now-price">￥${item.product.nowPrice}</span>
                </td>
                <td>
                    <div class="cart-change">
                        <a href="javascript:void(0);" class="cart-decrease cart-change-button">-</a><input value="${item.number}" class="item-num-input"><a href="javascript:void(0);" class="cart-increase cart-change-button">+</a>
                    </div>
                </td>
                <td>
                    <span class="cart-item-sum">￥${item.sum}</span>
                </td>
                <td>
                    <a href="javascript:void(0);" class="delete-button" ciid="${item.id}">删除</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>


    <div class="sum-bottom  clear">
        <img src="img/noselect.png" class="select-img select-all" select="false">
        <span>全选</span>
        <div class="pull-right">
            <span>
                已选商品
                <span class="cart-num">0</span>
                件
            </span>
            <span class="sum-text">合计（不含运费）</span>
            <span class="yen-big">￥</span>
            <span class="cart-sum-price cart-sum-price-big">0.00</span>
            <button class="crate-order-big crate-order" type="submit">结 算</button>
        </div>
    </div>
    </form>

    <div class="modal" tabindex="-1" role="dialog" id="confirmModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-title">删除宝贝</div>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>

                <div class="confirm-content">确认要删除该宝贝吗？</div>
                <div class="button-group">
                    <button class="yes" id="confirmDelete">确定</button>
                    <button class="no" id="cancelDelete">取消</button>
                </div>
            </div>
        </div>
    </div>
</main>

