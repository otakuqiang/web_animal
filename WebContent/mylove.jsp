<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta charset="utf-8" />
<title>动物科普网</title>
<%@ include file="header.jsp"%>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/myorder.css" />
<style type="text/css">
.proList>li {
	position: relative;
	float: left;
	width: 200px;
	height: 200px margin-top: 5px;
	padding: 5px;
	text-align:center;
	border: 1px solid #fff;
}

.proList>li img {
	width: 200px;
	height: 200px;
}
</style>
</head>
<body>
	
	<!------------------------------idea------------------------------>
	<div class="address mt">
		<div class="wrapper clearfix">
			<a href="#" class="fl">首页</a><span>/</span><a href="usercenter">个人中心</a><span>/</span><a
				href="showlove?showflag=1" class="on">我的收藏</a>
		</div>
	</div>
	<!------------------------------Bott------------------------------>
	<div class="Bott">
		<div class="wrapper clearfix">

			<%@ include file="myheader.jsp"%>
			<div class="you fl">
				<div class="my clearfix">
					<h2 class="fl">我的收藏</h2>
				</div>
				<c:if test="${showflag ==1 }">
					<div class="dlist clearfix">
						<ul class="fl clearfix" id="wa">
							<li class="on"><a href="showlove?showflag=1">全部收藏</a></li>
							<li><a href="showlove?showflag=2">动物</a></li>
							<li><a href="showlove?showflag=3">纪念品</a></li>
						</ul>
					</div>
				</c:if>

				<c:if test="${showflag ==2 }">
					<div class="dlist clearfix">
						<ul class="fl clearfix" id="wa">
							<li><a href="showlove?showflag=1">全部收藏</a></li>
							<li class="on"><a href="showlove?showflag=2">动物</a></li>
							<li><a href="showlove?showflag=3">纪念品</a></li>
						</ul>
					</div>
				</c:if>

				<c:if test="${showflag ==3 }">
					<div class="dlist clearfix">
						<ul class="fl clearfix" id="wa">
							<li><a href="showlove?showflag=1">全部收藏</a></li>
							<li><a href="showlove?showflag=2">动物</a></li>
							<li class="on"><a href="showlove?showflag=3">纪念品</a></li>
						</ul>
					</div>
				</c:if>


				<ul class="proList wrapper clearfix">
					<c:forEach var="k" items="${klist }">
						<li><a href="selectkeepsakeview?id=${k.keepsake_id }">
								<dl>
									<dt>
										<img src="images/keepsake/${k.keepsake_photo }">
									</dt>
									<dd>${k.keepsake_name }</dd>
								</dl>
						</a></li>
					</c:forEach>
				</ul>
				<ul class="proList wrapper clearfix">
					<c:forEach var="a" items="${alist }">
						<li><a href="selectanimalview?id=${a.animal_id }">
								<dl>
									<dt>
										<img src="animal/${a.animal_photo }">
									</dt>
									<dd>${a.animal_name }</dd>
								</dl>
						</a></li>
					</c:forEach>
				</ul>

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