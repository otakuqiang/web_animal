<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css"
	href="/web_animal/manage/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="/web_animal/manage/css/main.css" />
</head>
<body>
	<div class="topbar-wrap white">
		<div class="topbar-inner clearfix">
			<div class="topbar-logo-wrap clearfix">
				<ul class="navbar-list clearfix">
					<li><a class="on" href="/web_animal/manage/admin_index.jsp">首页</a></li>
					<li><a href="/web_animal/indexselect" target="_blank">网站首页</a></li>
				</ul>
			</div>
			<div class="top-info-wrap">
				<ul class="top-info-list clearfix">
					<li><a href="#">管理员:--${user.user_name } 欢迎登录</a></li>
					<li><a href="/web_animal/manage/adminLogout">退出</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container clearfix">
		<div class="sidebar-wrap">
			<div class="sidebar-title">
				<h1>菜单</h1>
			</div>
			<div class="sidebar-content">
				<ul class="sidebar-list">
					<li><a href="#"><i class="icon-font">&#xe003;</i>常用操作</a>
						<ul class="sub-menu">
							<li><a href="/web_animal/manage/admin_douserselect"><i
									class="icon-font">&#xe005;</i>用户管理</a></li>
							<li><a href="/web_animal/manage/admin_categoryselect"><i
									class="icon-font">&#xe005;</i>分类管理</a></li>
							<li><a href="/web_animal/manage/admin_animalselect"><i
									class="icon-font">&#xe006;</i>动物信息管理</a></li>

							<li><a href="/web_animal/manage/admin_scienceselect"><i
									class="icon-font">&#xe006;</i>科普信息管理</a></li>
							<li><a href="/web_animal/manage/admin_keepsakeselect"><i
									class="icon-font">&#xe006;</i>纪念品信息管理</a></li>
							<li><a href="/web_animal/manage/admin_orderselect"><i
									class="icon-font">&#xe004;</i>订单管理</a></li>

						</ul></li>

				</ul>
			</div>
		</div>
		<title>动物科普网后台管理</title>