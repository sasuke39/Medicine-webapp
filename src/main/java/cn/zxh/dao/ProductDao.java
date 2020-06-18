package cn.zxh.dao;

import cn.zxh.domain.Product;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {

    @Insert("insert into product (pro_id, pro_name,pro_type,pro_information,pro_price,pro_img_src) values(#{pro_id}, #{pro_name},#{pro_type},#{pro_information},#{pro_price},#{pro_img_src}) ")
    public void savePro(Product product);
//
//    @Select("select * from product")
//    public List<Product> findAll();

    @Select("select * from product")
    public List<JSONObject> findAll();

    @Select("select count(*) from product ")
    public Integer getTotal();

    @ResultType(com.alibaba.fastjson.JSONObject.class)
    @Select("select * from product limit #{page},#{limit}")
    public List<JSONObject> findAllLimit(@Param("page") int page, @Param("limit") int limit);
}
