<%--
  Created by IntelliJ IDEA.
  User: 12556
  Date: 2020/04/08
  Time: 0:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>getJSON获取数据</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <style type="text/css">
        #divframe{ border:1px solid #999; width:500px; margin:0 auto;}
        .loadTitle{ background:#CCC; height:30px;}
    </style>
    <script type="text/javascript">
        $(function(){
            $("#btn").click(function(){
                $.getJSON("showall",function(data){
                    var $jsontip = $('#jsonTip');
                    var $zzz = $jsontip.children("#zzz");
                    var strHtml = "";//存储数据的变量
                    $zzz.empty();//清空内容
                    $.each(data,function(infoIndex,info){
                        strHtml += "姓名："+info["username"]+"<br>";
                        strHtml += "性别："+info["sex"]+"<br>";
                        strHtml += "邮箱："+info["password"]+"<br>";
                        strHtml += "<hr>"
                    })
                    $zzz.html(strHtml);//显示处理后的数据
                })
            })

        })

    </script>
</head>
<body>
<div id="divframe">
    <div class="loadTitle">
        <input type="button" value="获取数据" id="btn"/>
    </div>
    <div id="jsonTip">
        <div id="zzz"></div>
    </div>
</div>
</body>
</html>
