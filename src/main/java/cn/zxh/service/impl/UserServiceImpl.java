package cn.zxh.service.impl;

import cn.zxh.dao.UserDao;
import cn.zxh.domain.User;
import cn.zxh.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;


    private JSONObject jsonObject;

    @Override
    public List<JSONObject> findAllJSON() {
        return userDao.findAllbyJSON();
    }

    @Override
    public List<User> findAll() {
        List<User> all = userDao.findAll()
                ;
        for (User user : all) {
            System.out.println(user);
        }
        return all;
    }

    @Override
    public List<JSONObject> findAllLimit(int page, int limit) {
        List<JSONObject> allLimit = userDao.findAllLimit(page, limit);

//        for (JSONObject jsonObject : allLimit) {
//            System.out.println(jsonObject);
//        }
        return allLimit;
    }

    @Override
    public List<JSONObject> selectOneTable() {
        List<JSONObject> objects = userDao.selectOneTable();

//        for (JSONObject object : objects) {
//            System.out.println(object);
//        }

        return objects;
    }



    @Override
    public JSONObject findOneById(Integer id) {
        JSONObject object = userDao.findOneById(id);
//        System.out.println(object);
//        if (object==null){
//             jsonObject.put("id",123);
//            return jsonObject;
//
//        }
//        else
        return object;
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public int deleteUser(Integer id) {
        if (userDao.findOneById(id)==null)
        {
            return 0;
        }else
        {
            userDao.deleteUser(id);
            return 1;
        }

    }

    @Override
    public int updateUser(Integer id, User user) {
        if (userDao.findOneById(id)==null){
            return 0;
        }else {
            userDao.updateUser(id,user);
            return 1;
        }
    }

    @Override
    public User findByName(String username) {
        return userDao.findByName(username);
    }

    @Override
    public void newUser(User user) {
        userDao.newUser(user);
    }
}

