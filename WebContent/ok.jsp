<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta charset="utf-8" />
<title></title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/proList.css" />
</head>
<body>
	<!----------------------------------------order------------------>
	<%@ include file="header.jsp"%>
	<div class="order mt cart">
		<p class="ok">
			支付成功！剩余<span>60</span>秒<a href="indexselect">自动跳转网站首页</a><br>
			<a href="#">点击跳转用户订单界面</a>
		</p>
	</div>

	<%@ include file="footer.jsp"%>

	<script src="js/jquery-1.12.4.min.js" type="text/javascript"
		charset="utf-8"></script>
	<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript"
		charset="utf-8"></script>
	<script type="text/javascript">
		jQuery(".bottom").slide({
			titCell : ".hd ul",
			mainCell : ".bd .likeList",
			autoPage : true,
			autoPlay : false,
			effect : "leftLoop",
			autoPlay : true,
			vis : 1
		});
	</script>
</body>
</html>