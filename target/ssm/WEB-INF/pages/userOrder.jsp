<%--
  Created by IntelliJ IDEA.
  User: 12556
  Date: 2020/05/24
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>查看订单</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>

<div class="layui-form">
    <table class="layui-table" id="user_table">
        <colgroup>
            <col width="150">
            <col width="150">
            <col width="200">
            <col width="300">
            <col>
        </colgroup>
        <thead>
        <tr>
            <th>订单ID</th>
            <th>用户ID</th>
            <th>创建时间</th>
            <th>货物信息</th>
        </tr>
        </thead>
        <tbody id="order_tbody">
<%--        <tr id="1-1">--%>
<%--            <td>贤心</td>--%>
<%--            <td>汉族</td>--%>
<%--            <td>1989-10-14</td>--%>
<%--            <td>人生似修行</td>--%>
<%--        </tr>--%>
<%--        <tr id="1-2">--%>
<%--            <td>张爱玲</td>--%>
<%--            <td>汉族</td>--%>
<%--            <td>1920-09-30</td>--%>
<%--            <td>于千万人之中遇见你所遇见的人，于千万年之中，时间的无涯的荒野里…</td>--%>
<%--        </tr>--%>
<%--        <tr id="1-3">--%>
<%--            <td>Helen Keller</td>--%>
<%--            <td>拉丁美裔</td>--%>
<%--            <td>1880-06-27</td>--%>
<%--            <td> Life is either a daring adventure or nothing.</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>岳飞</td>--%>
<%--            <td>汉族</td>--%>
<%--            <td>1103-北宋崇宁二年</td>--%>
<%--            <td>教科书再滥改，也抹不去“民族英雄”的事实</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>孟子</td>--%>
<%--            <td>华夏族（汉族）</td>--%>
<%--            <td>公元前-372年</td>--%>
<%--            <td>猿强，则国强。国强，则猿更强！ </td>--%>
<%--        </tr>--%>
        </tbody>
    </table>
</div>

</body>

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
                tr = buildHTML("tr", "", {
                    class: "order",
                    id: "order-" + i
                });
                $('#order_tbody').append(tr);
            }

            for (var i = 0; i < count; i++) {
                for (var j = 0; j < 4; j++) {
                    td = buildHTML("td", "", {
                        class: "order_item",
                        id: i+"-" + j
                    });
                    $("#order-" + i).append(td);
                }
            }

        });

    }

    var total =0;
    var id =${param.uid};
    function getTotal(){

        $.ajax({
            dataType:'text',
            url : 'getTotal',
        data:{
                uid:id,
        },
            async:false,  //这里选择异步为false，那么这个程序执行到这里的时候会暂停，等待数据加载完成后才继续执行
            success : function(data){
                total=data;
            }
        });
    }
    getTotal();
    if (total>0) {

        showRecord(id);
    }

    var flag =0;
    function showRecord(id) {
        set_html(total);
            var $order_id= '';
            var $user_id = '';
            var $create_time = '';
            var $pro_detail = '';
            $.getJSON("getallOrder",
            {
                    uid:id,
            },
                function (data) {
                    //0-0 0-1 0-2 0-3
                    //1-1 1-2 1-3 1-4
                    $.each(data, function (infoIndex, info) {
                        // alert("id="+flag+"-"+(parseInt(infoIndex)-flag).toString());
                        $order_id = $('#'+flag +"-"+ (parseInt(infoIndex)-flag).toString());

                        // alert("id="+flag+"-"+(parseInt(infoIndex)+1-flag).toString());
                        $user_id = $('#'+flag + "-"+(parseInt(infoIndex)+1-flag).toString());

                        // alert("id="+flag+"-"+(parseInt(infoIndex)+2-flag).toString());
                        $create_time = $('#'+flag + "-"+(parseInt(infoIndex)+2-flag).toString());

                        // alert("id="+flag+"-"+(parseInt(infoIndex)+3-flag).toString());
                        $pro_detail = $('#'+flag +"-"+ (parseInt(infoIndex)+3-flag).toString());
                        // $pro_name.html(info["1"]);//显示处理后的数据
                        // $pro_infor.html(info["1"]);//显示处理后的数据
                        // $pro_price.html("￥" + info["1"]);
                        $order_id.html(info["id"]);//显示处理后的数据
                        $user_id.html(info["uid"]);//显示处理后的数据
                        $create_time.html(info.createTime);
                        $pro_detail.html(info.medicine.details);
                        flag++;
                    });

                });


        // var $pro_name = '';
        // var $pro_infor = '';
        // var $pro_img_src = '';
        // var $pro_price = '';
        // $.getJSON("getLimitMedJson",
        //     {
        //         limit: limit,
        //         page: page
        //     }
        //     , function (data) {
        //         $.each(data, function (infoIndex, info) {
        //             $pro_name = $('#pro_name' + infoIndex);
        //             $pro_infor = $('#pro_infor' + infoIndex);
        //             $pro_img_src = $('#pro_img_src' + infoIndex);
        //             $pro_price = $('#pro_price' + infoIndex);
        //
        //             $pro_name.html(info["product_name"]);//显示处理后的数据
        //             $pro_infor.html(info["details"]);//显示处理后的数据
        //             $pro_img_src.attr("src", "http://localhost:8081/html/img/" + info["img_url"]);
        //             $pro_price.html("￥" + info["cover_price"]);
        //
        //         });
        //
        //     });
    }
</script>
</html>
