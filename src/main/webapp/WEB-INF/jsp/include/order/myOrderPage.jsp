<%--
  Created by IntelliJ IDEA.
  User: xen
  Date: 2017/12/9
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<script>
    var deleteOid = -1;
    $(function () {
        $(".order-type a").click(function () {
            var orderStatus = $(this).attr("order-status");
            if('all'===orderStatus){
                $("table[order-status]").show();
            }else{
                $("table[order-status]").hide();
                $("table[order-status="+orderStatus+"]").show();
            }
            $(".order-type div").removeClass("selected");
            $(this).parent("div").addClass("selected");

        });
        $(".delete-button").click(function () {
            deleteOid = $(this).attr("oid");
            $("#confirmModal").modal('show');
        });
        $("#confirmDelete").click(function () {
            $("#confirmModal").modal("hide");
            var page = "deleteOrder";
            $.get(page,{"oid":deleteOid},function (result) {
                if(result === "success"){
                    $("table[oid="+deleteOid+"]").remove();
                }else{
                    alert("服务器错误，删除失败");
                }
            });
        });
        $("#cancelDelete").click(function () {
            $("#confirmModal").modal("hide");
        });
    });
</script>

<section class="order-type">
    <div class="selected"><a href="#nowhere" order-status="all">所有订单</a></div>
    <div><a href="#nowhere" order-status="waitPay">待付款</a></div>
    <div><a href="#nowhere" order-status="waitDelivery">待发货</a></div>
    <div><a href="#nowhere" order-status="waitConfirm">待确认</a></div>
    <div><a href="#nowhere" order-status="waitComment">待评价</a></div>
</section>

<main class="order-list">
    <table class="head-table">
        <thead>
        <th >宝贝</th>
        <th width="100px">单价</th>
        <th width="100px">数量</th>
        <th width="150px">实付款</th>
        <th width="120px">交易操作</th>
        </thead>
    </table>
    <c:forEach items="${orders}" var="o" varStatus="vs">
    <table class="line-table" order-status="${o.status}" oid="${o.id}">
        <tr class="item-head">
            <td colspan="2" class="time-and-order">
                <b>${o.createDate}</b>
                <span>订单号: ${o.orderCode}</span>
            </td>
            <td >
                <span class="seller"><img src="img/tmall-small.png">${website_name}</span>
            </td>
            <td colspan="2">
                <span class="wangwang"></span>
            </td>
            <td class="delete">
                <c:if test="${o.status=='finish'|| o.status == 'waitPay'}">
                <a href="#nowhere" class="delete-button" oid="${o.id}">
                    <span class="glyphicon glyphicon-trash"></span>
                </a>
                </c:if>
            </td>
        </tr>
        <c:forEach items="${o.orderItems}" var="oi" varStatus="vs2">
        <tr class="item-body">
            <td width="100px">
                <img src="${productImgDir}${oi.product.image.path}" class="cart-item-jpg">
            </td>
            <td class="item-name">
                <a class="cart-item-title" href="product?id=${oi.product.id}">${oi.product.name}</a>
                <div class="cart-item-title-bottom">
                    <img title="保障卡" src="img/baozhang.png">
                </div>
            </td>
            <td width="100px" class="num-center">
                <span class="cart-item-old-price">￥${oi.product.originalPrice}</span>
                <span class="cart-item-now-price">￥${oi.product.nowPrice}</span>
            </td>
            <td width="100px" class="num-center border-left">
                <span class="order-item-num">${oi.number}</span>
            </td>
            <c:if test="${vs2.count==1}">
            <td class="price-td" width="150px" rowspan="${o.totalNumber}">
                <span class="order-item-sum">￥${o.sum}</span>
                <span class="freight">(含运费：￥0.00)</span>
            </td>
            </c:if>
            <c:if test="${vs2.count==1 && o.status!='waitComment' }">
            <td width="120px" rowspan="${o.totalNumber}">

                <c:if test="${o.status=='waitConfirm' }">
                    <a href="confirmPay?oid=${o.id}" class="order-button blue">确认收货</a>
                </c:if>
                <c:if test="${o.status=='waitPay' }">
                    <a href="pay?oid=${o.id}" class="order-button blue">付款</a>
                </c:if>

                <c:if test="${o.status=='waitDeliver' }">
                    <a href="#nowhere" class="order-button white">待发货</a>
                    <a href="deliver?oid=${o.id}" class="order-button blue">自己发货</a>
                </c:if>
                <c:if test="${o.status=='finish' }">
                    <a href="#nowhere" class="order-button white">完成订单</a>
                </c:if>
            </td>
            </c:if>


            <c:if test="${o.status=='waitComment' && (empty oi.comment)}">
                <td width="120px" >
                    <a href="comment?oiid=${oi.id}" class="order-button white">评价</a>
                </td>
            </c:if>
        </tr>
        </c:forEach>
    </table>
    </c:forEach>
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
