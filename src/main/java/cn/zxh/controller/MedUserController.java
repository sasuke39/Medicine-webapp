package cn.zxh.controller;

import cn.zxh.domain.Med_Order;
import cn.zxh.domain.Med_User;
import cn.zxh.domain.SimOrder;
import cn.zxh.service.Med_OrderService;
import cn.zxh.service.Med_UserService;
import cn.zxh.utils.RedisClusterClient;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import static cn.zxh.utils.CreatUid.getUUID;
import static cn.zxh.utils.CreatUid.gettimestr;

@Controller
@RequestMapping("medUser")
public class MedUserController {

    @Autowired
    private Med_UserService med_userService;

    @Autowired
    @Qualifier("MedOrderService")
    private Med_OrderService med_orderService;

    @Autowired
    @Qualifier("jsonArray")
    private JSONArray jsonArray = null;

    @RequestMapping("show")
    public String show() {
        return "medusershow";
    }

    @Resource
    private RedisClusterClient redisClusterClient;

    @RequestMapping("show1")
    @ResponseBody
    public JSONObject showMedUser() {
        JSONObject jsonObject = new JSONObject();


        return jsonObject;
    }

    @RequestMapping("login")
    @ResponseBody
    public JSONObject login(@RequestParam(value = "phone") String phone, @RequestParam(value = "password") String password) {
        JSONObject jsonObject = new JSONObject();
        if (phone != null || password != null || !password.equals("") || !phone.equals("")) {
            Med_User login = med_userService.login(phone, password);
            if (login != null) {
                jsonObject.put("code", "200");
                jsonObject.put("msg", "登陆成功");
                jsonObject.put("Med_user", login);

            } else {
                jsonObject.put("code", "500");
                jsonObject.put("msg", "登录失败,手机号或密码错误！");
                jsonObject.put("Med_user", null);
            }
            return jsonObject;
        } else {
            jsonObject.put("code", "500");
            jsonObject.put("msg", "登录失败 用户信息不能为空");
            jsonObject.put("Med_user", null);
        }
        return jsonObject;

    }

    @RequestMapping("register")
    @ResponseBody
    public JSONObject register(String username, String phone, String password) {
        JSONObject regResult = new JSONObject();
        if (med_userService.findByName(username) != null&&med_userService.findByPhone(phone)!=null) {
            if (med_userService.register(username, phone, password)) {
                regResult.put("code", "200");
                regResult.put("msg", "注册成功！");
            } else {
                regResult.put("code", "500");
                regResult.put("msg", "注册失败！");
            }
        } else {
            regResult.put("code", "500");
            regResult.put("msg", "该用户名或手机号已注册！");
        }
        return regResult;
    }

    @RequestMapping("newMedUser")
    @ResponseBody
    public String newMedUser(Med_User user) {
        user.setCreateTime(gettimestr());
        if (med_userService.findByName(user.getUsername()) == null) {
            if (med_userService.newMedUser(user)) {
                return "1";
            } else
                return "0";
        } else return "注册失败,您注册的用户名" + user.getUsername() + "已经注册，请换个用户名！";

    }

    @RequestMapping("getMedUserJson")
    public void getMedUserJson(HttpServletResponse response) throws IOException {
        List<JSONObject> allByJson = med_userService.findAllByJson();
        if (allByJson != null) {
            jsonArray.addAll(allByJson);
            response.getWriter().write(String.valueOf(jsonArray));
        }
        jsonArray.clear();
    }

