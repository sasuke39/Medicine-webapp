<%--
  Created by IntelliJ IDEA.
  User: 12556
  Date: 2020/03/17
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>登陆</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}layui//layui.js"></script>
</head>
<body>
<div class="divmain" style="position: absolute;top: 80px;left: 450px;">
    <h1 style="margin: 40px">药品用户后台管理系统</h1>
    <form class="layui-form" action="user/login" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名&nbsp;&nbsp;<i class="layui-icon layui-icon-username"
                                                              style="font-size: 30px; color: #92B8B1;"></i></label>
            <div class="layui-input-inline">
                <input type="text" name="username" required lay-verify="username" placeholder="请输入用户名"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码&nbsp;&nbsp;<i class="layui-icon layui-icon-key"
                                                             style="font-size: 30px; color: #92B8B1;"></i></label>
            <div class="layui-input-inline">
                <input type="password" name="password" required lay-verify="password" placeholder="请输入密码"
                       autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">不得少于8位,不得使用空格</div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">登陆</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
<%--    <span class="login_msg" style="color: #FD482C">${login_msg}</span>--%>
</div>

</body>
<script>
    layui.use('form', function(){
        var form = layui.form;
        form.render();//显示选择框
        form.verify({
            // username: function(value, item){ //value：表单的值、item：表单的DOM对象
            //     if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
            //         return '用户名不能有特殊字符';
            //     }
            //     if(/(^\_)|(\__)|(\_+$)/.test(value)){
            //         return '用户名首尾不能出现下划线\'_\'';
            //     }
            //     if(/^\d+\d+\d$/.test(value)){
            //         return '用户名不能全为数字';
            //     }
            // }

            //我们既支持上述函数式的方式，也支持下述数组的形式
            //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
            password: [
                /^[\S]{6,12}$/
                ,'密码必须6到12位，且不能出现空格'
            ]
        });

    });

</script>
</html>
