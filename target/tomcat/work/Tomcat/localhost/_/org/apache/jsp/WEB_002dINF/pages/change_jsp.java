/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-05-24 07:43:02 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class change_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>Title</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/layui/css/layui.css\">\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/layui/layui.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.4.1.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<ins class=\"adsbygoogle\" style=\"display:inline-block;width:970px;height:10px\" data-ad-client=\"ca-pub-6111334333458862\" data-ad-slot=\"3820120620\"></ins>\r\n");
      out.write("\r\n");
      out.write("<fieldset class=\"layui-elem-field layui-field-title\" style=\"margin-top: 20px;\">\r\n");
      out.write("    <legend>更改信息</legend>\r\n");
      out.write("</fieldset>\r\n");
      out.write("\r\n");
      out.write("<form class=\"layui-form\" action=\"updateUserById\"  method=\"post\">\r\n");
      out.write("    <div class=\"layui-form-item\">\r\n");
      out.write("        <label class=\"layui-form-label\">ID&nbsp;&nbsp;<i class=\"layui-icon layui-icon-key\" style=\"font-size: 30px; color: #92B8B1;\"></i></label>\r\n");
      out.write("        <div class=\"layui-input-inline\">\r\n");
      out.write("            <input  name=\"id\" type=\"text\"  id=\"set\"    readonly=\"readonly\" class=\"layui-input\">\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"layui-form-item\">\r\n");
      out.write("        <label class=\"layui-form-label\">用户名&nbsp;&nbsp;<i class=\"layui-icon layui-icon-username\" style=\"font-size: 30px; color: #92B8B1;\"></i></label>\r\n");
      out.write("        <div class=\"layui-input-inline\">\r\n");
      out.write("            <input type=\"text\" name=\"username\"  lay-verify=\"username\" autocomplete=\"off\" placeholder=\"请输入标题\" class=\"layui-input\">\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"layui-form-item\">\r\n");
      out.write("        <label class=\"layui-form-label\">密码&nbsp;&nbsp;<i class=\"layui-icon layui-icon-key\" style=\"font-size: 30px; color: #92B8B1;\"></i></label>\r\n");
      out.write("        <div class=\"layui-input-inline\">\r\n");
      out.write("            <input type=\"password\" name=\"password\" placeholder=\"请输入密码\" lay-verify=\"password\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <label class=\"layui-form-label\">城市&nbsp;&nbsp;<i class=\"layui-icon layui-icon-home\" style=\"font-size: 30px; color: #92B8B1;\"></i></label>\r\n");
      out.write("    <div class=\"layui-input-inline\">\r\n");
      out.write("        <select name=\"city\" lay-verify=\"required\">\r\n");
      out.write("            <option value=\"\">请选择</option>\r\n");
      out.write("            <option name=\"北京\">北京</option>\r\n");
      out.write("            <option name=\"上海\">上海</option>\r\n");
      out.write("            <option name=\"广州\">广州</option>\r\n");
      out.write("            <option name=\"深圳\">深圳</option>\r\n");
      out.write("            <option name=\"杭州\">杭州</option>\r\n");
      out.write("        </select>\r\n");
      out.write("    </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"layui-form-item\">\r\n");
      out.write("        <label class=\"layui-form-label\">单选框</label>\r\n");
      out.write("        <div class=\"layui-input-block\">\r\n");
      out.write("            <input type=\"radio\" name=\"sex\" value=\"男\" title=\"男\" checked=\"\">\r\n");
      out.write("            <input type=\"radio\" name=\"sex\" value=\"女\" title=\"女\">\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div class=\"layui-form-item\">\r\n");
      out.write("        <div class=\"layui-input-block\">\r\n");
      out.write("            <button type=\"submit\" class=\"layui-btn\" lay-submit lay-filter=\"forDemo\">立即提交</button>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</form>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    layui.use('form', function(){\r\n");
      out.write("        var form = layui.form;\r\n");
      out.write("        $(\"#set\").val(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(");\r\n");
      out.write("        form.render();//显示选择框\r\n");
      out.write("        form.verify({\r\n");
      out.write("            username: function(value, item){ //value：表单的值、item：表单的DOM对象\r\n");
      out.write("                if(!new RegExp(\"^[a-zA-Z0-9_\\u4e00-\\u9fa5\\\\s·]+$\").test(value)){\r\n");
      out.write("                    return '用户名不能有特殊字符';\r\n");
      out.write("                }\r\n");
      out.write("                if(/(^\\_)|(\\__)|(\\_+$)/.test(value)){\r\n");
      out.write("                    return '用户名首尾不能出现下划线\\'_\\'';\r\n");
      out.write("                }\r\n");
      out.write("                if(/^\\d+\\d+\\d$/.test(value)){\r\n");
      out.write("                    return '用户名不能全为数字';\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            //我们既支持上述函数式的方式，也支持下述数组的形式\r\n");
      out.write("            //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]\r\n");
      out.write("            ,password: [\r\n");
      out.write("                /^[\\S]{6,12}$/\r\n");
      out.write("                ,'密码必须6到12位，且不能出现空格'\r\n");
      out.write("            ]\r\n");
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
      out.write("\r\n");
      out.write("</body>\r\n");
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