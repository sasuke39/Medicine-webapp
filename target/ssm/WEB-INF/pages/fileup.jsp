<%--
  Created by IntelliJ IDEA.
  User: 12556
  Date: 2020/05/09
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">
    <title>file upload</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>

<button type="button" class="layui-btn" id="image">
    <i class="layui-icon">&#xe67c;</i>上传图片
</button>


<form action="${pageContext.request.contextPath}/file/testUploadimg" method="post" enctype="multipart/form-data">
    <input type="file" name="meFile" /><p>
    <input type="submit" value="提交" /><p>
    <input type="reset" value="清空" /><p>
</form>

<script>
    layui.use('upload', function(){
        var upload = layui.upload;

        //执行实例
        var uploadInst = upload.render({
            elem: '#image' //绑定元素
            ,url: '${pageContext.request.contextPath}/file/testUploadimg' //上传接口
            ,done: function(res){
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
</script>
</body>
</html>
