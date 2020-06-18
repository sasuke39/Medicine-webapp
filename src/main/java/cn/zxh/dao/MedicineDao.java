package cn.zxh.dao;

import cn.zxh.domain.Medicine;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value="MedicineDao")
public interface MedicineDao {

    @Select("select * from medicine_pro")
    public List<Medicine> findAll();
    @Insert("insert into medicine_pro(product_name,img_url,details,cover_price,type) values(#{product_name},#{img_url},#{details},#{cover_price},#{type})")
    public boolean saveMedicine(Medicine medicine);
    @Delete("delete from medicine_pro where id=#{id}")
    public boolean deleteMed(Integer id);

    @Select("select  count(*) from medicine_pro where img_url = #{in_url}")
    public int ifhaveurl(String in_url);

    @Select("select count(*) from medicine_pro ")
    public Integer getTotal();

    @Select("select * from medicine_pro where type = #{type}")
    public List<Medicine> getJSONbyType(String type);

    @Select("select * from medicine_pro where id = #{id}")
    public Medicine findOneById(Integer id);

    @Select("select * from medicine_pro limit #{page},#{limit}")
    public List<Medicine> findAllLimit(@Param("page") int page, @Param("limit") int limit);

    @Select("select * from medicine_pro where type = #{type}")
    public List<Medicine> findByType(String  type);

    @Select("select * from medicine_pro where product_name like '%${value}%'")
    public List<Medicine> SearchByName(String proName);


}
