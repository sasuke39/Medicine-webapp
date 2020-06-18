package cn.zxh.controller;

import cn.zxh.service.ProductService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
  @Autowired
  private ProductService productService;


  @RequestMapping("/showpro")
  public String show(){
    return "productShow";
  }


  @RequestMapping("/showall")
  public void showall(HttpServletResponse response, HttpServletRequest request) throws Exception {
    /**
     * 设置格式编码等
     * 已开启过滤器设置编码
     */
    System.out.println("表现层！product showall!!!!");
    /**
     * 获取参数
     */
    /**
     * 调用业务层代码，封装json数据
     */
    JSONArray jsonArray =new JSONArray();
    List<JSONObject> objects = productService.findAll();
    jsonArray.addAll(objects);
    System.out.println(jsonArray);
    /**
     * 返回json数组
     */
    response.getWriter().write(String.valueOf(jsonArray));
    jsonArray.clear();

  }

  @RequestMapping("/show1")
  public void show1(HttpServletResponse response, HttpServletRequest request) throws Exception {
    /**
     * 设置格式编码等
     * 已开启过滤器设置编码
     */
    System.out.println("表现层！product show1!!!!");
    /**
     * 获取参数
     */
    int limit = Integer.parseInt(request.getParameter("limit"));
    int page = Integer.parseInt(request.getParameter("page"));
    /**
     * 调用业务层代码，封装json数据
     */
    JSONArray jsonArray =new JSONArray();
    List<JSONObject> objects = productService.findAllLimit(((page - 1) * limit),limit);
    jsonArray.addAll(objects);
    System.out.println(jsonArray);
    /**
     * 返回json数组
     */
    response.getWriter().write(String.valueOf(jsonArray));
    jsonArray.clear();

  }
  @RequestMapping("/getTotal")
  public void getTotal(HttpServletResponse response) throws Exception {
    Integer total = productService.getTotal();
    response.getWriter().print(total);

  }

}
