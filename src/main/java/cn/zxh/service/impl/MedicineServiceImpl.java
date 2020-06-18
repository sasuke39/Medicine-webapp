package cn.zxh.service.impl;

import cn.zxh.dao.MedicineDao;
import cn.zxh.domain.Medicine;
import cn.zxh.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MedicineService")
public class MedicineServiceImpl implements MedicineService {

    @Override
    public List<Medicine> getJSONbyType(String type) {
        return medicineDao.getJSONbyType(type);
    }

    @Autowired
    private MedicineDao medicineDao;


    @Override
    public List<Medicine> findAll() {
        return medicineDao.findAll();
    }

    @Override
    public boolean saveMedicine(Medicine medicine) {
        return medicineDao.saveMedicine(medicine);
    }

    @Override
    public boolean deleteMed(Integer id) {
        return false;
    }

    @Override
    public boolean ifhaveurl(String in_url) {

        /**
         * false 表示 没有一样的
         */
        System.out.println("已经判断是否重名！");
        if (medicineDao.ifhaveurl(in_url)==1){
            return true;
        }
        else {
            return false;
        }


    }

    @Override
    public List<Medicine> findAllLimit(int page, int limit) {
        return medicineDao.findAllLimit(page, limit);
    }

    @Override
    public Integer getTotal() {
        return medicineDao.getTotal();
    }

    @Override
    public Medicine findOneById(Integer id) {
        return medicineDao.findOneById(id);
    }


    @Override
    public List<Medicine> findByType(String type) {
        return medicineDao.findByType(type);
    }

    @Override
    public List<Medicine> SearchMed(String searchWord) {
        boolean ByNameFlag =false;
        boolean ByTypeFlag =false;
        List<Medicine>  resultMedicines = null;
        List<Medicine> medicinesByName = medicineDao.SearchByName(searchWord);
//        System.out.println("ByName"+medicinesByName.toString());
        List<Medicine> medicinesByType = medicineDao.findByType(searchWord);
//        System.out.println("ByType"+medicinesByType);

        if (!medicinesByType.toString().equals("[]")){
            ByTypeFlag = true;
        }
        if (!medicinesByName.toString().equals("[]")){
            ByNameFlag= true;
        }
        if (ByNameFlag&&ByTypeFlag) {
            for (Medicine medicine : medicinesByName) {
                medicinesByType.removeIf(medicine1 -> medicine1.equals(medicine));
            }
            medicinesByName.addAll(medicinesByType);
            return medicinesByName;
        }else if (ByNameFlag){
            return medicinesByName;
        }else if (ByTypeFlag){
            return medicinesByType;
        }else return null;


    }
}

