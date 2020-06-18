package cn.zxh.service.impl;

import cn.zxh.dao.ProductDao;
import cn.zxh.domain.Product;
import cn.zxh.service.ProductService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public void savePro(Product product) {

        productDao.savePro(product);

        System.out.println(product+"Success!");

    }

    @Override
    public List<JSONObject> findAll() {

        List<JSONObject> products = productDao.findAll();

        return products;
    }


    @Override
    public List<JSONObject> findAllLimit(int page, int limit) {
        List<JSONObject> allLimit = productDao.findAllLimit(page, limit);
        return allLimit;
    }

    @Override
    public Integer getTotal() {
        Integer total = productDao.getTotal();
        return total;
    }

}
