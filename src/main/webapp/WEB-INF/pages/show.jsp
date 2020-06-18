<%--
  Created by IntelliJ IDEA.
  User: 12556
  Date: 2020/04/03
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>showdata</title>
    <meta charset="utf-8">
<%--    ${pageContext.request.contextPath}--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
<%--导航栏--%>
<%--<ul class="layui-nav layui-nav-tree layui-inline" lay-filter="demo" style="margin-right: 10px;">--%>
<%--    <li class="layui-nav-item layui-nav-itemed">--%>
<%--        <a href="javascript:;">默认展开</a>--%>
<%--        <dl class="layui-nav-child">--%>
<%--            <dd><a href="javascript:;">选项一</a></dd>--%>
<%--            <dd><a href="javascript:;">选项二</a></dd>--%>
<%--            <dd><a href="javascript:;">选项三</a></dd>--%>
<%--            <dd><a href="">跳转项</a></dd>--%>
<%--        </dl>--%>
<%--    </li>--%>
<%--    <li class="layui-nav-item">--%>
<%--        <a href="javascript:;">解决方案</a>--%>
<%--        <dl class="layui-nav-child">--%>
<%--            <dd><a href="">移动模块</a></dd>--%>
<%--            <dd><a href="">后台模版</a></dd>--%>
<%--            <dd><a href="">电商平台</a></dd>--%>
<%--        </dl>--%>
<%--    </li>--%>
<%--    <li class="layui-nav-item"><a href="">云市场</a></li>--%>
<%--    <li class="layui-nav-item"><a href="">社区</a></li>--%>
<%--</ul>--%>
<div class="layui-nav" lay-filter="test">
    <ul class="layui-nav-title">
        <li class="layui-nav-item layui-this"><a href="">用户管理</a></li>
        <li class="layui-nav-item "><a href="${pageContext.request.contextPath}/medUser/show">药品APP用户管理</a></li>
        <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/Medicine/showpro">展示药物</a></li>
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

<%--搜索栏--%>
<div class="demoTable" style="margin-left: 10px; margin-top: 30px;">
    搜索ID：
    <div class="layui-inline">
        <input class="layui-input" name="id" id="demoReload"  value=""  placeholder="请输入id" autocomplete="off">
    </div>
    <button class="layui-btn" data-type="reload">搜索</button>
    <button type="button" class="layui-btn layui-btn-radius" id="newset">新建</button>
    <button type="button" class="layui-btn layui-btn-radius" id="showAll">显示所有数据</button>
</div>
<%--表单--%>
<table class="layui-hide" id="LAY_table_user"  style="margin-left: 10px;margin-right: 10px;" lay-filter="user" ></table>
<%--工具栏--%>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" >删除</a>
</script>


