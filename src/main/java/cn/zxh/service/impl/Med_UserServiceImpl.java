package cn.zxh.service.impl;

import cn.zxh.dao.Med_UserDao;
import cn.zxh.domain.Med_User;
import cn.zxh.service.Med_UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MedUserService")
public class Med_UserServiceImpl implements Med_UserService {

    @Autowired
    private Med_UserDao med_userDao;

    @Override
    public Med_User login(String phoneNumber, String password) {
        return med_userDao.login(phoneNumber,password);
    }


    @Override
    public Boolean register(String name, String phone, String pwd) {
       return med_userDao.register(name,phone,pwd);
    }

    @Override
    public List<JSONObject> findAllByJson() {
        return med_userDao.findAllByJson();
    }

    @Override
    public JSONObject findOneById(Integer id) {
        return med_userDao.findOneById(id);
    }

    @Override
    public int deleteById(Integer id) {
        return med_userDao.deleteById(id);
    }

    @Override
    public List<Med_User> findAllLimit(int page, int limit) {
        return med_userDao.findAllLimit(page, limit);
    }

    @Override
    public Boolean newMedUser(Med_User user) {
        return med_userDao.newMedUser(user);
    }

    @Override
    public Integer findByName(String username) {
        return med_userDao.findByName(username);
    }

    @Override
    public Boolean updateUser(Med_User user) {
        return med_userDao.updateUser(user);
    }

    @Override
    public int ifExistIconUrl(String filename) {
        return med_userDao.ifExistIconUrl(filename);
    }

    @Override
    public Med_User findOneUserById(Integer id) {
        return med_userDao.findOneUserById(id);
    }

    @Override
    public String findByPhone(String phone) {
        return med_userDao.findByPhone(phone);
    }
}
