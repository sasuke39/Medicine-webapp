
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>注册</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
<ins class="adsbygoogle" style="display:inline-block;width:970px;height:10px" data-ad-client="ca-pub-6111334333458862" data-ad-slot="3820120620"></ins>


<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>新建用户</legend>
</fieldset>
<%--save_user--%>
    <form class="layui-form" action="creatUser" method="post" >
        <div class="layui-form-item">
            <label class="layui-form-label">用户名&nbsp;&nbsp;<i class="layui-icon layui-icon-username" style="font-size: 30px; color: #92B8B1;"></i></label>
            <div class="layui-input-inline">
                <input type="text" name="username"   lay-verify="username" placeholder="请输入用户名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码&nbsp;&nbsp;<i class="layui-icon layui-icon-key" style="font-size: 30px; color: #92B8B1;"></i></label>
            <div class="layui-input-inline">
                <input type="password" name="password"  lay-verify="password" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">不得少于8位,不得使用空格</div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">城市&nbsp;&nbsp;<i class="layui-icon layui-icon-home" style="font-size: 30px; color: #92B8B1;"></i></label>
            <div class="layui-input-inline" >
                <select name="city"  lay-verify="required">
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
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="radio" name="sex" value="男" title="男"checked>
                <input type="radio" name="sex" value="女" title="女" >
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">确定</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>

<script>
    layui.use('form', function(){
        var form = layui.form;
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
                /^[\S]{6,20}$/
                ,'密码必须6到20位，且不能出现空格'
            ]
        });

    });

</script>

</body>
</html>
