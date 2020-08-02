package cn.zxh.controller;

import cn.zxh.domain.Goods;
import cn.zxh.domain.Med_Order;
import cn.zxh.domain.Medicine;
import cn.zxh.domain.SimOrder;
import cn.zxh.service.GoodsService;
import cn.zxh.service.Med_OrderService;
import cn.zxh.service.MedicineService;
import cn.zxh.utils.RedisClusterClient;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.xdevapi.JsonArray;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

@Controller
@RequestMapping("/order")
public class MedOrderController {

    @Autowired
    @Qualifier("MedOrderService")
    Med_OrderService med_orderService;
    @Autowired
    MedicineService medicineService;
    @Resource
    private RedisClusterClient redisClusterClient;



    @RequestMapping("/neworderbyUser")
    @ResponseBody
    public JSONObject newOrder(@RequestBody SimOrder simOrder){
        JSONObject jsonObject =new JSONObject();
        System.out.println(simOrder);
        if (simOrder!=null||simOrder.toString()!="[]"|| !simOrder.toString().equals("")) {
            if (med_orderService.newUsersOrder(simOrder)){
                jsonObject.put("code","200");
                jsonObject.put("msg","success");
                return jsonObject;
            }else {
                jsonObject.put("code","400");
                jsonObject.put("msg","order service failed");
                return jsonObject;
            }

        }else {
            jsonObject.put("code","500");
            jsonObject.put("msg","fail!");
            return jsonObject;
        }
    }

    @RequestMapping("/MedOrderByUid")
    @ResponseBody
    public JSONObject MedOrderById(HttpServletResponse response, HttpServletRequest request) throws Exception {
        /**
         * 获取参数
         */
        List<Med_Order> orders=null;
        String redisUserId =  request.getParameter("uid");
        int uid = Integer.parseInt(redisUserId);

        JSONObject jsonObject = new JSONObject();
        Object object =  redisClusterClient.get("UserOrder:uid:" + uid);//直接去redis读取信息
        System.out.println(object);
        if(object!=null){//读到了信息
            System.out.println("来自redis："+object);
            jsonObject.put("MedOrder",object);
            jsonObject.put("userId",uid);
            jsonObject.put("msg","get success");
            jsonObject.put("code","200");
            return jsonObject;

        }
        else {//没有读到信息
            //去mysql数据库读取
            Integer count = med_orderService.countbyuseridorder(uid);
            if (count>0){
                 orders = med_orderService.findOrdersByUid(uid);
                if (!orders.toString().equals("[]"))
                {
                    jsonObject.put("MedOrder",orders);
                    jsonObject.put("userId",uid);
                    jsonObject.put("msg","get success");
                    jsonObject.put("code","200");
                    redisClusterClient.put("UserOrder:uid:"+redisUserId, jsonObject);
                }
                else {
                    jsonObject.put("msg","get fail");
                    jsonObject.put("code","500");
                }

            }else {

                jsonObject.put("msg","no order !");
                jsonObject.put("code","201");

            }

            //同步到redis中
            return jsonObject;
        }




    }

    @RequestMapping("/getTotal")
    public void getTotal(HttpServletResponse response,HttpServletRequest request) throws IOException {
        System.out.println("进入Gettotal!");
        Integer uid = Integer.valueOf(request.getParameter("uid"));
        Integer integer = med_orderService.countbyuseridorder(uid);
        response.getWriter().print(integer);

    }

}
