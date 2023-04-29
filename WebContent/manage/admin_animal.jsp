<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="admin_menu.jsp"%>
<title>用户菜单</title>
<!--/sidebar-->
<div class="main-wrap">
	<div class="crumb-wrap">
		<div class="crumb-list">
			<i class="icon-font"></i><a href="/web_animal/manage/admin_index.jsp">首页</a><span
				class="crumb-step">&gt;</span><span class="crumb-name">动物管理</span>
		</div>
	</div>

	<div class="result-wrap">
		<form action="/web_animal/manage/admin_doanimaldel" id="myform"
			method="post">
			<div class="result-title">
				<div class="result-list">
					<a href="/web_animal/manage/admin_toanimaladd"><i
						class="icon-font"></i>新增动物信息</a>
				</div>
			</div>
			<div class="result-content">
				<table class="result-tab" width="100%">
					<tr>
						<th>动物ID</th>
						<th>动物中文名称</th>
						<th>动物拉丁名称</th>
						<th>动物图片</th>
						<th>操作</th>

					</tr>

					<c:forEach var="a" items="${alist }">
						<tr>
							<td>${a.animal_id }</td>
							<td>${a.animal_name }</td>
							<td>${a.animal_latin }</td>
							<td><img src="../animal/${a.animal_photo}" width="50"
								height="50"></td>
							<td><a href="admin_toanimalupdate?id=${a.animal_id }">修改</a>

								<a
								href="javascript:Delete('你确定要删除动物【${a.animal_name}】吗？','/web_animal/manage/admin_doanimaldel?id=${a.animal_id}')">删除</a>
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
