<%--
  Created by IntelliJ IDEA.
  User: xen
  Date: 2017/12/9
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<main class="pay-suc">
    <div class="payed-tip">
        <img src="img/pay_success.png">
        <span>您已成功付款</span>
    </div>
    <div class="payed-info">
        <ul>
            <li>收货地址： ${order.address} </li>
            <li>实付款：<span class="payed-num">￥${order.sum}</span></li>
        </ul>
    </div>
    <div class="payed-guide">
        您可以
        <a href="myOrder" class="payed-guide-link">查看已买到的宝贝</a>
        <a href="#nowhere" class="payed-guide-link">查看交易详情 </a>
    </div>
    <div class="payed-warning">
        <img src="img/warning.png">
        <b>安全提醒：</b>下单后，<span class="red-color bold-word">用QQ给您发送链接办理退款的都是骗子！</span>${website_name}不存在系统升级，订单异常等问题，谨防假冒客服电话诈骗！
    </div>
</main>