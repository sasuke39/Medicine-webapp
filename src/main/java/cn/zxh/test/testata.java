package cn.zxh.test;

import cn.zxh.dao.*;
import cn.zxh.domain.*;
import cn.zxh.service.MedicineService;
import cn.zxh.service.impl.MedicineServiceImpl;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

public class testata {

    @Test
    public void getall(){


        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        AccountService as = (AccountService) ac.getBean("MedicineService");
        SqlSessionFactory sf = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
        SqlSession session = sf.openSession();
        //获取代理对象
//        MedicineDao dao = session.getMapper(MedicineDao.class);
//        ac.getBean("accountService");
//        //查询所有数据
//        List<Medicine> list = dao.getJSONbyType("心脑血管");
//        for (Medicine account : list) {
//            System.out.println(account);
//        }
//        session.close();
////        inputStream.close();
//        Med_UserDao userDao = session.getMapper(Med_UserDao.class);
//        Med_User med_user = userDao.login("111231", "123123..");
//        System.out.println(med_user);
//        session.close();
//        UserDao sessionMapper = session.getMapper(UserDao.class);
//        List<JSONObject> allbyJSON = sessionMapper.findAllbyJSON();
//        List<User> all = sessionMapper.findAll();
//        Object o = JSON.toJSON(all);
//        System.out.println(allbyJSON);
        Med_UserDao mapper = session.getMapper(Med_UserDao.class);
//        SimpleDateFormat sdf1 =new SimpleDateFormat("yyyy-MM-dd" );
//        Date d1= new Date();
//        String str1 = sdf1.format(d1);
//        System.out.println("当前时间通过 yyyy-MM-dd 格式化后的输出: "+str1);
        Med_User user = new Med_User();
//        user.setCreateTime(str1);
//        user.setHeadImage_url("null");
//        user.setPassword("123123..");
//        user.setPhoneNumber("12345678911");
//        user.setSex("男");
//        user.setUsername("111");
//        user.setId(8);
//        System.out.println(user);
//        Boolean aBoolean = mapper.newMedUser(user);
//        Integer byName = mapper.findByName("111");
//        System.out.println(byName);
//        Boolean aBoolean = mapper.updateUser(user);
//        System.out.println(aBoolean);
//        if (mapper.ifExistIconUrl("111.jpg")==0){
//            System.out.println("NOT Exist");
//        }else {
//            System.out.println("Exist!");
//        }
//        Integer flag = mapper.findByName("testone");
//        System.out.println(flag);
        Med_User login = mapper.login("13111112222", "123123aa");
        System.out.println(login);


    }
    @Test
    public void delete(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        AccountService as = (AccountService) ac.getBean("MedicineService");
        SqlSessionFactory sf = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
        SqlSession session = sf.openSession();
        Med_OrderDao mapper = session.getMapper(Med_OrderDao.class);
//        Boolean aBoolean = mapper.deleteById(23);
//        System.out.println(aBoolean);
        List<Med_Order> uid = mapper.findOrdersByUid(5);
        System.out.println(uid.toString().equals("[]"));


    }

    @Test
    public void getorder(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        AccountService as = (AccountService) ac.getBean("MedicineService");
        SqlSessionFactory sf = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
        SqlSession session = sf.openSession();
        Med_OrderDao mapper = session.getMapper(Med_OrderDao.class);
        List<Med_Order> ordersByUid = mapper.findOrdersByUid(1);
        System.out.println(ordersByUid);


    }

    @Test
    public void getMedicineJson(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        AccountService as = (AccountService) ac.getBean("MedicineService");
        SqlSessionFactory sf = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
        SqlSession session = sf.openSession();
        Med_OrderDao mapper = session.getMapper(Med_OrderDao.class);
//        Boolean aBoolean = mapper.deleteById(23);
//        System.out.println(aBoolean);
        List<Med_Order> ordersByUid = mapper.findOrdersByUid(1);
        System.out.println(ordersByUid);

    }
    @Test
    public void newUser(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        AccountService as = (AccountService) ac.getBean("MedicineService");
        SqlSessionFactory sf = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
        SqlSession session = sf.openSession();
        User user = new User();
        user.setUsername("zxh");
        user.setPassword("123123..");
        user.setCity("北京");
        user.setSex("男");
        UserDao mapper = session.getMapper(UserDao.class);
//        User test = mapper.findByName("test");
//        mapper.newUser(user);
    }

    @Test
    public void Goods(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        AccountService as = (AccountService) ac.getBean("MedicineService");
        SqlSessionFactory sf = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
        SqlSession session = sf.openSession();
        Med_OrderDao mapper = session.getMapper(Med_OrderDao.class);
        SimOrder simOrder = new SimOrder();
        simOrder.setCreateTime("test");
        simOrder.setTotal(110.00);
        simOrder.setUserId(1);
        simOrder.setOnePrice(10.00);
        simOrder.setGoodsNumber(11);
        simOrder.setSid(10);
        simOrder.setUserAddress("test address");
        boolean b = mapper.newUsersOrder(simOrder);
        System.out.println(b);
    }

    @Test
    public void Medicine(){

        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        AccountService as = (AccountService) ac.getBean("MedicineService");
        SqlSessionFactory sf = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
        SqlSession session = sf.openSession();
        MedicineDao mapper = session.getMapper(MedicineDao.class);
//        List<Medicine> byType = mapper.findByType("心脑血管");
//        System.out.println(byType);
        List<Medicine> test = mapper.SearchByName("片");
        System.out.println(test);

//        MedicineServiceImpl medicineService = new MedicineServiceImpl();
//        List<Medicine> test = medicineService.findByType("心脑血管");
//        System.out.println(test);
    }


}
