<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script src=js/jquery-1.12.4.min.js></script>
    <script src="js/function.js"></script>
    
    <style>
    .reg P .error {
    display:inline-block;
    background-color:#ff;
    height:20px;
    line-heigth:25px;
    padding-left:5px;
    margin-left:0px;
    }
    
    </style>
</head>
<body><!-------------------reg-------------------------->
<div class="reg">
    <form action="register" method="post" onsubmit="return checkForm(this)"><h1>
    <a href="indexselect"></a></h1>
        <p><input type="text" name="user_id" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入用户名"><span class="error">用户名不能为空</span></p>
        <p><input type="text" name="user_name" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入用户姓名"><span></span></p>
        <p><input type="text" name="user_password" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入密码"><span></span></p>
        <p><input type="text" name="repassword" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入确认密码"><span></span></p>
        <p>
        <input style="width:20px; height:20px" type="radio" name="user_sex" value="T" checked="checked">男
        <input style="width:20px; height:20px" type="radio" name="user_sex" value="F">女
        </p>
        <p><input type="text" name="user_mobile" value="" placeholder="请输入电话号码"><span></span></p>
        <p><input type="text" name="user_address" value="" placeholder="请输入地址"><span></span></p>
        <p><input class="code" type="text" name="code" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入验证码">
        <img src="getcode" alt="看不清？换一张" onclick="change(this)"><span class="error"></span></p>
        <p><input type="submit" name="" value="注册"></p>
        <p>完成此注册，即表明您同意了我们的<a href="#">
            <使用条款和隐私策略>
        </a></p>
        <p class="txt"><a href="login.jsp"><span></span>已有账号登录</a></p>
        </form>
</div>
</body>
</html>
