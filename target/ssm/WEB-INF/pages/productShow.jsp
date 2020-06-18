<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>showdata</title>
    <meta charset="utf-8"/>
    <%--    ${pageContext.request.contextPath}--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <style type="text/css">
        .product-href {
            color: #0C0C0C;
            margin: 5px;
            font-size: 20px;
        }

        .product-span {
            font-size: 13px;
        }

        .product-img {
            height: 260px;
            width: 320px
        }

        .product-img img {
            height: 100%;
            width: 100%
        }

        .product-infor {
            padding: 10px;
        }

        .product-infor h3 {
            position: relative;
            left: 280px;
            color: red;
        }
    </style>
</head>

<body>
<div class="layui-nav" lay-filter="test">
    <ul class="layui-nav-title">
        <li class="layui-nav-item "><a href="${pageContext.request.contextPath}/user/show"> 用户管理</a></li>
        <li class="layui-nav-item "><a href="${pageContext.request.contextPath}/medUser/show">药品APP用户管理</a></li>
        <li class="layui-nav-item layui-this"><a href="">展示药物</a></li>
        <li class="layui-nav-item">
            <a href="${pageContext.request.contextPath}/user/logOff" >注销</a>
        </li>
        <li class="layui-nav-item" style="float:right;z-index: 9999;">
            <a href=""><img src="//t.cn/RCzsdCq" class="layui-nav-img">我</a>
            <dl class="layui-nav-child">
                <dd><a href="">修改信息</a></dd>
                <dd><a href="">安全管理</a></dd>
                <dd><a href="">退了</a></dd>
            </dl>
        </li>
    </ul>
</div>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>卡片面板</legend>
</fieldset>

<div >
    <div style="padding: 20px; background-color: #F2F2F2;">
        <div class="layui-row layui-col-space15" id="LAY_layedit_code">
            <%--        <div class="layui-col-md3">--%>
            <%--            <div class="layui-card">--%>
            <%--                <div class="layui-card-body">--%>
            <%--                    <div class="product-img">--%>
            <%--                        <img id="pro_img_src1" src="${pageContext.request.contextPath}/layui/images/product/one.png">--%>
            <%--                    </div>--%>
            <%--                    <div class="product-infor">--%>
            <%--                        <a class="product-href" id="pro-name1" href=""></a>--%>
            <%--                        <br>--%>
            <%--                        <span class="product-span" id="pro_infor1">--%>
            <%--                          这是商品的信息--%>
            <%--                        </span>--%>
            <%--                         <h3 id="pro_price1">￥500</h3>--%>
            <%--                    </div>--%>
            <%--                </div>--%>
            <%--            </div>--%>
            <%--        </div>--%>
        </div>
    </div>
    <div id="page" style="align-content: center"></div>
</div>

