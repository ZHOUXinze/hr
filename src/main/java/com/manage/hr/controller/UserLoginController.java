package com.manage.hr.controller;

import com.manage.hr.dao.UserDao;
import com.manage.hr.entity.Department;
import com.manage.hr.entity.Dictionary;
import com.manage.hr.entity.User;
import com.manage.hr.service.DepartmentService;
import com.manage.hr.service.DictionaryService;
import com.manage.hr.service.UserService;
import com.manage.hr.util.Constrans;
import com.manage.hr.util.LoadDataBase;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserLoginController {
    @Resource
    private UserService userService;
    @Resource
    private DictionaryService dictionaryService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private UserDao userDao;

    //显示职员登录
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public  String userLogin(){
        return "login";
    }
    //处理职员登录
    @RequestMapping(value = "login" ,method = RequestMethod.POST)
    public  String userLogin(@RequestParam String userCode, @RequestParam String password,
                             HttpSession session, Model model){

        User userSession=new User();
        int rel=userService.login(userCode,password,userSession);
if(rel==-1){
    model.addAttribute("error","用户名错误");
    return "login";

}
if(rel==0){
            model.addAttribute("error","密码错误");
            return "login";
        }
   session.setAttribute(Constrans.USERSESSION,userSession);
return "redirect:main";
    }

    //显示主页
  @RequestMapping("/main")
    public   String main( Model model ){
        LoadDataBase.loadDictionary();
        LoadDataBase.loadDepartment();
        List<Dictionary> dictionaryList = LoadDataBase.DATA_BASE.get("dictionary");
        List<Department> departmentList = LoadDataBase.DATA_BASE.get("department");
        model.addAttribute("departmentList",departmentList);
        model.addAttribute("dictionaryList",dictionaryList);

        return "main";
    }
    //退出功能
    @RequestMapping("/tuichu")
    public  String userOut(HttpSession session){
    session.invalidate();
        return "redirect:login";
    }

}
