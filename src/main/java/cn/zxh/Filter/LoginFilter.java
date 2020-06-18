package cn.zxh.Filter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        System.out.println("请求的URI：" + url);
        if (url.contains("login")){
            System.out.println("同意放行");
            return true;
        }
        HttpSession session = request.getSession();
        Object name_now = session.getAttribute("username" );
        if (name_now != null) {
            System.out.println(name_now.toString());
            System.out.println("同意放行");
            return true;
        }
        else
        {
            System.out.println(name_now);
            response.sendRedirect("/");
            System.out.println("不同意放行");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("LoginFilter doFilter");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();

        String url = request.getRequestURI();
        System.out.println("请求的URI：" + url);


//        int idx = url.lastIndexOf("/");
//        String endWith = url.substring(idx + 1);//获取最后一个/的位置 截取后面的uri


        if ((isLogin(request))) {

            chain.doFilter(req, resp);

        } else {
            /*访问来的不是登录页面  进行拦截处理*/
            System.out.println("不是登录页面，进行拦截处理");
            session.setAttribute("login_msg", "请先登录后访问！");
            response.sendRedirect("index.jsp");


        }
    }

    private boolean isLogin(HttpServletRequest request) {

        HttpSession session = request.getSession();
        String sId = request.getParameter("SId");
        System.out.println(sId);
        Object name_now = session.getAttribute("name_now" + sId);
        if (name_now != null) {
            String name_s = name_now.toString();
            System.out.println(name_s);
            if (name_s.equals(sId))
                return true;
            else
                return false;
            //  if (name_now ==)

//
//        String account = "";
//        String pwd = "";

//        if (cookies != null && cookies.length > 0) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("account")) {
//                    account = cookie.getValue();
//                } else if (cookie.getName().equals("pwd")) {
//                    pwd = cookie.getValue();
//                }
//            }
//        }
//
//        if (account.equals("") || pwd.equals("")) {
//            return false;
//
//        } else if (account.equals("yzq") && pwd.equals("123")) {
//            return true;
//        }
        } else
            return false;


    }


    public void init(FilterConfig config) throws ServletException {
        System.out.println("LoginFilter  init");
    }

}
