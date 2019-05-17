package com.manage.hr.controller;

import com.manage.hr.dao.UserDao;
import com.manage.hr.entity.Department;
import com.manage.hr.entity.Dictionary;
import com.manage.hr.service.DepartmentService;
import com.manage.hr.service.DictionaryService;
import com.manage.hr.util.LoadDataBase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.jws.WebParam;
import java.util.List;

@Controller
public class DepartmentController {
    @Resource
    private DictionaryService dictionaryService;
    @Resource
    private UserDao userDao;
    @Resource
    private DepartmentService departmentService;
  @RequestMapping(value = "org" ,method = RequestMethod.GET)
    public String departmentByID(Model model){
      Department department=new Department();
      LoadDataBase.loadDictionary();
      LoadDataBase.loadDepartment();
      List<Dictionary> dictionaryList = LoadDataBase.DATA_BASE.get("dictionary");
      List<Department> departmentList = LoadDataBase.DATA_BASE.get("department");
      model.addAttribute("departmentList",departmentList);
      model.addAttribute("dictionaryList",dictionaryList);
      model.addAttribute("department",department);
        return "org";
    }
    //添加
    @RequestMapping(value = "orgadd",method = RequestMethod.GET)
    public  String orgAdd(Model model, Department department, @RequestParam String depNames){
        LoadDataBase.loadDictionary();

        List<Dictionary> dictionaryList = LoadDataBase.DATA_BASE.get("dictionary");

        model.addAttribute("dictionaryList",dictionaryList);
      model.addAttribute("depNames",depNames);
      Department department1=new Department();
model.addAttribute("department1",department1);
return "orgadd";
    }
}
