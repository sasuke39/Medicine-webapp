package cn.zxh.dao;

import cn.zxh.domain.Med_Order;
import cn.zxh.domain.Med_User;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Med_UserDao {

    @Select("select * from meduser where phoneNumber = #{phoneNumber} and password = #{password}")
    public Med_User login(@Param("phoneNumber") String phoneNumber, @Param("password") String password);

    @Insert("insert into meduser(username,phoneNumber,password) values(#{name},#{phone},#{pwd})")
    public Boolean register(@Param("name") String name, @Param("phone") String phone, @Param("pwd") String pwd);

    @Select("select * from meduser where id=#{id}")
    public JSONObject findOneById(Integer id);

    @Select("select * from meduser ")
    public List<JSONObject> findAllByJson();

    @Delete("delete from meduser where id = #{id}")
    public int deleteById(Integer id);

    @Select("select * from meduser limit #{page},#{limit}")
    public List<Med_User> findAllLimit(@Param("page") int page, @Param("limit") int limit);

    @Insert("insert into meduser(username,phoneNumber,password,sex,headimg_url,createTime) values(#{user.username},#{user.phoneNumber},#{user.password},#{user.sex},#{user.headImage_url},#{user.createTime})")
//    @Options(useGeneratedKeys=true, keyProperty="user.id", keyColumn="id")
    public Boolean newMedUser(@Param("user") Med_User user);

    @Select("select id from meduser where username = #{username}")
    public Integer findByName(String username);

    @Update(" update  meduser  SET username=#{user.username},password=#{user.password},sex=#{user.sex},user_icon=#{user.user_icon} where id=#{user.id}")
    public Boolean updateUser(@Param("user") Med_User user);

    @Select("select * from meduser where id = #{id}")
    @Results(id = "ordersByUserId", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "med_orders", column = "id", many = @Many(select = "cn.zxh.dao.Med_OrderDao.findOrdersByUid",
                    fetchType = FetchType.LAZY))
    })
    public Med_User findUsersOrdersByid(Integer id);

    @Select("select count(*) from meduser where user_icon = #{filename}")
    public int ifExistIconUrl(String filename);

    @Select("select * from meduser where id=#{id}")
    public Med_User findOneUserById(Integer id);

    @Select("select phoneNumber from meduser where phoneNumber = #{phone}")
    public String findByPhone(String phone);
}
