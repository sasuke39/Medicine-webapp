/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-06-08 07:04:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class show_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>showdata</title>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/layui/css/layui.css\">\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/layui/layui.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.4.1.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<div class=\"layui-nav\" lay-filter=\"test\">\r\n");
      out.write("    <ul class=\"layui-nav-title\">\r\n");
      out.write("        <li class=\"layui-nav-item layui-this\"><a href=\"\">用户管理</a></li>\r\n");
      out.write("        <li class=\"layui-nav-item \"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/medUser/show\">药品APP用户管理</a></li>\r\n");
      out.write("        <li class=\"layui-nav-item\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/Medicine/showpro\">展示药物</a></li>\r\n");
      out.write("        <li class=\"layui-nav-item\">\r\n");
      out.write("            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/logOff\" >注销</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"layui-nav-item\" style=\"float:right;z-index: 9999;\">\r\n");
      out.write("            <a href=\"\"><img src=\"//t.cn/RCzsdCq\" class=\"layui-nav-img\">我</a>\r\n");
      out.write("            <dl class=\"layui-nav-child\">\r\n");
      out.write("                <dd><a href=\"\">修改信息</a></dd>\r\n");
      out.write("                <dd><a href=\"\">安全管理</a></dd>\r\n");
      out.write("                <dd><a href=\"\">退了</a></dd>\r\n");
      out.write("            </dl>\r\n");
      out.write("        </li>\r\n");
      out.write("    </ul>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"demoTable\" style=\"margin-left: 10px; margin-top: 30px;\">\r\n");
      out.write("    搜索ID：\r\n");
      out.write("    <div class=\"layui-inline\">\r\n");
      out.write("        <input class=\"layui-input\" name=\"id\" id=\"demoReload\"  value=\"\"  placeholder=\"请输入id\" autocomplete=\"off\">\r\n");
      out.write("    </div>\r\n");
      out.write("    <button class=\"layui-btn\" data-type=\"reload\">搜索</button>\r\n");
      out.write("    <button type=\"button\" class=\"layui-btn layui-btn-radius\" id=\"newset\">新建</button>\r\n");
      out.write("    <button type=\"button\" class=\"layui-btn layui-btn-radius\" id=\"showAll\">显示所有数据</button>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<table class=\"layui-hide\" id=\"LAY_table_user\"  style=\"margin-left: 10px;margin-right: 10px;\" lay-filter=\"user\" ></table>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/html\" id=\"barDemo\">\r\n");
      out.write("    <a class=\"layui-btn layui-btn-primary layui-btn-xs\" lay-event=\"detail\">查看</a>\r\n");
      out.write("    <a class=\"layui-btn layui-btn-xs\" lay-event=\"edit\">编辑</a>\r\n");
      out.write("    <a class=\"layui-btn layui-btn-danger layui-btn-xs\" lay-event=\"del\" >删除</a>\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    /**\r\n");
      out.write("     * 表单函数\r\n");
      out.write("     */\r\n");
      out.write("    layui.use('table', function(){\r\n");
      out.write("        var table = layui.table;\r\n");
      out.write("        var usetable =  table.render({\r\n");
      out.write("            elem: '#LAY_table_user'\r\n");
      out.write("            ,url: 'show1'\r\n");
      out.write("            ,method:\"post\"\r\n");
      out.write("            ,parseData: function(res){ //res 即为原始返回的数据\r\n");
      out.write("\r\n");
      out.write("                if(res==null){\r\n");
      out.write("                    return{\r\n");
      out.write("                        \"code\" :1 ,\r\n");
      out.write("                        \"msg\" : \"暂无数据\",//可以随意提示任何信息\r\n");
      out.write("                        \"data\":[] //固定写法，如果不返回data，layui就会报数据接口异常。\r\n");
      out.write("                    }\r\n");
      out.write("                } else {\r\n");
      out.write("                    return {\r\n");
      out.write("                        \"code\": 0, //解析接口状态\r\n");
      out.write("                        \"msg\": \"\", //解析提示文本\r\n");
      out.write("                        \"count\": 100, //解析数据长度\r\n");
      out.write("                        \"data\": res //解析数据列表\r\n");
      out.write("                    };}\r\n");
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("            ,page: true //开启分页\r\n");
      out.write("            ,cols: [[ //表头\r\n");
      out.write("                {checkbox: true,fixed:true}\r\n");
      out.write("                ,{field: 'id', title: 'ID', width:200, sort: true,fixed: true}\r\n");
      out.write("                ,{field: 'username', title: '用户名', sort: true}\r\n");
      out.write("                ,{field: 'password', title: '密码'}\r\n");
      out.write("                ,{field: 'city', title: '城市', width:150}\r\n");
      out.write("                ,{field: 'sex', title: '性别', width:100}\r\n");
      out.write("                ,{fixed: 'right', width:180, align:'center', toolbar: '#barDemo',}\r\n");
      out.write("            ]],\r\n");
      out.write("            text: { //自定义文本，此处用法--》当返回数据为空时的异常提示\r\n");
      out.write("                none: '暂无相关数据' //默认：无数据。注：该属性为 layui 2.2.5 开始新增\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        /**\r\n");
      out.write("         * 搜索栏函数\r\n");
      out.write("         * @type {jQuery|HTMLElement|(function(*=, *=): pe|*)|(function(*=, *=): *)}\r\n");
      out.write("         */\r\n");
      out.write("        var $ = layui.$, active = {\r\n");
      out.write("            reload: function(){\r\n");
      out.write("                var demoReload = $('#demoReload');\r\n");
      out.write("                //执行重载\r\n");
      out.write("                if (demoReload.val()){\r\n");
      out.write("                    table.reload('LAY_table_user',{  //这个地方一定要写table的id\r\n");
      out.write("                        page: {\r\n");
      out.write("                            curr: 1 //重新从第 1 页开始\r\n");
      out.write("                        }\r\n");
      out.write("                        ,url:'findOneById'\r\n");
      out.write("                        ,where: {\r\n");
      out.write("                            id:demoReload.val()\r\n");
      out.write("                        }\r\n");
      out.write("\r\n");
      out.write("                    }, 'data');\r\n");
      out.write("                }else {\r\n");
      out.write("                    layer.alert('请输入id', {\r\n");
      out.write("                        icon: 5,\r\n");
      out.write("                        title: \"提示\"\r\n");
      out.write("                    });\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        /**\r\n");
      out.write("         * 工具条函数\r\n");
      out.write("         */\r\n");
      out.write("        table.on('tool(user)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性中的lay-filter=\"对应的值\"\r\n");
      out.write("            var data = obj.data; //获得当前行数据\r\n");
      out.write("            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）\r\n");
      out.write("\r\n");
      out.write("            /**\r\n");
      out.write("             * 查看\r\n");
      out.write("             */\r\n");
      out.write("            if (layEvent === \"detail\") { //查看\r\n");
      out.write("                //do somehing\r\n");
      out.write("                layer.alert('序号:' + data.username + '<br>id:' + data.id + '<br>编号：' + data.city);\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            /**\r\n");
      out.write("             * 选中删除\r\n");
      out.write("             */\r\n");
      out.write("            if (layEvent === 'del') {//监听删除\r\n");
      out.write("                layer.confirm('真的删除行么', function (index) {\r\n");
      out.write("                        $.ajax({\r\n");
      out.write("                            url: \"deleteById\",    //换成自己的url\r\n");
      out.write("                            type: \"POST\",\r\n");
      out.write("                            data: {\r\n");
      out.write("                                id: data.id\r\n");
      out.write("                            },\r\n");
      out.write("                            success: function (data) {\r\n");
      out.write("                                if (data ===\"1\") {\r\n");
      out.write("                                    //obj.del();\r\n");
      out.write("                                    layer.close(index);\r\n");
      out.write("                                    usetable.reload({\r\n");
      out.write("                                        page: {\r\n");
      out.write("                                            curr: 1 //重新从第 1 页开始\r\n");
      out.write("                                        }\r\n");
      out.write("                                    });\r\n");
      out.write("\r\n");
      out.write("                                }\r\n");
      out.write("                            }\r\n");
      out.write("\r\n");
      out.write("                        });\r\n");
      out.write("\r\n");
      out.write("                    }\r\n");
      out.write("                );\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            /**\r\n");
      out.write("             * 编辑\r\n");
      out.write("             */\r\n");
      out.write("            if(obj.event === 'edit'){//监听编辑\r\n");
      out.write("                var index = layer.open({\r\n");
      out.write("                    type: 2,\r\n");
      out.write("                    title: \"更改信息\",\r\n");
      out.write("                    area: ['30%', '60%'],\r\n");
      out.write("                    fix: false,\r\n");
      out.write("                    maxmin: true,\r\n");
      out.write("                    shadeClose: true,\r\n");
      out.write("                    shade: 0.4,\r\n");
      out.write("                    method:'POST',\r\n");
      out.write("                    skin: 'layui-layer-rim',\r\n");
      out.write("                    content: \"updateUser?id=\"+data.id //获取id值\r\n");
      out.write("                    ,end:function () {\r\n");
      out.write("                        usetable.reload({\r\n");
      out.write("                            page: {\r\n");
      out.write("                                curr: 1 //重新从第 1 页开始\r\n");
      out.write("                            }\r\n");
      out.write("                        });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                });\r\n");
      out.write("\r\n");
      out.write("                /**\r\n");
      out.write("                 * 删除\r\n");
      out.write("                 */\r\n");
      out.write("                // layer.alert('编辑行：<br>'+ JSON.stringify(data))\r\n");
      out.write("                //\r\n");
      out.write("                // $.ajax({\r\n");
      out.write("                //     url: \"DeleteServlet\",    //换成自己的url\r\n");
      out.write("                //     type: \"POST\",\r\n");
      out.write("                //     data: {\r\n");
      out.write("                //         id: data.id\r\n");
      out.write("                //     },\r\n");
      out.write("                //     success: function (data) {\r\n");
      out.write("                //         if (data ===\"1\") {\r\n");
      out.write("                //             //obj.del();\r\n");
      out.write("                //             layer.close(index);\r\n");
      out.write("                //             usetable.reload({\r\n");
      out.write("                //                 page: {\r\n");
      out.write("                //                     curr: 1 //重新从第 1 页开始\r\n");
      out.write("                //                 }\r\n");
      out.write("                //             });\r\n");
      out.write("                //\r\n");
      out.write("                //         }\r\n");
      out.write("                //     }\r\n");
      out.write("                //\r\n");
      out.write("                // });\r\n");
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        /**\r\n");
      out.write("         * 新建user iframe\r\n");
      out.write("         */\r\n");
      out.write("        $(\"#newset\").on('click', function(){//使用$前用var $= layui.$ 不然报错\r\n");
      out.write("            var index = layer.open({\r\n");
      out.write("                type: 2,\r\n");
      out.write("                title: \"新建用户\",\r\n");
      out.write("                area: ['30%', '60%'],\r\n");
      out.write("                fix: false,\r\n");
      out.write("                maxmin: true,\r\n");
      out.write("                shadeClose: true,\r\n");
      out.write("                shade: 0.4,\r\n");
      out.write("                method:'POST',\r\n");
      out.write("                skin: 'layui-layer-rim',\r\n");
      out.write("                content: \"create_user\" //获取id值\r\n");
      out.write("                ,end:function () {\r\n");
      out.write("                    table.reload('LAY_table_user',{\r\n");
      out.write("                        page: {\r\n");
      out.write("                            curr: 1 //重新从第 1 页开始\r\n");
      out.write("                        }\r\n");
      out.write("                    });\r\n");
      out.write("\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        /**\r\n");
      out.write("         * 注销按钮\r\n");
      out.write("         */\r\n");
      out.write("        $(\"#logOff\").on('click',function () {\r\n");
      out.write("            $.ajax({\r\n");
      out.write("                url: \"logOff\",    //换成自己的url\r\n");
      out.write("                type: \"POST\",\r\n");
      out.write("                // data: {\r\n");
      out.write("                //     id: data.id\r\n");
      out.write("                // },\r\n");
      out.write("                success: function (result) {\r\n");
      out.write("                    window.location.href=\"http://localhost:80\";\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        /**\r\n");
      out.write("         * 显示所有数据\r\n");
      out.write("         */\r\n");
      out.write("        $(\"#showAll\").on('click', function(){//使用$前用var $= layui.$ 不然报错\r\n");
      out.write("            $('#demoReload').val(\"\");\r\n");
      out.write("            usetable.reload({\r\n");
      out.write("                page: {\r\n");
      out.write("                    curr: 1 //重新从第 1 页开始\r\n");
      out.write("                },url:\"show1\"\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        /**\r\n");
      out.write("         * 搜索按钮事件\r\n");
      out.write("         */\r\n");
      out.write("        $('.demoTable .layui-btn').on('click', function(){\r\n");
      out.write("            var type = $(this).data('type');\r\n");
      out.write("            active[type] ? active[type].call(this) : '';\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
