package cn.zxh.dao;

import cn.zxh.domain.Goods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface GoodsDao {
    @Insert("insert into medicine_goods (sid,goodName,number,oneprice) values(#{goods.sid},#{goods.goodName},#{goods.number},#{goods.OnePrice})")
    public boolean newGoods(@Param("goods")Goods goods);
}