</body>
<script>



    /**
     * 表单函数
     */
    layui.use('table', function(){
        var table = layui.table;
        var usetable =  table.render({
            elem: '#LAY_table_user'
            ,url: 'show1'
            ,method:"post"
            ,parseData: function(res){ //res 即为原始返回的数据

                if(res==null){
                    return{
                        "code" :1 ,
                        "msg" : "暂无数据",//可以随意提示任何信息
                        "data":[] //固定写法，如果不返回data，layui就会报数据接口异常。
                    }
                } else {
                    return {
                        "code": 0, //解析接口状态
                        "msg": "", //解析提示文本
                        "count": 100, //解析数据长度
                        "data": res //解析数据列表
                    };}

            }
            ,page: true //开启分页
            ,cols: [[ //表头
                {checkbox: true,fixed:true}
                ,{field: 'id', title: 'ID', width:200, sort: true,fixed: true}
                ,{field: 'username', title: '用户名', sort: true}
                ,{field: 'password', title: '密码'}
                ,{field: 'city', title: '城市', width:150}
                ,{field: 'sex', title: '性别', width:100}
                ,{fixed: 'right', width:180, align:'center', toolbar: '#barDemo',}
            ]],
            text: { //自定义文本，此处用法--》当返回数据为空时的异常提示
                none: '暂无相关数据' //默认：无数据。注：该属性为 layui 2.2.5 开始新增
            }

        });

        /**
         * 搜索栏函数
         * @type {jQuery|HTMLElement|(function(*=, *=): pe|*)|(function(*=, *=): *)}
         */
        var $ = layui.$, active = {
            reload: function(){
                var demoReload = $('#demoReload');
                //执行重载
                if (demoReload.val()){
                    table.reload('LAY_table_user',{  //这个地方一定要写table的id
                        page: {
                            curr: 1 //重新从第 1 页开始
                        }
                        ,url:'findOneById'
                        ,where: {
                            id:demoReload.val()
                        }

                    }, 'data');
                }else {
                    layer.alert('请输入id', {
                        icon: 5,
                        title: "提示"
                    });
                }
            }

        };


        /**
         * 工具条函数
         */
        table.on('tool(user)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性中的lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）

            /**
             * 查看
             */
            if (layEvent === "detail") { //查看
                //do somehing
                layer.alert('序号:' + data.username + '<br>id:' + data.id + '<br>编号：' + data.city);
            }

            /**
             * 选中删除
             */
            if (layEvent === 'del') {//监听删除
                layer.confirm('真的删除行么', function (index) {
                        $.ajax({
                            url: "deleteById",    //换成自己的url
                            type: "POST",
                            data: {
                                id: data.id
                            },
                            success: function (data) {
                                if (data ==="1") {
                                    //obj.del();
                                    layer.close(index);
                                    usetable.reload({
                                        page: {
                                            curr: 1 //重新从第 1 页开始
                                        }
                                    });

                                }
                            }

                        });

                    }
                );
            }

            /**
             * 编辑
             */
            if(obj.event === 'edit'){//监听编辑
                var index = layer.open({
                    type: 2,
                    title: "更改信息",
                    area: ['30%', '60%'],
                    fix: false,
                    maxmin: true,
                    shadeClose: true,
                    shade: 0.4,
                    method:'POST',
                    skin: 'layui-layer-rim',
                    content: "updateUser?id="+data.id //获取id值
                    ,end:function () {
                        usetable.reload({
                            page: {
                                curr: 1 //重新从第 1 页开始
                            }
                        });


                    }


                });

                /**
                 * 删除
                 */
                // layer.alert('编辑行：<br>'+ JSON.stringify(data))
                //
                // $.ajax({
                //     url: "DeleteServlet",    //换成自己的url
                //     type: "POST",
                //     data: {
                //         id: data.id
                //     },
                //     success: function (data) {
                //         if (data ==="1") {
                //             //obj.del();
                //             layer.close(index);
                //             usetable.reload({
                //                 page: {
                //                     curr: 1 //重新从第 1 页开始
                //                 }
                //             });
                //
                //         }
                //     }
                //
                // });

            }


        });


        /**
         * 新建user iframe
         */
        $("#newset").on('click', function(){//使用$前用var $= layui.$ 不然报错
            var index = layer.open({
                type: 2,
                title: "新建用户",
                area: ['30%', '60%'],
                fix: false,
                maxmin: true,
                shadeClose: true,
                shade: 0.4,
                method:'POST',
                skin: 'layui-layer-rim',
                content: "create_user" //获取id值
                ,end:function () {
                    table.reload('LAY_table_user',{
                        page: {
                            curr: 1 //重新从第 1 页开始
                        }
                    });

                }

            });


        });

        /**
         * 注销按钮
         */
        $("#logOff").on('click',function () {
            $.ajax({
                url: "logOff",    //换成自己的url
                type: "POST",
                // data: {
                //     id: data.id
                // },
                success: function (result) {
                    window.location.href="http://localhost:80";
                }

            });

        });



        /**
         * 显示所有数据
         */
        $("#showAll").on('click', function(){//使用$前用var $= layui.$ 不然报错
            $('#demoReload').val("");
            usetable.reload({
                page: {
                    curr: 1 //重新从第 1 页开始
                },url:"show1"
            });

        });

        /**
         * 搜索按钮事件
         */
        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

    });





</script>

</html>
