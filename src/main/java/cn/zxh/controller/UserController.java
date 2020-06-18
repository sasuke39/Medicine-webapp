package cn.zxh.controller;

import cn.zxh.domain.User;
import cn.zxh.service.UserService;
import cn.zxh.utils.ResultUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    @Qualifier("jsonArray")
    private JSONArray jsonArray;

    @Value("#{configProperties['user_show']}")
    String user_show_url;



    @RequestMapping("index")
    public String index(){
        return "redirect:/";
    }
    @RequestMapping("logOff")
    public String  logOff(HttpServletRequest request){
        System.out.println("进入注销页面");
        HttpSession session = request.getSession();
        Object username = session.getAttribute("username");
        if (username!=null) {
            System.out.println(username);
        }
        session.invalidate();
        return "redirect:/";

    }

    @RequestMapping("creatUser")
    public String creatUser(User user){
        userService.newUser(user);
        return "success";
    }

    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    @RequestMapping("/save_user")
    public String save_user(User user) {


        System.out.println(user);
        userService.saveUser(user);
        return "success"; //默认是jsp文件的名字
    }

    /**
     * 镶嵌型新建用户
     *
     * @return
     */
    @RequestMapping("create_user")
    public String create_user() {
        return "creatuser";
    }

    /**
     * 分页显示用户后台数据
     *
     * @param response
     * @param request
     * @throws Exception
     */

    @RequestMapping("/show1")
    public void show1(HttpServletResponse response, HttpServletRequest request) throws Exception {
        /**
         * 设置格式编码等
         * 已开启过滤器设置编码
         */
        System.out.println("表现层！show1!!!!");
        /**
         * 获取参数
         */
        int limit = Integer.parseInt(request.getParameter("limit"));
        int page = Integer.parseInt(request.getParameter("page"));
//        System.out.println(limit+page);
        /**
         * 调用业务层代码，封装json数据
         */

        List<JSONObject> objects = userService.findAllLimit(((page - 1) * limit), limit);
        jsonArray.addAll(objects);
        System.out.println(jsonArray);
        /**
         * 返回json数组
         */
        response.getWriter().write(String.valueOf(jsonArray));
        jsonArray.clear();

    }

    /**
     * 通过id搜索用户数据
     *
     * @param response
     * @param request
     * @throws Exception
     */
    @RequestMapping("/findOneById")
    public void findOneById(HttpServletResponse response, HttpServletRequest request) throws Exception {
        /**
         * 设置格式编码等
         */

        /**
         * 获取参数
         */
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);

        /**
         * 调用业务层代码，封装json数据
         */
        if (userService.findOneById(id) != null) {
            JSONObject oneById = userService.findOneById(id);
            JSONArray array = new JSONArray();
            array.add(oneById);
            /**
             * 返回json数组
             */
            response.getWriter().write(String.valueOf(array));

        } else response.getWriter().write("null");

    }

    @RequestMapping("show")
    public String show(){
        return "show";
    }


    @RequestMapping("login")
    public String  login(String username, String password, HttpServletRequest request){
        System.out.println("进入login！");
        ResultUtil resultUtil = new ResultUtil();
        User serviceByName = userService.findByName(username);
        if (serviceByName != null) {
            if (serviceByName.getPassword().equals(password)) {
                resultUtil.setMessage("500");
                resultUtil.setMessage("Login success!");
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setMaxInactiveInterval(60 * 60 * 24);//一天时间
                System.out.println("进入login success！");
                return "redirect:"+user_show_url;
            }else {
                ResultUtil util = new ResultUtil();
                util.setCode("400");
                util.setMessage("密码错误！");
                return "redirect:/";
            }

        } else {
            ResultUtil util = new ResultUtil();
            util.setCode("200");
            util.setMessage("用户名不存在！");
            return "redirect:/";
        }
    }



    /**
     * 测试超链接跳转show页面
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/show2")
    public String show2() throws Exception {
        System.out.println("表现层show！");
        return "testjson";
    }

    @RequestMapping("/showall")
    public void showall(HttpServletResponse response, HttpServletRequest request) throws Exception {
        /**
         * 设置格式编码等
         * 已开启过滤器设置编码
         */
        System.out.println("表现层！showall!!!!");
        /**
         * 获取参数
         */
        /**
         * 调用业务层代码，封装json数据
         */

        List<JSONObject> objects = userService.findAllJSON();
        jsonArray.addAll(objects);
        System.out.println(jsonArray);
        /**
         * 返回json数组
         */
        response.getWriter().write(String.valueOf(jsonArray));
        jsonArray.clear();

    }

    /**
     * 通过id删除用户数据
     *
     * @param response
     * @param request
     * @throws Exception
     */
    @RequestMapping("/deleteById")
    public void deleteById(HttpServletResponse response, HttpServletRequest request) throws Exception {
        /**
         * 获取参数
         */
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        /**
         * 调用业务层代码，封装json数据
         */
        if (userService.deleteUser(id) == 1) {
            response.getWriter().write("1");
        } else {
            response.getWriter().write("0");
        }

    }

    @RequestMapping("updateUser")
    public String updateUser(HttpServletResponse response, HttpServletRequest request) throws Exception {
        /**
         * 获取参数
         */
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("从子页面得到的id："+id);
        return "change";
    }

    @RequestMapping("/updateUserById")
    public String  updateUserById(User user) {
        /**
         * 获取参数
         */
        System.out.println(user);
        /**
         * 调用业务层代码，封装json数据
         */
        System.out.println("表现层update成功指标："+userService.updateUser(user.getId(),user));

        /**
         * 返回json数组
         */
        return "success";


    }



}
