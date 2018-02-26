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

<c:set var="title" value="分类管理 - 产品管理"/>
<%@include file="common/adminHeader.jsp" %>
<c:set var="light" value="1"/>
<%@include file="common/adminNavigator.jsp" %>


<div class="container" >
    <ol class="breadcrumb">
        <li><a href="../category/list">所有分类</a></li>
        <li>${category.name}</li>
        <li>产品管理</li>
    </ol>
    <table class="table table-hover table-striped">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">图片</th>
            <th scope="col">产品名称</th>
            <th scope="col">产品小标题</th>
            <th scope="col">原价格</th>
            <th scope="col">现价格</th>
            <th scope="col">库存</th>
            <th scope="col">图片管理</th>
            <th scope="col">设置属性值</th>
            <th scope="col">编辑</th>
            <th scope="col">删除</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${products}" var="p" varStatus="vs">
            <tr>
                <th scope="row">${p.id}</th>
                <td><img src="../../../${productImgDir}${p.image.path}" height="30px"></td>
                <td>${p.name}</td>
                <td>${p.subTitle}</td>
                <td>${p.originalPrice}</td>
                <td>${p.nowPrice}</td>
                <td>${p.stock}</td>
                <td><a href="image/list?pid=${p.id}"><span class="glyphicon glyphicon-picture"></span></a></td>
                <td><a href="propertyValue/edit?pid=${p.id}"><span class="glyphicon glyphicon-th-list"></span></a></td>
                <td><a href="edit?id=${p.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                <td><a href="delete?id=${p.id}" class="delete-button"><span class="glyphicon glyphicon-trash"></span></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="common/adminPage.jsp" %>

<div class="container">
    <div class="row" >
        <div class="panel panel-default" style="width: 600px;margin:auto">
            <div class="panel-heading">新增属性</div>
            <div class="panel-body">
                <form class="form-horizontal" method="get" id="add-form" action="add">
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">产品名字</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="name" name="name"
                                   placeholder="请输入产品名字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="subTitle" class="col-sm-2 control-label">产品小标题</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="subTitle" name="subTitle"
                                   placeholder="请输入产品小标题">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="originalPrice" class="col-sm-2 control-label">原价格</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="originalPrice" name="originalPrice"
                                   placeholder="请输入原价格">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="nowPrice" class="col-sm-2 control-label">现价格</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="nowPrice" name="nowPrice"
                                   placeholder="请输入现价格">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">库存</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="stock" name="stock"
                                   placeholder="请输入库存">
                        </div>
                    </div>

                    <input name="cid" value="${category.id}" type="hidden">
                    <div class="form-group">
                        <div style="text-align: center">
                            <button type="submit" class="btn btn-success btn-sm">新建产品</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

