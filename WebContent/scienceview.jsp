<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>详情页</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/proList.css" />
<style type="text/css">
.proIntro > p {
    height: 15px;
    line-height: 25px;
}
.proIntro .smallImg span {
    position: absolute;
    top: 55px;
    left: 0;
    padding: 5px;
}

.proIntro {
    width: 350px;
    padding: 20px 10px;
    margin: 35px 0;
}
</style>
</head>
<body>
	<!------------------------------head------------------------------>

	<%@include file="header.jsp"%>
	</div>
	<!-----------------address------------------------------->
	<div class="address">
		<div class="wrapper clearfix">
			<a href="indexselect">首页</a><span>/</span>
			<a href="#" class="on">【科普知识】</a>
		</div>
	</div>
	<!-----------------------Detail------------------------------>
	<div class="detCon">
		<div class="proDet wrapper">
			<div class="proCon clearfix">
				<div class="proImg fl">
					<img class="det" src="images/science/${s.science_photo}"/>
				</div>
				<div class="fr intro">
					<div class="title">
						<span>${s.science_title }</span>
					</div>

					<div class="proIntro">
						<h5>详情</h5>
						<p>&emsp;&emsp;${s.science_text }</p>
						
					</div>

				</div>
			</div>
		</div>
	</div>
	</div>
	</div>
<%@ include file="footer.jsp"%>

	<script src="js/jquery-1.12.4.min.js" type="text/javascript"
		charset="utf-8"></script>
	<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript"
		charset="utf-8"></script>
	<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>