<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta charset="utf-8" />
<title>动物科普网</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/myorder.css" />
<style type="text/css">
.aorder {
    zoom: 1;
    width: 60%;
</style>
</head>
<body>
	<%@ include file="header.jsp"%>
	<!------------------------------idea------------------------------>
	<div class="address mt">
		<div class="wrapper clearfix">
			<a href="#" class="fl">首页</a><span>/</span><a href=usercenter>个人中心</a><span>/</span><a
				href="showorder" class="on">我的订单</a>
		</div>
	</div>
	<!------------------------------Bott------------------------------>
	<div class="Bott">
		<div class="wrapper clearfix">

			<%@ include file="myheader.jsp"%>
			<div class="you fl">
				<div class="my clearfix">
					<h2 class="fl">我的订单</h2>
				</div>
				<c:if test="${showflag ==1 }">
					<div class="dlist clearfix">
						<ul class="fl clearfix" id="wa">
							<li class="on"><a href="showorder?showflag=1">全部订单</a></li>
							<li><a href="showorder?showflag=2">待收货</a></li>
							<li><a href="showorder?showflag=3">已完成</a></li>
						</ul>
					</div>
				</c:if>

				<c:if test="${showflag ==2 }">
					<div class="dlist clearfix">
						<ul class="fl clearfix" id="wa">
							<li><a href="showorder?showflag=1">全部订单</a></li>
							<li class="on"><a href="showorder?showflag=2">待收货</a></li>
							<li><a href="showorder?showflag=3">已完成</a></li>
						</ul>
					</div>
				</c:if>

				<c:if test="${showflag ==3 }">
					<div class="dlist clearfix">
						<ul class="fl clearfix" id="wa">
							<li><a href="showorder?showflag=1">全部订单</a></li>
							<li><a href="showorder?showflag=2">待收货</a></li>
							<li class="on"><a href="showorder?showflag=3">已完成</a></li>
						</ul>
					</div>
				</c:if>
				
				
				<c:forEach var="o" items="${olist }">
					<c:if test="${o.order_status==1}">
						<div class="dkuang clearfix deng aorder">
							<p class="one fl">待收货</p>
							<div class="clearfix"></div>
							<div class="word clearfix">
								<ul class="fl clearfix">
									<li>${user.user_name }</li>
									<li>订单号:${o.order_id }</li>
									<c:if test="${o.order_method.equals('T')}">
										<li>余额支付</li>
										<p class="fr">
											订单金额：<span>${o.order_money }</span>元
										</p>
									</c:if>
									<c:if test="${o.order_method.equals('F')}">
										<li>积分支付</li>
										<p class="fr">
											订单积分：<span>${o.order_point }</span>
										</p>

									</c:if>
								</ul>

							</div>
							<div class="shohou clearfix">
								<a href="#" class="fl"><img src="images/keepsake/${o.order_k_photo }" /></a>
								
								<p class="fr">
									<a href="#">确认收货</a><a href="orderxq.html">订单详情</a>
								</p>
							</div>
						</div>

					</c:if>
					<c:if test="${o.order_status==2}">
						<div class="dkuang aorder">
							<p class="one">已完成</p>
							<div class="word clearfix">
								<ul class="fl clearfix">
									<li>${user.user_name }</li>
									<li>订单号:${o.order_id }</li>
									<c:if test="${o.order_method.equals('T')}">
										<li>余额支付</li>
										<p class="fr">
											订单金额：<span>${o.order_money }</span>元
										</p>
									</c:if>
									<c:if test="${o.order_method.equals('F')}">
										<li>积分支付</li>
										<p class="fr">
											订单积分：<span>${o.order_point }</span>
										</p>

									</c:if>
								</ul>

							</div>
							<div class="shohou clearfix">
								<a href="#" class="fl"><img src="images/keepsake/${o.order_k_photo }" /></a>
							
								<p class="fr">
									<a href="#">已收货</a> <a href="orderxq.html">订单详情</a>
								</p>
							</div>
						</div>
					</c:if>
				</c:forEach>






			</div>
		</div>
	</div>
	<!--返回顶部-->
	<%@ include file="footer.jsp"%>

	<script src="js/jquery-1.12.4.min.js" type="text/javascript"
		charset="utf-8"></script>
	<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>