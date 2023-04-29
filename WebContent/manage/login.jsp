<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8"/>
    <title>后台管理登录界面</title>
	<link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>
<body>
<div class="admin_login_wrap">
    <h1>后台管理登录</h1>
    <div class="adming_login_border">
        <div class="admin_input">
            <form action="/web_animal/manage/adminlogin" method="post">
                <ul class="admin_items">
                    <li>
                        <label for="user">用户名：</label>
                        <input type="text" name="user_id" value="" id="user" size="30" class="admin_input_style" />
                    </li>
                    <li>
                        <label for="pwd">密码：</label>
                        <input type="password" name="user_password" value="" id="pwd" size="30" class="admin_input_style" />
                    </li>
                    <li>
                        <input type="submit" tabindex="3" value="提交" class="btn btn-primary" />
                    </li>
                </ul>
            </form>
        </div>
    </div>
    <p class="admin_copyright"><a tabindex="5" href="#" target="_blank">返回首页</a> &copy; Powered by 济宁学院<a href="#" target="_blank"> Otaku</a></p>
</div>
</body>
</html>