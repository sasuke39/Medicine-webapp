package cn.zxh.service.impl;

import cn.zxh.dao.AccountDao;
import cn.zxh.domain.Account;
import cn.zxh.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    @Qualifier("accountDao")
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("业务层：查询所有成功！");

        List<Account> all = accountDao.findAll();
        return all;
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层：保存账户成功！");
        accountDao.saveAccount(account);

    }
}
