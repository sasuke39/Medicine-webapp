package cn.zxh.service;

import cn.zxh.domain.Product;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface ProductService {

    public void savePro(Product product);

    public List<JSONObject> findAll();

    public List<JSONObject> findAllLimit(int page, int limit);

    public Integer getTotal();
}
