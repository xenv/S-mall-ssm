<%--
  Created by IntelliJ IDEA.
  User: xen
  Date: 2017/12/3
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="分类管理"/>
<%@include file="common/adminHeader.jsp" %>
<c:set var="light" value="1"/>
<%@include file="common/adminNavigator.jsp" %>


<div class="container" >
    <ol class="breadcrumb">
        <li class="active">分类管理</li>
    </ol>
    <table class="table table-hover table-striped">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">推荐级</th>
            <th scope="col">图片</th>
            <th scope="col">分类名称</th>
            <th scope="col">属性管理</th>
            <th scope="col">产品管理</th>
            <th scope="col">编辑</th>
            <th scope="col">删除</th>
        </tr>
        </thead>
        <tbody>
        <jsp:useBean id="categories" scope="request" type="java.util.List"/>
        <c:forEach items="${categories}" var="c" varStatus="vs">
            <tr>
                <th scope="row">${c.id}</th>
                <td>${c.recommend}</td>
                <td><img src="../../../${categoryImgDir}${c.imgPath}" height="40px"></td>
                <td>${c.name}</td>
                <td><a href="../property/list?cid=${c.id}"><span class="glyphicon glyphicon-list-alt"></span></a></td>
                <td><a href="../product/list?cid=${c.id}"><span class="glyphicon glyphicon-shopping-cart"></span></a></td>
                <td><a href="edit?id=${c.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                <td><a href="delete?id=${c.id}" class="delete-button"><span class="glyphicon glyphicon-trash"></span></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>




<%@include file="common/adminPage.jsp" %>


<div class="container">
    <div class="row" >
        <div class="panel panel-default" style="width: 650px;margin:auto">
            <div class="panel-heading">新增分类</div>
            <div class="panel-body">
                <form class="form-horizontal" method="post" id="add-form" action="add" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">分类名字</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="name" name="name"
                                   placeholder="请输入分类名字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="file" class="col-sm-2 control-label">图片文件</label>
                        <div class="col-sm-10">
                            <input id="file" name="image" type="file" class="file" accept="image/*">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="recommend" class="col-sm-2 control-label">推荐优先级</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="recommend" name="recommend"
                                   placeholder="默认为0不推荐，首页不显示产品大图。优先级越高排越前" value="0">
                        </div>
                    </div>

                    <div class="form-group">
                        <div style="text-align: center">
                            <button type="submit" class="btn btn-success btn-sm">新建分类</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<%@include file="common/adminFooter.jsp" %>
