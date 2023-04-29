<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>详情页</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/proList.css" />
</head>
<body>
	<%@include file="header.jsp"%>
	</div>
	<!-----------------address------------------------------->
	<div class="address">
		<div class="wrapper clearfix">
			<a href="indexselect">首页</a><a href="selectkeepsakelist"></a><span>/</span>
			<a href="#" class="on">【纪念品】${k.keepsake_name }</a>

		</div>
		<!-----------------------Detail------------------------------>
		<div class="detCon">
			<div class="proDet wrapper">
				<div class="proCon clearfix">
					<div class="proImg fl">
						<img class="det" src="images/keepsake/${k.keepsake_photo }" />
						<div class="smallImg clearfix">
							<img src="images/keepsake/${k.keepsake_photo }"
								data-src="images/keepsake/${k.keepsake_photo }">
						</div>
					</div>
					<div class="fr intro">
						<div class="title">
							<h4>【动物科普网】${k.keepsake_name }</h4>

							<p>【${k.keepsake_introduce }】</p>
							<c:if test="${isLogin ==1 }">
								<c:if test="${flag==1 }">

									<a href="collectdelete?coll_id=${k.keepsake_id }&state=2"> <img
										src="img/hxin.png" /></a>
								</c:if>
								<c:if test="${flag==0 }">
									<a href="collectinsert?coll_id=${k.keepsake_id }&state=2"> <img
										src="img/xin.png" /></a>
								</c:if>
							</c:if>
							<br> <span>￥${k.keepsake_price }</span><br> <span>积分:${k.keepsake_point }</span><br>
						</div>
						<div class="proIntro">
							<p>颜色分类</p>
							<div class="smallImg clearfix categ">
								<p class="fl">
									<img src="images/keepsake/${k.keepsake_photo} " alt="分类图片"
										data-src="images/keepsake/${k.keepsake_photo}">
								</p>
							</div>
							<p>
								数量&nbsp;&nbsp;库存<span>${k.keepsake_stock }</span>件
							</p>
							<div class="num clearfix">
								<img class="fl sub" src="img/temp/sub.jpg"> <span
									id="count" class="fl" contentEditable="true">1</span><img
									class="fl add" src="img/temp/add.jpg">
							</div>
						</div>


						<div class="btns clearfix">
							<a href="javascript:shopAdd(${k.keepsake_id },'z')">
								<p class="buy fl">立即购买</p>
							</a> <a href="javascript:shopAdd(${k.keepsake_id },'s')">
								<p class="cart fr">加入购物车</p>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>

		<script>
			function shopAdd(id, url) {
				var count = document.getElementById("count").innerHTML;

				location.href = 'cartadd?id=' + id + '&count=' + count
						+ '&url=' + url;

			}
		</script>
		<%@ include file="footer.jsp"%>

		<script src="js/jquery-1.12.4.min.js" type="text/javascript"
			charset="utf-8"></script>
		<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript"
			charset="utf-8"></script>
		<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
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