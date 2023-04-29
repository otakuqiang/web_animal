<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="admin_menu.jsp"%>

<!--/sidebar-->
<div class="main-wrap">

	<div class="crumb-wrap">
		<div class="crumb-list">
			<i class="icon-font"></i><a href="admin_index.jsp">首页</a><span
				class="crumb-step">&gt;</span><a class="crumb-name"
				href="/web_animal/manage/admin_keepsakeselect">纪念品管理</a><span class="crumb-step">&gt;</span><span>新增纪念品</span>
		</div>
	</div>
	<div class="result-wrap">
		<div class="result-content">
			<form action="/web_animal/manage/admin_dokeepsakeadd" method="post" enctype="multipart/form-data" id="myform" name="myform">
				<table class="insert-tab" width="100%">
					<tbody>
						<tr>
							<th><i class="require-red">*</i>纪念品名称：</th>
							<td><input class="common-text required" id="title"
								name="keepsake_name" size="50" value="" type="text"></td>
						</tr>

						<tr>
							<th><i class="require-red"></i>纪念品图片：</th>
							<td><input class="common-text required" id="title"
								name="keepsake_photo" size="50" value="" type="file"></td>
						</tr>


						<tr>
							<th><i class="require-red">*</i>纪念品价格：</th>
							<td><input class="common-text required" id="title"
								name="keepsake_price" size="50" value="" type="text"></td>
						</tr>

						<tr height="150px">
							<th><i class="require-red"></i>纪念品介绍：</th>
							<td><textarea class="common-text required" id="title"
									style="height: 150px" name="keepsake_introduce" cols="60" rows="10"
									value="" type="text"></textarea></td>
						</tr>


						<tr>
							<th><i class="require-red">*</i>纪念品库存：</th>
							<td><input class="common-text required" id="title"
								name="keepsake_stock" size="50" value="" type="text"></td>
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