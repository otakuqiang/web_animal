<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>动物科普网</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" type="text/css" href="css/proList.css" />
</head>
<body>
	<div class="head">
		<div class="wrapper clearfix">
			<div class="clearfix" id="top">
				<h1 class="fl">
					<a href="indexselect"><img src="img/logo.png" /></a>
				</h1>

				<div class="fr clearfix" id="top1">
					<p class="fl">
						<c:if test="${isLogin !=1 }">

							<a href="login.jsp" id="login">登录</a>
							<a href="register.jsp" id="reg">注册</a>
						</c:if>

						<c:if test="${isLogin ==1 }">

							<b>你好：</b>
							<a href="logout" id="login">${user.user_name }</a>
							<b>点击用户名退出</b>
						</c:if>

						<c:if test="${isAdminLogin == 1 }">
							<a href="/web_animal/manage/admin_index.jsp" id="login1">进入后台管理</a>
						</c:if>


					</p>

					
					<form action="/web_animal/searchanimal" method="post" class="fl">
						<!-- <input name="keywords" id=""
							type="text" placeholder="热门搜索：大熊猫" />
							<input type="submit" /> -->
							
							 <td><input class="common-text" placeholder="热门搜索：大熊猫" name="keywords" value="" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="" type="submit"></td>
							
					</form>
					<div class="btn fl clearfix">

						<a href="#" class="er1"> <img src="img/ewm.png" /></a>

						<c:if test="${isLogin ==1 }">
							<a href="usercenter"><img src="img/grzx.png" /></a>
							<a href="showcart"> <img src="img/gwc.png" /></a>
						</c:if>

						<p>
							<a href="#"><img src="img/smewm.png" /></a>
						</p>
					</div>
				</div>
			</div>
			<ul class="clearfix" id="bott">
				<li><a href="indexselect">首页</a></li>
				<c:forEach var="f" items="${flist }">

					<li><a href="selectanimallist?fid=${f.cate_id }">${f.cate_name }</a>
						<div class="sList2">
							<div class="clearfix">
								<c:forEach var="c" items="${clist }">
									<c:if test="${f.cate_id==c.cate_parent_id }">

										<a href="selectanimallist?cid=${c.cate_id}">${c.cate_name }</a>

									</c:if>
								</c:forEach>
							</div>
						</div></li>
				</c:forEach>

				<li><a href="/web_animal/selectkeepsakelist">纪念品</a></li>
				
				<li><a href="/web_animal/selectsciencelist">科普知识</a></li>
			</ul>
		</div>
	</div>