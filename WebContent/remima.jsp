<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta charset="utf-8" />
<title>个人信息</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/mygrxx.css" />
<link rel="stylesheet" type="text/css" href="css/mygxin.css" />

</head>
<body>
	<%@ include file="header.jsp"%><!------------------------------idea------------------------------>
	<div class="address mt">
		<div class="wrapper clearfix">
			<a href="indexselect" class="fl">首页</a><span>/</span><a
				href="#" class="on">修改密码</a>
		</div>
	</div>
	<!------------------------------Bott------------------------------>
	<div class="Bott">
		<div class="wrapper clearfix">
			
			<%@ include file="myheader.jsp"%>
			<div class="you fl">
				<h2>修改密码</h2>
				<form action="#" method="get" class="remima">
					<p>
						<span>选择验证身份方式：</span><input type="checkbox" />密码验证 <input
							type="checkbox" />邮箱验证
					</p>
					<p>
						<span>原密码：</span><input type="text" />
					</p>
					<p class="op">输入原密码</p>
					<p>
						<span>新密码：</span><input type="text" />
					</p>
					<p class="op">6-16 个字符，需使用字母、数字或符号组合，不能使用纯数字、纯字母、纯符号</p>
					<p>
						<span>重复新密码：</span><input type="text" />
					</p>
					<p class="op">请再次输入密码</p>
					<p>
						<span>验证码：</span><input type="text" /><img src="img/temp/code.jpg"
							alt="" />
					</p>
					<p class="op">按右图输入验证码，不区分大小写</p>
					<input type="submit" value="提交" />
				</form>
			</div>
		</div>
	</div>
	<!--返回顶部-->
	<%@ include file="footer.jsp"%>html>