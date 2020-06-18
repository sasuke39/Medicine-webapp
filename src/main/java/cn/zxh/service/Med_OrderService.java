package cn.zxh.service;

import cn.zxh.domain.Med_Order;
import cn.zxh.domain.SimOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Med_OrderService {

    public List<Med_Order> findAll();

    public List<Med_Order>findOrdersByUid(Integer uid);
    public Integer countbyuseridorder(Integer uid);
    public boolean newUsersOrder(@Param("order") SimOrder order);
}
