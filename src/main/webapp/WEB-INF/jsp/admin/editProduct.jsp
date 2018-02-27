<%--
  Created by IntelliJ IDEA.
  User: xen
  Date: 2017/12/5
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="分类管理 - 产品管理 - 修改属性"/>
<%@include file="common/adminHeader.jsp" %>
<c:set var="light" value="1"/>
<%@include file="common/adminNavigator.jsp" %>


<div class="container" >
    <ol class="breadcrumb">
        <li><a href="../category/list">分类管理</a></li>
        <li><a href="../property/list?cid=${product.category.id}">${product.category.name}</a></li>
		<li>${product.name}</li>
    </ol>
</div>

<div class="container">
    <div class="row" >
        <div class="panel panel-default" style="width: 600px;margin:auto">
            <div class="panel-heading">编辑属性</div>
            <div class="panel-body">
                <form class="form-horizontal" method="get" id="add-form" action="update">
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">产品名字</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="name" name="name"
                                   placeholder="请输入属性名字" value="${product.name}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="subTitle" class="col-sm-2 control-label">产品小标题</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="subTitle" name="subTitle"
                                   placeholder="请输入产品小标题" value="${product.subTitle}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="originalPrice" class="col-sm-2 control-label">原价格</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="originalPrice" name="originalPrice"
                                   placeholder="请输入原价格" value="${product.originalPrice}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="nowPrice" class="col-sm-2 control-label">现价格</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="nowPrice" name="nowPrice"
                                   placeholder="请输入现价格" value="${product.nowPrice}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">库存</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="stock" name="stock"
                                   placeholder="请输入库存" value="${product.stock}">
                        </div>
                    </div>


                    <input name="cid" value="${product.category.id}" type="hidden">
                    <input name="id" value="${product.id}" type="hidden">
                    <div class="form-group">
                        <div style="text-align: center">
                            <button type="submit" class="btn btn-success btn-sm">保存</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

