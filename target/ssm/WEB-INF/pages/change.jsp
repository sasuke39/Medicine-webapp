<%--
  Created by IntelliJ IDEA.
  User: 12556
  Date: 2020/03/19
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>

    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
<ins class="adsbygoogle" style="display:inline-block;width:970px;height:10px" data-ad-client="ca-pub-6111334333458862" data-ad-slot="3820120620"></ins>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>更改信息</legend>
</fieldset>
<%--lay-filter="example"--%>
<form class="layui-form" action="updateUserById"  method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">ID&nbsp;&nbsp;<i class="layui-icon layui-icon-key" style="font-size: 30px; color: #92B8B1;"></i></label>
        <div class="layui-input-inline">
            <input  name="id" type="text"  id="set"    readonly="readonly" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">用户名&nbsp;&nbsp;<i class="layui-icon layui-icon-username" style="font-size: 30px; color: #92B8B1;"></i></label>
        <div class="layui-input-inline">
            <input type="text" name="username"  lay-verify="username" autocomplete="off" placeholder="请输入标题" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">密码&nbsp;&nbsp;<i class="layui-icon layui-icon-key" style="font-size: 30px; color: #92B8B1;"></i></label>
        <div class="layui-input-inline">
            <input type="password" name="password" placeholder="请输入密码" lay-verify="password" autocomplete="off" class="layui-input">
        </div>
    </div>

    <label class="layui-form-label">城市&nbsp;&nbsp;<i class="layui-icon layui-icon-home" style="font-size: 30px; color: #92B8B1;"></i></label>
    <div class="layui-input-inline">
        <select name="city" lay-verify="required">
            <option value="">请选择</option>
            <option name="北京">北京</option>
            <option name="上海">上海</option>
            <option name="广州">广州</option>
            <option name="深圳">深圳</option>
            <option name="杭州">杭州</option>
        </select>
    </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">单选框</label>
        <div class="layui-input-block">
            <input type="radio" name="sex" value="男" title="男" checked="">
            <input type="radio" name="sex" value="女" title="女">
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" class="layui-btn" lay-submit lay-filter="forDemo">立即提交</button>
        </div>
    </div>
</form>
<script>





    layui.use('form', function(){
        var form = layui.form;
        $("#set").val(${param.id});
        form.render();//显示选择框
        form.verify({
            username: function(value, item){ //value：表单的值、item：表单的DOM对象
                if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
                    return '用户名不能有特殊字符';
                }
                if(/(^\_)|(\__)|(\_+$)/.test(value)){
                    return '用户名首尾不能出现下划线\'_\'';
                }
                if(/^\d+\d+\d$/.test(value)){
                    return '用户名不能全为数字';
                }
            }

            //我们既支持上述函数式的方式，也支持下述数组的形式
            //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
            ,password: [
                /^[\S]{6,12}$/
                ,'密码必须6到12位，且不能出现空格'
            ]
        });

    });





</script>


</body>
</html>
