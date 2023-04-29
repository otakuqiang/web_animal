<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="js/jquery-1.12.4.min.js" type="text/javascript"
	charset="utf-8"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta charset="utf-8" />
<title>购物车界面</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/proList.css" />
<style type="text/css">
.num img {
	width: 30%;
}
</style>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="cart">
		<!-----------------site------------------->
		<div class="site">
			<p class=" wrapper clearfix">
				<span class="fl">购物车</span><a href="/web_animal/selectkeepsakelist"
					class="fr">继续购物&gt;</a>
			</p>
		</div>
		<!-----------------table------------------->
		<div class="table wrapper">
			<div class="tr"  style="width:95%">
				<div>商品</div>
				<div>单价</div>
				<div>数量</div>
				<div>小计</div>
				<div>操作</div>
			</div>
			<c:forEach var="rs" items="${requestScope.cartlist }">
				<div class="th">

					<div class="pro clearfix">
						<label class="fl"> <input name="ck" type="checkbox"
							value="${rs.cart_id }" /> <span></span>
						</label><a class="fl" href="selectkeepsakeview?id=${rs.cart_k_id }">
							<dl class="clearfix">
								<dt class="fl">
									<img width="120" height="120"
										src="images/keepsake/${rs.cart_k_photo }">
								</dt>
								<dd class="fl">
									<p>${rs.cart_k_name }</p>
								</dd>
							</dl>
						</a>
					</div>
					<div class="price">￥${rs.cart_k_price }</div>
					<div class="number">
						<p class="num clearfix">
							<img class="fl sub" src="img/temp/sub.jpg"> <span
								datasrc="${rs.cart_id }" class="fl"> ${rs.cart_quantity }</span>
							<img class="fl add" src="img/temp/add.jpg">
						</p>
					</div>
					<div class="price sAll">￥${rs.cart_k_price * rs.cart_quantity }</div>
					<div class="price">
						<a class="del" datasrc="${rs.cart_id }" href="#2">删除</a>
					</div>
				</div>
			</c:forEach>


			<div class="goOn">
				空空如也~<a href="/web_animal/selectkeepsakelist">去逛逛</a>
			</div>
			<div class="tr clearfix">
				<label class="fl"> <input class="checkAll" type="checkbox" /><span></span></label>
				<p class="fl">
					<a href="#">全选</a> <a href="#" class="del">删除</a>
				</p>

				<p class="fr">

					<span>共<small id="sl">0</small>件商品 余额<small id="sl"
						name="user_money">${user.user_money }</small> 积分<small id="sl"
						name="user_point">${user.user_point }</small>
					</span> <span>合计:&nbsp;<small id="all">￥0.00</small></span> <a
						href="javascript:toordermoney()" class="count">余额结算</a> <a
						href="javascript:toorderpoint()" class="count">积分结算</a>
				</p>
			</div>
		</div>
	</div>

	<script>
		function toordermoney() {
			var str = "";
			$("input[name='ck']:checked").each(function(index, item) {
				if ($("input[name='ck']:checked").length - 1 == index) {
					str += $(this).val();
				} else {
					str += $(this).val() + ","
				}

			});

			location.href = "orderadd?ordertype=T&eids=" + str;
		}
		function toorderpoint() {
			var str = "";
			$("input[name='ck']:checked").each(function(index, item) {
				if ($("input[name='ck']:checked").length - 1 == index) {
					str += $(this).val();
				} else {
					str += $(this).val() + ","
				}

			});

			location.href = "orderadd?ordertype=F&eids=" + str;
		}
	</script>




	<div class="mask"></div>
	<div class="tipDel">
		<p>确定要删除该商品吗？</p>
		<p class="clearfix">
			<a class="fl cer" href="#">确定</a><a class="fr cancel" href="#">取消</a>
		</p>
	</div>
	<%@ include file="footer.jsp"%>

	<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>