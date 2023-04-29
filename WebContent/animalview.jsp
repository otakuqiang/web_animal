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
.title img {
	width: 20px;
	height: 20px;
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
			<a href="indexselect">首页</a><span>/</span> <a
				href="selectanimallist?cid=${cate.cate_id }">${cate.cate_name }</a>
			<a href="#" class="on">【动物】${a.animal_name }</a>
		</div>
	</div>
	<!-----------------------Detail------------------------------>
	<div class="detCon">
		<div class="proDet wrapper">
			<div class="proCon clearfix">
				<div class="proImg fl">
					<img class="det" src="animal/${a.animal_photo }" />
				</div>
				<div class="fr intro">
					<div class="title">
						<span>【动物】${a.animal_name }</span> <br> <span>${a.animal_latin }</span>
						<br> <br> <br>

						<c:if test="${isLogin ==1 }">
							<c:if test="${flag==1 }">

								<a href="collectdelete?coll_id=${a.animal_id}&state=1"> <img
									src="img/hxin.png" /></a>
							</c:if>
							<c:if test="${flag==0 }">
								<a href="collectinsert?coll_id=${a.animal_id}&state=1"> <img
									src="img/xin.png" /></a>
							</c:if>
						</c:if>
						<br>
						<c:if test="${a.animal_audio !=NULL }">
							<audio controls="controls"> <source
								src="animal/${a.animal_audio }" type="audio/ogg" /> <source
								src="animal/${a.animal_audio }" type="audio/mpeg" /> </audio>
						</c:if>
					</div>

					<div class="proIntro">
						<span>动物信息详情</span><br> <br>
						<p>${a.animal_introduce }</p>
						<br> <br>

					</div>

				</div>
			</div>
		</div>
	</div>
	</div>
	<div class="introMsg wrapper clearfix">
		<div class="msgL fl">

			<div class="msgTit clearfix">
				<a class="on">动物其他信息</a>
			</div>
			<div class="per clearfix">
				<p>${a.animal_other }</p>

			</div>
			<div class="msgAll">
				<c:if test="${a.animal_video !=NULL }">
					<video width="1200" height="600" controls="controls"> <source
						src="animal/${a.animal_video}" type="video/ogg" /> <source
						src="animal/${a.animal_video}" type="video/mp4" /> </video>
				</c:if>
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