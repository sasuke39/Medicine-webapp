package cn.zxh.service;

import cn.zxh.domain.Goods;
import org.apache.ibatis.annotations.Param;
public interface GoodsService {
    public boolean newGoods(@Param("goods") Goods goods);
}
