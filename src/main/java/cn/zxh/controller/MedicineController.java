package cn.zxh.controller;

import cn.zxh.domain.Med_Order;
import cn.zxh.domain.Medicine;
import cn.zxh.service.Med_OrderService;
import cn.zxh.service.MedicineService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/Medicine")
public class MedicineController {


    Medicine medicine_in = new Medicine();

    String fileName = null;

    @Autowired
    @Qualifier(value = "MedicineService")
    private MedicineService medicineService;

    @Autowired
    @Qualifier(value = "MedOrderService")
    private Med_OrderService med_orderService;

    @RequestMapping("/up")
    public String findAll(Model model) {

        return "fileup";
    }


    @RequestMapping("/new_pro")
    public String new_pro(){
        return "newMedicine";
    }

    @ResponseBody
    @RequestMapping("/gettypejson")
    public JSONObject gettypejson(@RequestParam(value = "type") String  type){
        JSONObject jsonbytype = new JSONObject();
        List<Medicine> listjson = medicineService.getJSONbyType(type);
        jsonbytype.put(type+"_med_info",listjson);
        return jsonbytype;

    }

    @ResponseBody
    @RequestMapping("/getOrderJson")
    public JSONObject getOrderJson(){
        JSONObject jsonObject = new JSONObject();
        List<Med_Order> med_orderServiceAll = med_orderService.findAll();
        jsonObject.put("code","200");
        jsonObject.put("msg","get successfully!");
        jsonObject.put("med_order",med_orderServiceAll);

        return jsonObject;
    }

    @ResponseBody
    @RequestMapping("/getOrderByUserIdJson")
    public JSONObject getOrderByUserIdJson(String id){
        JSONObject jsonObject = new JSONObject();
        List<Med_Order> med_orderServiceAll = med_orderService.findOrdersByUid(Integer.valueOf(id));
        jsonObject.put("code","200");
        jsonObject.put("msg","get successfully!");
        jsonObject.put("med_order",med_orderServiceAll);

        return jsonObject;
    }


    @ResponseBody
    @RequestMapping("/getMedJson")
    public JSONObject getJson(){
        List<Medicine> medicineList = medicineService.findAll();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("medicine",medicineList);
        jsonObject.put("code",200);
        jsonObject.put("msg","");
        return jsonObject;
    }


    @RequestMapping(value = "/newMedicine", method = RequestMethod.POST)
    public String newMedicine(Medicine medicine, HttpServletRequest request) {

        medicine_in = medicine;
        medicine_in.setImg_url(fileName);
        System.out.println(medicine);
        boolean saveMedicine = medicineService.saveMedicine(medicine_in);

        HttpSession session = request.getSession();

        if (saveMedicine) {
            session.setAttribute("上传成功！", "if_new_Med");
            return "newMedicine";
        } else {
            session.setAttribute("上传失败！", "if_new_Med");
            return "newMedicine";
        }

    }

//处理文件上传

    @ResponseBody //返回json数据
    @RequestMapping(value = "/testUploadimg", method = RequestMethod.POST)
    /**
     * 这里@RequestParam(value = "file")一定加上 value =
     */
    public JSONObject uploadImg(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {


        /**
         * 获取文件名划分出最后一个后缀名
         */
        String lastname="jpg";
        String originalFilename = file.getOriginalFilename();
        String[] strings = originalFilename.split("\\.");
        for (int i = 0;i<strings.length;i++){
            if (i+1==strings.length){
                lastname=strings[i];
            }
        }


        boolean ifname =false;
        while (!ifname) {
            fileName=getUUID();
            if (!medicineService.ifhaveurl(fileName)){
                System.out.println("不重名！");
                ifname =true;
            }
        }

        fileName =fileName+ "."+lastname;
        System.out.println(fileName);

        
        
//        System.out.println("成功进入uploadIMG函数");
        JSONObject jsonObject = new JSONObject();


        if (file.isEmpty()) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "文件为空！");

            return jsonObject;

        }

        try {

            uploadFile(file.getBytes(), "H:/img", fileName);
//            System.out.println(file);
            jsonObject.put("code", 0);
            jsonObject.put("msg", "文件上传成功");

        } catch (Exception e) {

// TODO: handle exception

        }

//返回json

        return jsonObject;

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

    @RequestMapping("/showpro")
    public String show(){
        return "productShow";
    }

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        // 去掉"-"符号
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
        return temp;
    }

    @RequestMapping("/getLimitMedJson")
    public void show1(HttpServletResponse response, HttpServletRequest request) throws Exception {
        /**
         * 设置格式编码等
         * 已开启过滤器设置编码
         */
        System.out.println("表现层！product show1!!!!");
        /**
         * 获取参数
         */
        JSONArray jsonArray =new JSONArray();
        int limit = Integer.parseInt(request.getParameter("limit"));
        int page = Integer.parseInt(request.getParameter("page"));
        /**
         * 调用业务层代码，封装json数据
         */
        List<Medicine> allLimit = medicineService.findAllLimit(((page - 1) * limit), limit);

        System.out.println(allLimit);
        jsonArray.addAll(allLimit);
        /**
         * 返回json数组
         */
        response.getWriter().write(String.valueOf(jsonArray));
        jsonArray.clear();

    }
    @RequestMapping("/getTotal")
    public void getTotal(HttpServletResponse response) throws Exception {
        Integer total = medicineService.getTotal();
        response.getWriter().print(total);
        System.out.println("进入getTotal接口："+total);

    }

    @RequestMapping("/getMedicineByType")
    @ResponseBody
    public JSONObject getMedJson(String type){
        System.out.println(type);
        JSONObject jsonObject = new JSONObject();
        List<Medicine> medicineList = medicineService.findByType(type);
        if (!medicineList.toString().equals("[]")){
            jsonObject.put("code",200);
            jsonObject.put("msg","success");
            jsonObject.put("medicineBeanList",medicineList);
        }else {
            jsonObject.put("code",500);
            jsonObject.put("msg","no medicine with this type!");
        }

        return jsonObject;
    }

    @RequestMapping("/searchMedicine")
    @ResponseBody
    public JSONObject searchMed(String searchWord){
        System.out.println(searchWord);
        JSONObject jsonObject = new JSONObject();
        if (searchWord!=null) {
            List<Medicine> medicines = medicineService.SearchMed(searchWord);
            if (medicines!=null) {
                jsonObject.put("code", 200);
                jsonObject.put("msg", "Search success!");
                jsonObject.put("Medicines", medicines);
                return jsonObject;
            }else {
                jsonObject.put("code", 500);
                jsonObject.put("msg", "Search failed!");
                return jsonObject;
            }
        }else {
            jsonObject.put("code", 501);
            jsonObject.put("msg", "Search failed!");
            return jsonObject;
        }
    }


}