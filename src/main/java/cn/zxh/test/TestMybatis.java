package cn.zxh.test;

import cn.zxh.dao.AccountDao;
import cn.zxh.domain.Account;
import cn.zxh.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    /**
     *
     * @throws Exception
     */
//    @Test
//    public void run1() throws Exception {
//        //加载配置文件
//        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//        //创建SqlSessionFactory 对象
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//        //创建sqlSession对象
//        SqlSession session = factory.openSession();
//        //获取代理对象
//        AccountDao dao = session.getMapper(AccountDao.class);
//        //查询所有数据
//        List<Account> list = dao.findAll();
//        for (Account account : list) {
//            System.out.println(account);
//        }
//        session.close();
//        inputStream.close();
//    }
    @Test
    public void run() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AccountService as = (AccountService) ac.getBean("accountService");
        SqlSessionFactory sf = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
        SqlSession session = sf.openSession();
        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        ac.getBean("accountService");
        //查询所有数据
        List<Account> list = dao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
        session.close();
//        inputStream.close();
    }

    @Test
    public void save() throws Exception {
        //加载配置文件
        Account account = new Account();
        account.setName("cn/zxh");
        account.setMoney(9000f);
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建SqlSessionFactory 对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //创建sqlSession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //保存对象
        dao.saveAccount(account);
        //提交事务
        session.commit();
        session.close();
        inputStream.close();
    }
}

