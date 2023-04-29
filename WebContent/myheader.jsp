<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="zuo fl">
	<h3>
		<a href="#"><img src="img/tx.png"/></a>
		<p class="clearfix">
			<c:if test="${isLogin !=1 }">

				<a href="login.jsp" id="login">登录</a>
			</c:if>


			<c:if test="${isLogin ==1 }">
				<span class="fl">${user.user_name }</span>
				<span><a href="logout">退出登录</a>
			</c:if>
			</span>
		</p>
	</h3>
	<div>
		<h4>个人中心</h4>
		<ul>
			<li><a href="usercenter">我的中心</a></li>
		</ul>

		<h4>账户管理</h4>
		<ul>
			<li><a href="mygrxx.jsp">个人信息</a></li>
			<li><a href="remima.jsp">修改密码</a></li>
		</ul>
		<h4>我的交易</h4>
		<ul>
			<li><a href="showcart">我的购物车</a></li>
			<li><a href="showorder?showflag=1">我的订单</a></li>
			<li><a href="showlove?showflag=1">我的收藏</a></li>
		</ul>

	</div>
</div>