package cn.zxh.service;

import cn.zxh.domain.User;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    public List<JSONObject> findAllLimit(int page, int limit);

    public List<User> findAll();

    public List<JSONObject> findAllJSON();

    public List<JSONObject> selectOneTable();

    public JSONObject findOneById(Integer id);

    public void saveUser(User user);

    public int deleteUser(Integer id);

    public int updateUser(Integer id, User user);

    public User findByName(String username);

    public void newUser(@Param("user") User user);
}
