<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<!------------------------------head------------------------------>
<%@ include file="header.jsp" %>

	<div class="banner">
		<a href="#"><img src="img/temp/banner1.jpg" /></a>
	</div>
	<!-----------------address------------------------------->
	<div class="address">
		<div class="wrapper clearfix">
			<a href="indexselect">首页</a><span>/</span>
			<a href="#">纪念品导购</a><span>/</span>
		</div>
	</div>
	<!----------------proList------------------------->
	<ul class="proList wrapper clearfix">
		<c:forEach var="k" items="${klist }">
			<li><a href="selectkeepsakeview?id=${k.keepsake_id }">
					<dl>
						<dt>
							<img src="images/keepsake/${k.keepsake_photo }">
						</dt>
						<dd>【动物科普网】${k.keepsake_name }</dd>
						<dd>￥${k.keepsake_price}</dd>
					</dl>
			</a></li>
		</c:forEach>
	</ul>
	<%@ include file="footer.jsp"%>

	<script src="js/jquery-1.12.4.min.js" type="text/javascript"
		charset="utf-8"></script>
	<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>