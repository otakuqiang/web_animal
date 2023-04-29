<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="admin_menu.jsp"%>
<title>后台管理</title>
<!--/sidebar-->
<div class="main-wrap">

	<div class="crumb-wrap">
		<div class="crumb-list">
			<i class="icon-font"></i><a href="admin_index.jsp">首页</a><span
				class="crumb-step">&gt;</span><a class="crumb-name"
				href="/web_animal/manage/admin_scienceselect">科普信息管理</a><span
				class="crumb-step">&gt;</span><span>新增科普信息</span>
		</div>
	</div>
	<div class="result-wrap">
		<div class="result-content">
			<form action="/web_animal/manage/admin_doscienceadd" method="post"
				enctype="multipart/form-data" id="myform" name="myform">
				<table class="insert-tab" width="100%">
					<tbody>

						<tr>
							<th><i class="require-red">*</i>科普标题：</th>
							<td><input class="common-text required" id="title"
								name="science_title" size="50" value="" type="text"></td>
						</tr>
						<tr>
							<th><i class="require-red"></i>科普图片：</th>
							<td><input class="common-text required" id="title"
								name="science_photo" size="50" value="" type="file"></td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>科普正文：</th>
							<td><textarea class=" required" id="title"
									name="science_text" cols="60" rows="10" value="" ></textarea>
							</td>
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
</div>
</body>
</html>