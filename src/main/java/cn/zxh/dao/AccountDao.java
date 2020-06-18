package cn.zxh.dao;

import cn.zxh.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value="accountDao")
public interface AccountDao {

    @Select("select * from account_sp")
    public List<Account> findAll();
    @Insert("insert into account_sp(name,money) values(#{name},#{money})")
    public void saveAccount(Account account);

}
