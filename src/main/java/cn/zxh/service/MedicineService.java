package cn.zxh.service;

import cn.zxh.domain.Medicine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MedicineService {


    public List<Medicine> findAll();

    public boolean saveMedicine(Medicine medicine);

    public boolean deleteMed(Integer id);

    public boolean ifhaveurl(String in_url);

    public List<Medicine> getJSONbyType(String type);

    public List<Medicine> findAllLimit(@Param("page") int page, @Param("limit") int limit);
    public Integer getTotal();
    public Medicine findOneById(Integer id);
    public List<Medicine> findByType(String  type);

    public List<Medicine> SearchMed(String searchWord);
}
