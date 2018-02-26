<%--
  Created by IntelliJ IDEA.
  User: xen
  Date: 2017/12/9
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<main class="register">

    <script>
        var msg = "${msg}";
        if(msg !== ""){
            alert(msg);
        }
        $(function () {
            $("#refer").val(document.referrer);
           $("#form").submit(function () {
               if($("#repeatpassword").val()!=$("#password").val()){
                   alert("两次输入的密码不一致");
                   return false;
               }
               if($("#password").val() == "" || $("#name").val() == ""){
                   alert("用户名或密码为空");
                   return false;
               }
               return true;
           });
        });
    </script>


    <form action="registerAdd" method="post" id="form">
    <table class="register-table">
        <tbody>
        <tr>
            <td colspan="2" class="register-tip">设置会员名</td>
        </tr>
        <tr>
            <td class="left-col">登录名</td>
            <td class="right-col"><input placeholder="会员名一旦设置成功，无法修改" name="name" id="name"></td>
        </tr>
        <tr>
            <td colspan="2" class="register-tip">设置密码</td>
        </tr>
        <tr>
            <td  class="left-col">登陆密码</td>
            <td class="right-col"><input type="password" placeholder="设置你的登陆密码" name="password" id="password"></td>
        </tr>
        <tr>
            <td  class="left-col">密码确认</td>
            <td class="right-col"><input type="password" placeholder="请再次输入你的密码" id="repeatpassword"> </td>
        </tr>
        <tr>

            <td colspan="2" class="button-td">
                <input type="hidden" name="refer" id="refer">
                <button type="submit">提 交</button>
            </td>
        </tr>
        </tbody>
    </table>
    </form>
</main>