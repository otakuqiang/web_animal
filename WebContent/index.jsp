<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="header.jsp"%>

<!-------------------------banner--------------------------->
<div class="block_home_slider">
	<div id="home_slider" class="flexslider">
		<ul class="slides">
			<li>
				<div class="slide">
					<img src="img/banner1.jpg" />
				</div>
			</li>
		</ul>
	</div>
</div>
<div class="address">
		<div class="wrapper clearfix">
			<a href="#">热门动物前</a><span><a href="#" class="on">${top }</a></span>
		</div>
	</div>
	<!----------------proList------------------------->
	<div><ul class="proList wrapper clearfix">
		<c:forEach var="a" items="${toplist }">
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
<script src="js/jquery.flexslider-min.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript">
	$(function() {
		$('#home_slider').flexslider({
			animation : 'slide',
			controlNav : true,
			directionNav : true,
			animationLoop : true,
			slideshow : true,
			slideshowSpeed : 2000,
			useCSS : false
		});
	});
</script>
</body>
</html>