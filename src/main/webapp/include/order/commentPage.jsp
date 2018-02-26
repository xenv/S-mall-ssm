<%--
  Created by IntelliJ IDEA.
  User: xen
  Date: 2017/12/9
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<main class="comment">
    <div class="comment-left-jpg">
        <img src="${productImgDir}${orderItem.product.image.path}">
    </div>
    <div class="comment-right-detail">
        <div class="comment-detail-title">
            ${orderItem.product.name}
        </div>
        <table class="comment-detail">
            <tr>
                <td width="100px">价格</td>
                <td><span class="comment-price">${orderItem.product.nowPrice}</span>元</td>
            </tr>
            <tr>
                <td>配送</td>
                <td><span class="comment-deliver">卖家承担运费</span></td>
            </tr>
        </table>
        <div class="comment-time">
            <div class="comment-time-png"></div>
            <div class="comment-time-text">现在查看的是 您所购买商品的信息<br> 于${order.createDate}下单购买了此商品</div>
        </div>
    </div>
    <div class="comment-bar clear">
        <div class="comment-bar-text">
            累计评价<em>${orderItem.product.commentCount}</em>
        </div>
        <div class="comment-bar-bottom"></div>
    </div>
    <div class="comment-form">
        <form class="inner-form" action="addComment">
            <div class="comment-tip">
                其他买家，需要你的建议哦！
            </div>
            <table class="comment-table">

                <tr>
                    <td class="left-col">评价商品</td>
                    <td class="right-col"><textarea name="content"></textarea></td>
                    <input type="hidden" name="oiid" value="${orderItem.id}">
                </tr>
            </table>
            <div class="comment-bottom">
                <button type="submit" class="comment-button">提交评价</button>
            </div>
        </form>
    </div>
</main>
