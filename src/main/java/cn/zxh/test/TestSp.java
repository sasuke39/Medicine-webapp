package cn.zxh.test;

import cn.zxh.service.ProductService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSp {

    @Test
    public void run(){
//        //加载配置文件
//        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        ProductService as = (ProductService) ac.getBean("ProductService");
////        as.findAllLimit(1,1);
////        User user =new User();
////        user.setCity("成都");
////        user.setPassword("1561616");
////        user.setUsername("zzzz");
////        user.setSex("女");
////        System.out.println(as.updateUser(31,user));
////        Product product = new Product();
////        product.setPro_name("iphone");
////        product.setPro_type("elc");
////        product.setPro_information("It's expensive!");
////        product.setPro_price(5200.00);
////        product.setPro_img_src("/layui/images/product/one.png");
////        as.savePro(product);
//        System.out.println( as.getTotal());

        int m = 5;
        int n = 1;
        for (int i=m;i>=1;i--){
            n *=i;
        }
        System.out.println(n);

    }

}
