<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta charset="utf-8" />
<title>个人信息</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/mygxin.css" />
</head>
<body>
	<%@ include file="header.jsp"%>
	<!------------------------------idea------------------------------>
	<div class="address mt" id="add">
		<div class="wrapper clearfix">
			<a href="indexselect" class="fl">首页</a><span>/</span><a
				href="usercenter" class="on">个人中心</a>
		</div>
	</div>
	<!------------------------------Bott------------------------------>
	<div class="Bott">
		<div class="wrapper clearfix">

			<%@ include file="myheader.jsp"%>

			<div class="you fl">
				<div class="tx clearfix">
					<div class="fl clearfix">
						<a href="#" class="fl"><img src="img/tx.png" /></a>
						<p class="fl">
							<span>${user.user_name }</span><a href="mygrxx.html">修改个人信息></a>
						</p>
					</div>
					<div class="fr">绑定手机号：${user.user_mobile }</div>
				</div>
				<div class="bott">
					<div class="clearfix">
						<p class="fl">
							<span>用户所有订单：<strong>${allorder }</strong></span><a
								href="showorder?showflag=1">查看所有订单></a>
						</p>
					</div>
					<div class="clearfix">
						<p class="fl">
							<span>待收货的订单：<strong>${temporder }</strong></span><a
								href="showorder?showflag=2">查看待收货订单></a>
						</p>
					</div>
					<div class="clearfix">
						<p class="fl">
							<span>已完成的订单：<strong>${resorder }</strong></span><a
								href="showorder?showflag=3">查看已完成订单></a>
						</p>
					</div>
					<div class="clearfix">
						<p class="fl">
							<span>用户已收藏：<strong>${userlove }</strong></span><a
								href="showlove?showflag=2">查看收藏的动物></a><a href="showlove?showflag=3">查看收藏的纪念品></a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>

	<script src="js/jquery-1.12.4.min.js" type="text/javascript"
		charset="utf-8"></script>
	<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>