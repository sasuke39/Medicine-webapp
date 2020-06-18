package cn.zxh.controller;

import cn.zxh.dao.AccountDao;
import cn.zxh.domain.Account;
import cn.zxh.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 账户web
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    @Qualifier("accountDao")
    private AccountDao accountDao;

    @RequestMapping("/findAll")
    public String  findAll(Model model){
        System.out.println("表现层！");
        //调用service方法
        List<Account> list = accountService.findAll();
        model.addAttribute("list",list);
        return "list";
    }
    @RequestMapping("/save")
    public void  saveAccount(Account account, HttpServletResponse response, HttpServletRequest request) throws Exception {
        System.out.println("表现层保存方法执行！");
        //调用service方法
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return;
    }


    
}
