package cn.zxh.service;

import cn.zxh.domain.Med_User;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Med_UserService {


    public Med_User login(String phoneNumber, String password);
    public Boolean register(@Param("name") String name, @Param("phone") String phone, @Param("pwd") String pwd);
    public List<JSONObject> findAllByJson();
    public JSONObject findOneById(Integer id);
    public int deleteById(Integer id);
    public List<Med_User> findAllLimit(@Param("page") int page, @Param("limit") int limit);
    public Boolean newMedUser(@Param("user") Med_User user);
    public Integer findByName(String username);
    public Boolean updateUser(@Param("user") Med_User user);
    public int ifExistIconUrl(String filename);
    public Med_User findOneUserById(Integer id);
    public String findByPhone(String phone);

}
