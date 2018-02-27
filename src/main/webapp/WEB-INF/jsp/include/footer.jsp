<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>
<script>
    var msg = "${msg}";
    if(msg !== ""){
        alert(msg);
    }
    $(function () {
        $("#refer").val(window.location.href ===""?"/":window.location.href);
        $("#form").submit(function () {
            if($("#password").val() == "" || $("#name").val() == ""){
                alert("用户名或密码为空");
                return false;
            }
            return true;
        });
    });
</script>
<div class="modal" tabindex="-1" role="dialog" id="loginModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <section class="login-modal">
                <div class="login-content">
                    <form method="post" action="loginIn" id="form">
                        <div class="login-frame">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <div class="login-tip">密码登录</div>
                            <div class="login-input">
                    <span class="login-input-icon">
                                <span class=" glyphicon glyphicon-user"></span>
                            </span>
                                <input type="text" placeholder="手机/会员名/邮箱" name="name" id="name" autofocus>
                            </div>
                            <div class="login-input">
                    <span class="login-input-icon ">
                                <span class=" glyphicon glyphicon-lock"></span>
                            </span>
                                <input type="password" placeholder="密码" name="password" id="password">
                                <input type="hidden" name="refer" id="refer" value="/">
                            </div>
                            <div class="login-button">
                                <button type="submit" class="login-button">登 录</button>
                            </div>
                            <div class="login-bottom">
                                <a href="#nowhere">忘记登录密码</a>
                                <a class="" href="register">免费注册</a>
                            </div>

                        </div>
                    </form>
                </div>
            </section>
        </div>
    </div>
</div>
<footer class="footer-top clear">
    <div class="footer-content">
        <div class="footer-ensure">
            <a href="#nowhere1"></a>
            <a href="#nowhere2"></a>
            <a href="#nowhere3"></a>
            <a href="#nowhere4"></a>
        </div>

        <div class="footer-desc" id="footer-desc">
            <div class="desc-column">
                <span class="desc-column-title">购物指南</span>
                <a href="#nowhere">免费注册</a>
                <a href="#nowhere">开通支付宝</a>
                <a href="#nowhere">支付宝充值</a>
            </div>
            <div class="desc-column">
                <span class="desc-column-title">本站保障</span>
                <a href="#nowhere">发票保障</a>
                <a href="#nowhere">售后规则</a>
                <a href="#nowhere">缺货赔付</a>
            </div>
            <div class="desc-column">
                <span class="desc-column-title">支付方式</span>
                <a href="#nowhere">快捷支付</a>
                <a href="#nowhere">信用卡</a>
                <a href="#nowhere">蚂蚁花呗</a>
                <a href="#nowhere">货到付款</a>
            </div>
            <div class="desc-column">
                <span class="desc-column-title">商家服务</span>
                <a href="#nowhere">商家入驻</a>
                <a href="#nowhere">商家中心</a>
                <a href="#nowhere">本站智库</a>
                <a href="#nowhere">本站规则</a>
                <a href="#nowhere">物流服务</a>
                <a href="#nowhere">喵言喵语</a>
                <a href="#nowhere">运营服务</a>
            </div>
            <div class="desc-column">
                <span class="desc-column-title">手机版</span>
                <a href="#nowhere"><img src="img/shouji.png"></a>
            </div>
        </div>
    </div>
</footer>

<footer class="footer-bottom">

    <div class="foot-image"></div>
    <div class="foot-content">
        <div class="copyright" id="copyright">
            <div class="white-link">
                <a href="#nowhere">关于本站</a>
                <a href="#nowhere">帮助中心</a>
                <a href="#nowhere">开放平台</a>
                <a href="#nowhere"> 诚聘英才</a>
                <a href="#nowhere">联系我们</a>
                <a href="#nowhere">网站合作</a>
                <a href="#nowhere">法律声明</a>
                <a href="#nowhere">知识产权</a>
                <a href="#nowhere">廉正举报 </a>
            </div>
            <div class="white-link">
                <a href="#nowhere"> 阿里巴巴集团</a><span class="slash">|</span>
                <a href="#nowhere"> 淘宝网</a><span class="slash">|</span>
                <a href="#nowhere">${website_name} </a><span class="slash">|</span>
                <a href="#nowhere"> 聚划算</a><span class="slash">|</span>
                <a href="#nowhere">全球速卖通</a><span class="slash">|</span>
                <a href="#nowhere">阿里巴巴国际交易市场</a><span class="slash">|</span>
                <a href="#nowhere">1688</a><span class="slash">|</span>
                <a href="#nowhere">阿里妈妈</a><span class="slash">|</span>
                <a href="#nowhere"> 阿里旅行·去啊 </a><span class="slash">|</span>
                <a href="#nowhere"> 阿里云计算 </a><span class="slash">|</span>
                <a href="#nowhere"> 友盟 </a><span class="slash">|</span>
                <a href="#nowhere"> 虾米 </a><span class="slash">|</span>
                <a href="#nowhere"> 天天动听 </a><span class="slash">|</span>
                <a href="#nowhere"> 来往 </a><span class="slash">|</span>
                <a href="#nowhere"> 钉钉 </a><span class="slash">|</span>
                <a href="#nowhere"> 支付宝 </a>
            </div>
            <div class="license">
                <span>增值电信业务经营许可证： <a href="#nowhere">浙B2-20110446</a></span>
                <span>网络文化经营许可证：<a href="#nowhere">浙网文[2015]0295-065号</a></span>
                <span><a href="#nowhere">12318举报 </a></span><br>
                <span>互联网药品信息服务资质证书编号：<a href="#nowhere">浙-（经营性）-2012-0005</a></span>
                <div class="copy-right-year">© 2003-2017 TMALL.COM 版权所有</div>

            </div>
        </div>
    </div>
</footer>

</body>
</html>