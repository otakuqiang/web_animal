<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="gotop">

	<c:if test="${isLogin ==1 }">
		<a href="usercenter">
			<dl>
				<dt>
					<img src="img/gt3.png" />
				</dt>
				<dd>
					个人<br />中心
				</dd>
			</dl>
		</a>
	</c:if>
	<a href="#" class="toptop" style="display: none;">
		<dl>
			<dt>
				<img src="img/gt4.png" />
			</dt>
			<dd>
				返回<br />顶部
			</dd>
		</dl>
	</a>
	<p>400-400-400</p>
</div>
<!--footer-->
<div class="footer">
	<div class="top">
		<div class="wrapper"></div>
	</div>
	<p class="dibu">
		动物科普网&nbsp;&copy;2022-2024&nbsp;&nbsp; Copyright：Otaku<br />
		本网站所列数据，除特殊说明，所有数据均出自合法途径
	</p>
</div>