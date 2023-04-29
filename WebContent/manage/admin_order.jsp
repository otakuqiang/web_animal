<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="admin_menu.jsp"%>
<title>用户菜单</title>
<!--/sidebar-->
<div class="main-wrap">
	<div class="crumb-wrap">
		<div class="crumb-list">
			<i class="icon-font"></i><a href="admin_index.jsp">首页</a><span
				class="crumb-step">&gt;</span><span class="crumb-name">订单管理</span>
		</div>
	</div>

	<div class="result-wrap">
		<form action="/web_animal/manage/admin_dokeepsakedel" id="myform"
			method="post">
			<div class="result-content">
				<table class="result-tab" width="100%">
					<tr>
						<th>订单ID</th>
						<th>用户ID</th>
						<th>纪念品ID</th>
						<th>用户名</th>
						<th>纪念品图片</th>
						<th>用户地址</th>
						<th>支付方式</th>
						<th>订单状态</th>
						<th>操作</th>

					</tr>

					<c:forEach var="o" items="${list }">
						<tr>
							<td>${o.order_id}</td>
							<td>${o.order_u_id}</td>
							<td>${o.order_k_id}</td>
							<td>${o.order_u_name}</td>
							<td><img src="../images/keepsake/${o.order_k_photo}"
								width="80" height="80"></td>
							<td>${o.order_u_address }</td>
							<c:if test="${o.order_method.equals('T')}">
								<td>余额支付</td>
							</c:if>
							<c:if test="${o.order_method.equals('F')}">
								<td>积分支付</td>
							</c:if>
							<c:if test="${o.order_status==1}">
								<td>未完成</td>
								<td><a
									href="/web_animal/manage/admin_doorserview?id=${o.order_id }">查看</a>
									&nbsp;&nbsp;<a
									href="/web_animal/manage/admin_doorserupdate?id=${o.order_id }">完成</a></td>
							</c:if>
							<c:if test="${o.order_status==2}">
								<td>已完成</td>
								<td><a
									href="/web_animal/manage/admin_doorserview?id=${o.order_id }">查看</a></td>
							</c:if>
						</tr>

					</c:forEach>



					<script>
						function Delete(mess, url) {
							if (confirm(mess)) {
								location.href = url;
							}
						}
					</script>
				</table>
		</form>
	</div>
</div>
<!--/main-->
</div>
</body>
</html>
>
