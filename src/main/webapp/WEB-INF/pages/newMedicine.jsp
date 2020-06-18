<%--
  Created by IntelliJ IDEA.
  User: 12556
  Date: 2020/05/09
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
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
    <legend>药品信息输入</legend>
</fieldset>

<form class="layui-form" action="${pageContext.request.contextPath}/Medicine/newMedicine" method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">药品名称</label>
        <div class="layui-input-inline">
            <input type="text" name="product_name" required  lay-verify="required" placeholder="请输入名称" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux">每张图片名字不一样</div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">标签价格</label>
        <div class="layui-input-inline">
            <input type="text" name="cover_price" required lay-verify="required" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux">￥XXX.XX(格式)</div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">药物分类</label>
        <div class="layui-input-inline" >
            <select name="type" lay-verify="required">
                <option value="">请选择一个分类</option>
                <option name="001">肠胃用药</option>
                <option name="002">呼吸系统</option>
                <option name="003">心脑血管</option>
                <option name="004">风湿骨科</option>
                <option name="005">抗肿瘤药</option>
                <option name="006">皮肤科药</option>
                <option name="007">五官科药</option>
                <option name="008">感冒用药</option>
                <option name="009">美容美肤</option>
                <option name="010">其他分类</option>
            </select>
        </div>
    </div>

<%--    <br>--%>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">详细信息</label>
        <div class="layui-input-block">
            <textarea name="details" placeholder="请输入信息" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                <button type="button" class="layui-btn" id="test1">上传图片</button>
            </div>
        </div>
    </div>
    <span  name="if_new_Med">${sessionScope.get("if_new_Med")}</span>
</form>



<script>

    layui.use(['form','upload'], function(){
        var form = layui.form;
        var upload = layui.upload;
        form.render();//显示选择框
        form.verify({
            med_name: function(value, item){ //value：表单的值、item：表单的DOM对象
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
        });

        var uploadInst = upload.render({
            elem: '#test1' //绑定元素
            ,url: '${pageContext.request.contextPath}/Medicine/testUploadimg' //上传接口

            ,done: function(res){
                // res.preview(function(index, file, result){
                //     $('#demo1').attr('src', result); //图片链接（base64）
                // });
                //上传完毕回调
                if(res.code !== 0){
                    return layer.msg('上传失败-------');
                }
                //上传成功
                if(res.code === 0){
                    return layer.msg('上传成功--------')
                }
            }
            ,error: function(){
                //请求异常回调
            },accept: 'image'
            ,method:'post'
            ,name:'image'
        });

    });


        //执行实例


</script>
</body>
</html>