<script>


    buildHTML = function (tag, html, attrs) {
        // you can skip html param
        if (typeof (html) != 'string') {
            attrs = html;
            html = null;
        }
        var h = '<' + tag;
        for (attr in attrs) {
            if (attrs[attr] === false) continue;
            h += ' ' + attr + '="' + attrs[attr] + '"';
        }
        return h += html ? ">" + html + "</" + tag + ">" : "/>";
    };


    function set_html(count) {

        $(function () {
            var md3 = "";
            var card = "";

            for (var i = 0; i < count; i++) {
                md3 = buildHTML("div", "", {
                    class: "layui-col-md3",
                    id: "layui-col-md3-" + i
                });
                $('#LAY_layedit_code').append(md3);
            }
            for (var i = 0; i < count; i++) {
                card = buildHTML("div", "", {
                    class: "layui-card",
                    id: "layui-card-" + i
                });
                $("#layui-col-md3-" + i).append(card);

                var body = buildHTML("div", "", {
                    class: "layui-card-body",
                    id: "layui-card-body" + i
                });
                $("#layui-card-" + i).append(body);

                var image_pro = buildHTML("div", "", {
                    class: "product-img",
                    id: "product-img" + i
                });
                $("#layui-card-body" + i).append(image_pro);

                var target_imgsrc = buildHTML("img", "", {
                    id: "pro_img_src" + i,
                    src: "111"
                });
                $("#product-img" + i).append(target_imgsrc);


                var information = buildHTML("div", "", {
                    class: "product-infor",
                    id: "product-infor" + i
                });

                $('#layui-card-body' + i).append(information);

                var pro_herf = buildHTML("a", "", {
                    class: "product-href",
                    id: "pro_name" + i,
                    href: "111"
                });
                $("#product-infor" + i).append(pro_herf);

                $("#product-infor" + i).append("<br>");
                var pro_span = buildHTML("span", "商品信息", {
                    id: "pro_infor" + i,
                    class: "product-span"
                });
                $("#product-infor" + i).append(pro_span);
                var pro_h3 = buildHTML("h3", "$500", {
                    id: "pro_price" + i,
                });
                $("#product-infor" + i).append(pro_h3);
            }


        });

    }
    var total =0;
    function getTotal(){
        $.ajax({
            dataType:'text',
            url : 'getTotal',
            async:false,  //这里选择异步为false，那么这个程序执行到这里的时候会暂停，等待数据加载完成后才继续执行
            success : function(data){
                total=data;
            }
        });
    }

    getTotal();
    if (total>=12)
    {
        showRecord(1, 12);
    }
    else {
        showRecord(1,total);
    }


    function showRecord(page, limit) {
        if (total<limit){
            limit=total;
        }
        set_html(limit);
        var $pro_name = '';
        var $pro_infor = '';
        var $pro_img_src = '';
        var $pro_price = '';
        $.getJSON("getLimitMedJson",
            {
                limit: limit,
                page: page
            }
            , function (data) {
                $.each(data, function (infoIndex, info) {
                    $pro_name = $('#pro_name' + infoIndex);
                    $pro_infor = $('#pro_infor' + infoIndex);
                    $pro_img_src = $('#pro_img_src' + infoIndex);
                    $pro_price = $('#pro_price' + infoIndex);

                    $pro_name.html(info["product_name"]);//显示处理后的数据
                    // $pro_infor.html(info["details"]);//显示处理后的数据
                    $pro_img_src.attr("src", "http://localhost:8081/html/img/" + info["img_url"]);
                    $pro_price.html("￥" + info["cover_price"]);

                });

            });
    }



    layui.use(['laypage', 'jquery'], function () {

        var laypage = layui.laypage, $ = layui.$;

        laypage.render({
            elem: $("#page")
            //注意，这里的 elem 指向存放分页的容器，值可以是容器ID、DOM对象。
            //例1. elem: 'idName' 注意：如果这么写，这里不能加 # 号
            //例2. elem: document.getElementById('idName')
            //例3. elem: $("#idName")
            , count: total //数据总数，从服务端得到
            , limit: 10                      //默认每页显示条数
            , limits: [12, 16, 20]			//可选每页显示条数
            , curr: 1                        //起始页
            , groups: 5                      //连续页码个数
            , prev: '上一页'                 //上一页文本
            , netx: '下一页'                 //下一页文本
            , first: 1                      //首页文本
            // , last: 100                     //尾页文本
            , layout: ['prev', 'page', 'next', 'limit', 'refresh', 'skip']
            //跳转页码时调用
            , jump: function (obj, first) { //obj为当前页的属性和方法，第一次加载first为true
                //非首次加载 do something
                if (!first) {
                    //清空以前加载的数据
                    $('#LAY_layedit_code').empty();
                    //调用加载函数加载数据

                        showRecord(obj.curr,obj.limit);


                }
            }
        });
    });


    layui.use(['element', 'layer'], function () {
        var element = layui.element;
        var layer = layui.layer;

        //监听折叠
        element.on('collapse(test)', function (data) {
            layer.msg('展开状态：' + data.show);
        });
    });
</script>
</body>
</html>