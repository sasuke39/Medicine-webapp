package cn.zxh.service.impl;

import cn.zxh.dao.GoodsDao;
import cn.zxh.domain.Goods;
import cn.zxh.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsDao goodsDao;

    @Override
    public boolean newGoods(Goods goods) {
        return goodsDao.newGoods(goods);
    }
}
