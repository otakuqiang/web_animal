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
	<%@ include file="header.jsp"%>

	<div class="address">
		<div class="wrapper clearfix">
			<a href="indexselect">首页</a><span>/</span> <a href="#">动物科普</a><span>/</span>
			<a href="#" class="on">${title }</a>
		</div>
	</div>
	<!----------------proList------------------------->
	<div><ul class="proList wrapper clearfix">
		<c:forEach var="a" items="${list }">
			<li><a href="selectanimalview?id=${a.animal_id }">
					<dl>
						<dt>
							<img src="animal/${a.animal_photo}">
						</dt>
						<dd>${a.animal_name }</dd>
						<dd>${a.animal_latin}</dd>
					</dl>
			</a></li>
		</c:forEach>
	</ul>
	</div>
	<%@ include file="footer.jsp"%>

	<script src="js/jquery-1.12.4.min.js" type="text/javascript"
		charset="utf-8"></script>
	<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>