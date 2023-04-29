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
				href="/web_animal/manage/admin_animalselect">动物管理</a><span
				class="crumb-step">&gt;</span><span>新增动物</span>
		</div>
	</div>
	<div class="result-wrap">
		<div class="result-content">
			<form action="/web_animal/manage/admin_doanimaladd" method="post"
				enctype="multipart/form-data" id="myform" name="myform">
				<table class="insert-tab" width="100%">
					<tbody>
						<tr>
							<th><i class="require-red">*</i>动物名称：</th>
							<td><input class="common-text required" id="title"
								name="animal_name" size="50" value="" type="text"></td>
						</tr>
						<tr>
							<th><i class="require-red"></i>拉丁学名：</th>
							<td><input class="common-text required" id="title"
								name="animal_latin" size="50" value="" type="text"></td>
						</tr>
						<tr>
						</tr>
						<tr>
							<th><i class="require-red">*</i>动物分类：</th>
							<td><select class="common-text required"
								name="animal_parentID">
									<c:forEach var="f" items="${flist }">
										<!--  disabled="disabled"表示不可选择的父类 -->
										<option value="${f.cate_id }" disabled="disabled">|-${f.cate_name }
										</option>

										<c:forEach var="c" items="${clist }">
											<c:if test="${c.cate_parent_id == f.cate_id }">
												<option value="${f.cate_id }-${c.cate_id }">&nbsp;&nbsp;&nbsp;&nbsp;|-${c.cate_name }
												</option>
											</c:if>

										</c:forEach>
									</c:forEach>
							</select></td>
						</tr>

						<tr>
							<th><i class="require-red"></i>动物图片：</th>
							<td><input class="common-text required" id="title"
								name="animal_photo" size="50" value="" type="file"></td>
						</tr>
						<tr>
							<th><i class="require-red"></i>动物音频：</th>
							<td><input class="common-text required" id="title"
								name="animal_audio" size="50" value="" type="file"></td>
						</tr>

						<tr>
							<th><i class="require-red"></i>动物视频：</th>
							<td><input class="common-text required" id="title"
								name="animal_video" size="50" value="" type="file"></td>
						</tr>


						<tr height="150px">
							<th><i class="require-red"></i>动物介绍：</th>
							<td height="150px"><textarea class="common-text required"
									id="title" style="height: 150px" name="animal_introduce"
									cols="60" rows="10" value="" type="text"></textarea></td>
						</tr>

						<tr height="150px">
							<th><i class="require-red"></i>其他补充：</th>
							<td><textarea class="common-text required" id="title"
									style="height: 150px" name="animal_other" cols="60" rows="10"
									value="" type="text"></textarea></td>
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