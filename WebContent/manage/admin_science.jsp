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
				class="crumb-step">&gt;</span><span class="crumb-name">科普信息管理</span>
		</div>
	</div>

	<div class="result-wrap">
		<form action="/web_animal/manage/admin_douserdel" id="myform"
			method="post">
			<div class="result-title">
				<div class="result-list">
					<a href="/web_animal/manage/admin_toscienceadd"><i
						class="icon-font"></i>新增科普信息</a>
				</div>
			</div>
			<div class="result-content">
				<table class="result-tab" width="80%">
					<tr>
						<th width="20%">科普信息ID</th>
						<th>信息标题</th>
						<th>操作</th>

					</tr>

					<c:forEach var="s" items="${slist }">
						<tr>
							<td>${s.science_id }</td>
							<td>${s.science_title }</td>
							<td><a href="admin_toscienceupdate?id=${s.science_id }">修改</a>

								<a
								href="javascript:Delete('你确定要删除科普【${s.science_title}】吗？','/web_animal/manage/admin_dosciencedel?id=${s.science_id}')">删除</a>
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
