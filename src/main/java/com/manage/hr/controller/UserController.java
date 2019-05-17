package com.manage.hr.controller;

import com.manage.hr.dao.UserDao;
import com.manage.hr.entity.Department;
import com.manage.hr.entity.Dictionary;
import com.manage.hr.entity.User;
import com.manage.hr.service.DictionaryService;
import com.manage.hr.util.LoadDataBase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private DictionaryService dictionaryService;
   @Resource
   private UserDao userDao;
   //显示新增用户
@RequestMapping(value = "/trainUser",method = RequestMethod.GET)
public String addUser(Model model){
    User user=new User();
    LoadDataBase.loadDictionary();
    LoadDataBase.loadDepartment();
    List<Dictionary> dictionaryList = LoadDataBase.DATA_BASE.get("dictionary");
    List<Department> departmentList = LoadDataBase.DATA_BASE.get("department");
    model.addAttribute("departmentList",departmentList);
    model.addAttribute("dictionaryList",dictionaryList);
    model.addAttribute("user",user);

return "trainUser";
}
//处理新增用户
    @RequestMapping(value = "/trainUser",method = RequestMethod.POST)
    public String addUser(@Valid User user, BindingResult result,  @RequestParam("depId") int depId ,@RequestParam("dictionid") int dictionid,Model model ){
    user.setDepId(depId);
    user.setUserRole(dictionid);
 int rel=   userDao.addUser(user);

        if(rel>0){
            return "redirect:/yonghuguanli";
        }else{
            model.addAttribute("err","添加失败");
            return "trainUser";
        }


    }
    //显示用户管理
    @RequestMapping("/yonghuguanli")
public String findAllUser(Model model){

List<User> userList  =userDao.findAllUser();
model.addAttribute("userList",userList);
return "yonghuguanli";
}

//显示修改页面
    @RequestMapping(value = "yonghuguanlixiugai",method = RequestMethod.GET)
    public String updateUser(@RequestParam int userid,Model model){
    User user=    userDao.findUserByID(userid);
        LoadDataBase.loadDictionary();
        LoadDataBase.loadDepartment();
        List<Dictionary> dictionaryList = LoadDataBase.DATA_BASE.get("dictionary");
        List<Department> departmentList = LoadDataBase.DATA_BASE.get("department");
        model.addAttribute("departmentList",departmentList);
        model.addAttribute("dictionaryList",dictionaryList);
        model.addAttribute("user",user);
   return "yonghuguanlixiugai";
    }
//处理修改页面
    @RequestMapping(value = "yonghuguanlixiugai",method = RequestMethod.POST)
    public String updateUser(@Valid User user, BindingResult result,  @RequestParam("depId") int depId ,
                             @RequestParam("dictionid") int dictionid,Model model){
    //user.setId(Integer.parseInt(userid));
      user.setDepId(depId);
        user.setUserRole(dictionid);
        int rel=   userDao.updateUser(user);

        if(rel>0){
            return "redirect:/yonghuguanli";
        }else{
            model.addAttribute("err","添加失败");
            return "yonghuguanlixiugai";
        }


    }

    @RequestMapping(value = "yonghuguanlimingxi",method = RequestMethod.GET)
    public String Usermingxi(@RequestParam int userid,Model model){
        User user=    userDao.findUserByID(userid);
        LoadDataBase.loadDictionary();
        LoadDataBase.loadDepartment();
        List<Dictionary> dictionaryList = LoadDataBase.DATA_BASE.get("dictionary");
        List<Department> departmentList = LoadDataBase.DATA_BASE.get("department");
        model.addAttribute("departmentList",departmentList);
        model.addAttribute("dictionaryList",dictionaryList);
        model.addAttribute("user",user);
        return "yonghuguanlimingxi";
    }
}
