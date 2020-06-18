package cn.zxh.dao;

import cn.zxh.domain.Med_Order;
import cn.zxh.domain.SimOrder;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface Med_OrderDao {
    @Select("select * from medicine_order")
    @Results(id = "orderMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "goodsid",property = "goodsid"),
            @Result(property = "med_user", column = "uid", one = @One(select = "cn.zxh.dao.Med_UserDao.findOneById",
                    fetchType = FetchType.LAZY)),
            @Result(property = "medicine", column = "goodsid", one = @One(select = "cn.zxh.dao.MedicineDao.findOneById",
                    fetchType = FetchType.LAZY))

    })
    public List<Med_Order> findAll();

    @Select("select * from medicine_order where uid = #{uid}")
    @Results(id = "ordersByUserMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "sid",property = "sid"),
            @Result(property = "medicine", column = "sid", one = @One(select = "cn.zxh.dao.MedicineDao.findOneById",
                    fetchType = FetchType.LAZY))

    })
    public List<Med_Order>findOrdersByUid(Integer uid);
    @Select(" select count(*) from medicine_order where uid =#{uid} ")
    public Integer countbyuseridorder(Integer uid);

    @Insert("insert into medicine_order (uid,createTime,sid,total,userAddress,goodsNumber)" +
            " values(#{order.UserId},#{order.createTime},#{order.sid},#{order.Total},#{order.UserAddress},#{order.goodsNumber})")
    public boolean newUsersOrder(@Param("order") SimOrder order);

}
