package cn.zxh.dao;

import cn.zxh.domain.Medicine;
import cn.zxh.domain.User;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao  {
    /**
     * 抽象方法多个参数时需要使用@Param注解表示映射
     * @param page
     * @param limit
     * @return
     */
    @ResultType(com.alibaba.fastjson.JSONObject.class)
    @Select("select * from user limit #{page},#{limit}")
    public List<JSONObject> findAllLimit(@Param("page") int page, @Param("limit") int limit);

    @Select("select * from user")
    public List<User> findAll();

    @Select("select * from user")
    public List<JSONObject> findAllbyJSON();

    @ResultType(com.alibaba.fastjson.JSONObject.class)
    @Select("select * from user")
    public List<JSONObject> selectOneTable();

    @Select("select * from user where id =#{id}")
    public JSONObject findOneById(Integer id);

    @Insert("insert into user(username,password,sex,city) values(#{username},#{password},#{sex},#{city}) ")
    public void saveUser(User user);

    @Delete("delete from user where id = #{id}")
    public void deleteUser(Integer id);

    @Update(" update  user  SET username=#{user.username},password=#{user.password},sex=#{user.sex},city=#{user.city}where id=#{id}")
    public void updateUser(@Param("id") Integer id, @Param("user") User user);

    @Select("select * from user where username = #{username}")
    public User findByName(String username);

    @Insert("insert into user(username,password,sex,city) values(#{user.username},#{user.password},#{user.sex},#{user.city})")
    public void newUser(@Param("user") User user);

}
