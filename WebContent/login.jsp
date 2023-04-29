<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>科普网登录界面</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>
<body><!-------------------login-------------------------->
<div class="login">
    <form action="login" method="post"><h1>
    <a href="indexselect">返回网站首页</a></h1><br>
       
        <p><input type="text" name="user_id" value="" placeholder="请输入用户名"></p>
        <p><input type="text" name="user_password" value="" placeholder="请输入密码"></p>
        <p><input type="submit" name="" value="登  录"></p>
        <p class="txt"><a class="" href="register.jsp">免费注册</a><a href="forget.html">忘记密码？</a></p></form>
</div>
</body>
</html>