    @RequestMapping("findOneById")
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
        Object UserById = redisClusterClient.get("User:id:" + id);
        if (UserById==null) {
            if (med_userService.findOneById(id) != null) {
                JSONObject oneById = med_userService.findOneById(id);
                /**
                 * 返回json数组
                 */
                redisClusterClient.put("User:id:"+id,oneById);
                response.getWriter().write(String.valueOf(oneById));

            } else response.getWriter().write("null");

        }else {
            response.getWriter().write(String.valueOf(UserById));
        }

    }

    @RequestMapping("showByLimit")
    @ResponseBody
    public List<Med_User> show1(int page, int limit) throws Exception {
        /**
         * 设置格式编码等
         * 已开启过滤器设置编码
         */
        System.out.println("表现层！showByLimit!!!!");
        List<Med_User> objects =null;
//        System.out.println(limit+page);
        /**
         * 调用业务层代码，封装json数据
         */
        Object UserByLimit = redisClusterClient.get("MedUser:" + page + ":" + limit);
        if (UserByLimit ==null) {
            objects = med_userService.findAllLimit(((page - 1) * limit), limit);
            redisClusterClient.put("MedUser:" + page + ":" + limit,objects);
            System.out.println(objects);
            return objects;
        }else {
            return (List<Med_User>)UserByLimit;
        }

        /**
         * 返回json数组
         */


    }

    @RequestMapping("getallOrder")
    public void all(String uid, HttpServletResponse response) throws IOException {
        System.out.println(uid);
        List<Med_Order> ordersByUid = med_orderService.findOrdersByUid(Integer.valueOf(uid));
        jsonArray.addAll(ordersByUid);
        response.getWriter().write(String.valueOf(jsonArray));
        System.out.println(jsonArray);
        jsonArray.clear();

    }

    @RequestMapping("/deleteById")
    public void deleteById(String id, HttpServletResponse response) throws Exception {
        /**
         * 获取参数
         */
        System.out.println(id);
        /**
         * 调用业务层代码，封装json数据
         */
        int deleteById = med_userService.deleteById(Integer.valueOf(id));
        System.out.println(deleteById);
        if (deleteById == 1) {
            response.getWriter().write("1");
        } else {
            response.getWriter().write("0");
        }

    }

    @RequestMapping("create_user")
    public String create_user() {
        return "creatMedUser";
    }

    @RequestMapping("updateMedUser")
    public String updateMedUser(String uid) {
        int id = Integer.parseInt(uid);
        System.out.println("从子页面得到的ID ：" + id);
        return "changeMedUser";
    }

    @RequestMapping("changeMedUser")
    public String changeMedUser(Med_User user) {
        System.out.println("更改用户的信息:" + user);
        if (med_userService.findByName(user.getUsername()) == null) {
            if (med_userService.updateUser(user)) {
                return "success";
            } else return "fail";
        } else return "fail";
    }

    @RequestMapping("getOrderByUid")
    public String updateUser(HttpServletResponse response, HttpServletRequest request) throws Exception {
        /**
         * 获取参数
         */
        int uid = Integer.parseInt(request.getParameter("uid"));
        System.out.println("从子页面得到的uid：" + uid);
        return "userOrder";

    }

    @ResponseBody //返回json数据
    @RequestMapping(value = "/uploadUserIcon", method = RequestMethod.POST)
    /**
     * 这里@RequestParam(value = "file")一定加上 value =
     */
    public JSONObject uploadImg(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "userId") String userId) {


        /**
         * 获取文件名划分出最后一个后缀名
         */
        System.out.println("进行该操作的UserID:" + userId);
        JSONObject jsonObject = new JSONObject();
        String lastname = "jpg";
        String originalFilename = file.getOriginalFilename();
        String[] strings = originalFilename.split("\\.");
        for (int i = 0; i < strings.length; i++) {
            if (i + 1 == strings.length) {
                lastname = strings[i];
            }
        }

        String fileName = null;
        boolean ifname = false;
        while (!ifname) {
            fileName = getUUID();
            fileName = fileName + "." + lastname;
            if (med_userService.ifExistIconUrl(fileName) == 0) {
                System.out.println("不重名！");
                ifname = true;
            }
        }

        if (file.isEmpty()) {
            jsonObject.put("code", "500");
            jsonObject.put("msg", "文件为空！");
            return jsonObject;
        }
        try {
            uploadFile(file.getBytes(), "F:/Program Files (x86)/apache-tomcat-9.0.31/webapps/Medapp/user_icon", fileName);
//            System.out.println(file);
            Med_User oneUserById = med_userService.findOneUserById(Integer.valueOf(userId));
            if (oneUserById != null) {
                oneUserById.setUser_icon(fileName);
                if (med_userService.updateUser(oneUserById)) {
                    jsonObject.put("msg", "更新用户信息成功！");
                    jsonObject.put("code", "200");
                } else {
                    jsonObject.put("code", "501");
                    jsonObject.put("msg", "更新失败！");
                }
                System.out.println(fileName);
            } else {
                jsonObject.put("msg", "查无此人！");
                jsonObject.put("code", "502");
            }
            return jsonObject;

        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("msg", "用户更新失败！");
            jsonObject.put("code", "501");
            return jsonObject;

        }


    }

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {

        File targetFile = new File(filePath);

        if (!targetFile.exists()) {

            targetFile.mkdirs();

        }

        FileOutputStream out = new FileOutputStream(filePath + "/" + fileName);

        out.write(file);

        out.flush();

        out.close();

    }


//    @ResponseBody //返回json数据
//    @RequestMapping(value = "/upUserIcon", method = RequestMethod.POST)
//    /**
//     * 这里@RequestParam(value = "file")一定加上 value =
//     */
//    public JSONObject uploadImg(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
//
//
//        /**
//         * 获取文件名划分出最后一个后缀名
//         */
//        String lastname="jpg";
//        String originalFilename = file.getOriginalFilename();
//        String[] strings = originalFilename.split("\\.");
//        for (int i = 0;i<strings.length;i++){
//            if (i+1==strings.length){
//                lastname=strings[i];
//            }
//        }
//
//
//        boolean ifname =false;
//        while (!ifname) {
//            fileName=getUUID();
//            if (!medicineService.ifhaveurl(fileName)){
//                System.out.println("不重名！");
//                ifname =true;
//            }
//        }
//
//        fileName =fileName+ "."+lastname;
//        System.out.println(fileName);
//
//
//
////        System.out.println("成功进入uploadIMG函数");
//        JSONObject jsonObject = new JSONObject();
//
//
//        if (file.isEmpty()) {
//            jsonObject.put("code", 0);
//            jsonObject.put("msg", "文件为空！");
//
//            return jsonObject;
//
//        }
//
//        try {
//
//            uploadFile(file.getBytes(), "H:/img", fileName);
////            System.out.println(file);
//            jsonObject.put("code", 0);
//            jsonObject.put("msg", "文件上传成功");
//
//        } catch (Exception e) {
//
//// TODO: handle exception
//
//        }
//
////返回json
//
//        return jsonObject;
//
//    }

}
