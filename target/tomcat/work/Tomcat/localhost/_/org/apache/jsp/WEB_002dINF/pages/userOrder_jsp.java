/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-05-30 16:37:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class userOrder_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>查看订单</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/layui/css/layui.css\">\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/layui/layui.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.4.1.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"layui-form\">\r\n");
      out.write("    <table class=\"layui-table\" id=\"user_table\">\r\n");
      out.write("        <colgroup>\r\n");
      out.write("            <col width=\"150\">\r\n");
      out.write("            <col width=\"150\">\r\n");
      out.write("            <col width=\"200\">\r\n");
      out.write("            <col width=\"300\">\r\n");
      out.write("            <col>\r\n");
      out.write("        </colgroup>\r\n");
      out.write("        <thead>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <th>订单ID</th>\r\n");
      out.write("            <th>用户ID</th>\r\n");
      out.write("            <th>创建时间</th>\r\n");
      out.write("            <th>货物信息</th>\r\n");
      out.write("        </tr>\r\n");
      out.write("        </thead>\r\n");
      out.write("        <tbody id=\"order_tbody\">\r\n");
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
      out.write("        </tbody>\r\n");
      out.write("    </table>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    buildHTML = function (tag, html, attrs) {\r\n");
      out.write("        // you can skip html param\r\n");
      out.write("        if (typeof (html) != 'string') {\r\n");
      out.write("            attrs = html;\r\n");
      out.write("            html = null;\r\n");
      out.write("        }\r\n");
      out.write("        var h = '<' + tag;\r\n");
      out.write("        for (attr in attrs) {\r\n");
      out.write("            if (attrs[attr] === false) continue;\r\n");
      out.write("            h += ' ' + attr + '=\"' + attrs[attr] + '\"';\r\n");
      out.write("        }\r\n");
      out.write("        return h += html ? \">\" + html + \"</\" + tag + \">\" : \"/>\";\r\n");
      out.write("    };\r\n");
      out.write("\r\n");
      out.write("    function set_html(count) {\r\n");
      out.write("\r\n");
      out.write("        $(function () {\r\n");
      out.write("            var md3 = \"\";\r\n");
      out.write("            var card = \"\";\r\n");
      out.write("\r\n");
      out.write("            for (var i = 0; i < count; i++) {\r\n");
      out.write("                tr = buildHTML(\"tr\", \"\", {\r\n");
      out.write("                    class: \"order\",\r\n");
      out.write("                    id: \"order-\" + i\r\n");
      out.write("                });\r\n");
      out.write("                $('#order_tbody').append(tr);\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            for (var i = 0; i < count; i++) {\r\n");
      out.write("                for (var j = 0; j < 4; j++) {\r\n");
      out.write("                    td = buildHTML(\"td\", \"\", {\r\n");
      out.write("                        class: \"order_item\",\r\n");
      out.write("                        id: i+\"-\" + j\r\n");
      out.write("                    });\r\n");
      out.write("                    $(\"#order-\" + i).append(td);\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    var total =0;\r\n");
      out.write("    var id =");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.uid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(";\r\n");
      out.write("    function getTotal(){\r\n");
      out.write("\r\n");
      out.write("        $.ajax({\r\n");
      out.write("            dataType:'text',\r\n");
      out.write("            url : 'getTotal',\r\n");
      out.write("        data:{\r\n");
      out.write("                uid:id,\r\n");
      out.write("        },\r\n");
      out.write("            async:false,  //这里选择异步为false，那么这个程序执行到这里的时候会暂停，等待数据加载完成后才继续执行\r\n");
      out.write("            success : function(data){\r\n");
      out.write("                total=data;\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    }\r\n");
      out.write("    getTotal();\r\n");
      out.write("    if (total>0) {\r\n");
      out.write("\r\n");
      out.write("        showRecord(id);\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    var flag =0;\r\n");
      out.write("    function showRecord(id) {\r\n");
      out.write("        set_html(total);\r\n");
      out.write("            var $order_id= '';\r\n");
      out.write("            var $user_id = '';\r\n");
      out.write("            var $create_time = '';\r\n");
      out.write("            var $pro_detail = '';\r\n");
      out.write("            $.getJSON(\"getallOrder\",\r\n");
      out.write("            {\r\n");
      out.write("                    uid:id,\r\n");
      out.write("            },\r\n");
      out.write("                function (data) {\r\n");
      out.write("                    //0-0 0-1 0-2 0-3\r\n");
      out.write("                    //1-1 1-2 1-3 1-4\r\n");
      out.write("                    $.each(data, function (infoIndex, info) {\r\n");
      out.write("                        // alert(\"id=\"+flag+\"-\"+(parseInt(infoIndex)-flag).toString());\r\n");
      out.write("                        $order_id = $('#'+flag +\"-\"+ (parseInt(infoIndex)-flag).toString());\r\n");
      out.write("\r\n");
      out.write("                        // alert(\"id=\"+flag+\"-\"+(parseInt(infoIndex)+1-flag).toString());\r\n");
      out.write("                        $user_id = $('#'+flag + \"-\"+(parseInt(infoIndex)+1-flag).toString());\r\n");
      out.write("\r\n");
      out.write("                        // alert(\"id=\"+flag+\"-\"+(parseInt(infoIndex)+2-flag).toString());\r\n");
      out.write("                        $create_time = $('#'+flag + \"-\"+(parseInt(infoIndex)+2-flag).toString());\r\n");
      out.write("\r\n");
      out.write("                        // alert(\"id=\"+flag+\"-\"+(parseInt(infoIndex)+3-flag).toString());\r\n");
      out.write("                        $pro_detail = $('#'+flag +\"-\"+ (parseInt(infoIndex)+3-flag).toString());\r\n");
      out.write("                        // $pro_name.html(info[\"1\"]);//显示处理后的数据\r\n");
      out.write("                        // $pro_infor.html(info[\"1\"]);//显示处理后的数据\r\n");
      out.write("                        // $pro_price.html(\"￥\" + info[\"1\"]);\r\n");
      out.write("                        $order_id.html(info[\"id\"]);//显示处理后的数据\r\n");
      out.write("                        $user_id.html(info[\"uid\"]);//显示处理后的数据\r\n");
      out.write("                        $create_time.html(info.createTime);\r\n");
      out.write("                        $pro_detail.html(info.medicine.details);\r\n");
      out.write("                        flag++;\r\n");
      out.write("                    });\r\n");
      out.write("\r\n");
      out.write("                });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        // var $pro_name = '';\r\n");
      out.write("        // var $pro_infor = '';\r\n");
      out.write("        // var $pro_img_src = '';\r\n");
      out.write("        // var $pro_price = '';\r\n");
      out.write("        // $.getJSON(\"getLimitMedJson\",\r\n");
      out.write("        //     {\r\n");
      out.write("        //         limit: limit,\r\n");
      out.write("        //         page: page\r\n");
      out.write("        //     }\r\n");
      out.write("        //     , function (data) {\r\n");
      out.write("        //         $.each(data, function (infoIndex, info) {\r\n");
      out.write("        //             $pro_name = $('#pro_name' + infoIndex);\r\n");
      out.write("        //             $pro_infor = $('#pro_infor' + infoIndex);\r\n");
      out.write("        //             $pro_img_src = $('#pro_img_src' + infoIndex);\r\n");
      out.write("        //             $pro_price = $('#pro_price' + infoIndex);\r\n");
      out.write("        //\r\n");
      out.write("        //             $pro_name.html(info[\"product_name\"]);//显示处理后的数据\r\n");
      out.write("        //             $pro_infor.html(info[\"details\"]);//显示处理后的数据\r\n");
      out.write("        //             $pro_img_src.attr(\"src\", \"http://localhost:8081/html/img/\" + info[\"img_url\"]);\r\n");
      out.write("        //             $pro_price.html(\"￥\" + info[\"cover_price\"]);\r\n");
      out.write("        //\r\n");
      out.write("        //         });\r\n");
      out.write("        //\r\n");
      out.write("        //     });\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
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
