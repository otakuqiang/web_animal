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
				class="crumb-step">&gt;</span><span class="crumb-name">纪念品管理</span>
		</div>
	</div>

	<div class="result-wrap">
		<form action="/web_animal/manage/admin_dokeepsakedel" id="myform"
			method="post">
			<div class="result-title">
				<div class="result-list">
					<a href="/web_animal/manage/admin_tokeepsakeadd"><i
						class="icon-font"></i>新增纪念品</a>
				</div>
			</div>
			<div class="result-content">
				<table class="result-tab" width="60%">
					<tr>
						<th>ID</th>
						<th>纪念品名称</th>
						<th>纪念品图片</th>
						<th>纪念品价格</th>
						<th>纪念品积分</th>
						<th>操作</th>

					</tr>

					<c:forEach var="k" items="${klist }">
						<tr>
							<td>${k.keepsake_id }</td>
							<td>${k.keepsake_name }</td>
							<td><img src="../images/keepsake/${k.keepsake_photo}"
								width="80" height="80"></td>
							<td>${k.keepsake_price }</td>
							<td>${k.keepsake_point }</td>
							<td><a
								href="/web_animal/manage/admin_tokeepsakeupdate?id=${k.keepsake_id }">修改</a>

								<a
								href="javascript:Delete('你确定要删除纪念品【${k.keepsake_name}】吗？','/web_animal/manage/admin_doprodel?id=${k.keepsake_id}')">删除</a>
							</td>
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
