<%--
  Created by IntelliJ IDEA.
  User: xen
  Date: 2017/12/3
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>
<!DOCTYPE html>
<html>
<head>
    <title>${title} - 商城后台</title>
    <meta charset="utf-8">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        function checkEmpty(form){
            var flag = true;
            $(form).find("input[type=text]").each(function () {
                var value = $(this).val();
                if(value.length===0){
                    alert("表格不能为空");
                    $(this).focus();
                    flag = false;
                    return flag;
                }
            });
            return flag;
        }
        $(function(){
            $("#add-form").submit(function () {
                if(!checkEmpty(this)){
                    return false;
                }
            });
            $(".delete-button").click(function () {
                return !!confirm("确实删除？");
            });
            $(".detail-btn").click(function () {
               $(this).parents("tr").next().toggle();
            });
        });
    </script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

