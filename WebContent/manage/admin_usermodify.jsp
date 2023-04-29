<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="admin_menu.jsp"%>
<title>后台管理</title>
<!--/sidebar-->
<div class="main-wrap">
	<div class="crumb-wrap">
		<div class="crumb-list">
			<i class="icon-font"></i> <a
				href="/web_animal/manage/admin_index.jsp">首页</a> <span
				class="crumb-step">&gt;</span> <a class="crumb-name"
				href="/web_animal/manage/admin_douserselect">用户管理</a> <span
				class="crumb-step">&gt;</span> <span>修改用户</span>
		</div>
	</div>
	<div class="result-wrap">
		<div class="result-content">
			<form action="/web_animal/manage/admin_douserupdate" method="post"
				id="myform" name="myform">

				<input type="hidden" name="user_status" value="${user.user_status }">
				<input type="hidden" name="user_id" value="${user.user_id }">
				<input type="hidden" name="cpage" value="${cpage }">
				<table class="insert-tab" width="100%">
					<tbody>
						<tr>
							<th><i class="require-red">*</i>用户名：</th>
							<td><input class="common-text required" id="title"
								name="user_id" size="50" value="${user.user_id }" type="text">
							</td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>用户姓名：</th>
							<td><input class="common-text required" id="title"
								name="user_name" size="50" value="${user.user_name }"
								type="text"></td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>登录密码：</th>
							<td><input class="common-text required" id="title"
								name="user_password" size="50" value="${user.user_password}"
								type="password"></td>
						</tr>

						<tr>
							<th>性别：</th>
							<td><input type="radio" name="user_sex" value="T"
								${user.user_sex=='T'?"checked":"" }>男 <input
								type="radio" name="user_sex" value="F"
								${user.user_sex=='F'?"checked":"" }>女</td>
						<tr>
							<th><i class="require-red">*</i>手机号码：</th>
							<td><input class="common-text required" id="title"
								name="user_mobile" size="50" value="${user.user_mobile }"
								type="text"></td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>用户地址：</th>
							<td><input class="common-text required" id="title"
								name="user_address" size="50" value="${user.user_address }"
								type="text"></td>
						</tr>
						<tr>
							<th></th>
							<td><input class="btn btn-primary btn6 mr10" value="提交"
								type="submit"> <input class="btn btn6"
								onClick="history.go(-1)" value="返回" type="button"></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>

</div>
<!--/main-->
</div>
</body>
</html>