package cn.zxh.service.impl;

import cn.zxh.dao.Med_OrderDao;
import cn.zxh.domain.Med_Order;
import cn.zxh.domain.SimOrder;
import cn.zxh.service.Med_OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MedOrderService")
public class Med_OrderServiceImpl implements Med_OrderService {

    @Autowired
    private Med_OrderDao med_orderDao;

    @Override
    public List<Med_Order> findAll() {
       return med_orderDao.findAll();
    }

    @Override
    public List<Med_Order> findOrdersByUid(Integer uid) {
        return med_orderDao.findOrdersByUid(uid);
    }

    @Override
    public Integer countbyuseridorder(Integer uid) {
        return med_orderDao.countbyuseridorder(uid);
    }


    @Override
    public boolean newUsersOrder(SimOrder order) {
        return med_orderDao.newUsersOrder(order);
    }
}
