package com.manage.hr.controller;

import com.manage.hr.dao.DepartmentDao;
import com.manage.hr.dao.UserDao;
import com.manage.hr.entity.*;
import com.manage.hr.service.DepartmentService;
import com.manage.hr.service.DictionaryService;
import com.manage.hr.util.LoadDataBase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DepartmentController {
    @Resource
    private DictionaryService dictionaryService;
    @Resource
    private UserDao userDao;
    @Resource
    private DepartmentService departmentService;

    //异步显示职位编码
    @RequestMapping(value = "/depNames",method = RequestMethod.POST)
    @ResponseBody
    public Department findDepartmentBydepName( @RequestParam (required = false ,value = "dname") String depName) {



        Department department=      departmentService.findDepartmentBydepName(depName);

        return department;
    }
    //处理修改
    @RequestMapping(value = "org",method = RequestMethod.POST )
    public String departmentByID(Model model,@RequestParam String idDep,Department department,
                                 @RequestParam(required = false) String     enable        ){
        department.setId(Integer.parseInt(idDep));
        department.setEnable(Integer.parseInt(enable));
        if (idDep.equals(0)) {
            department.setHigherOffice(0);
        } else {

            department.setHigherOffice(1);}

        int rel=   departmentService.updateDepartmentByID(department);
        if(rel>0){
            return "redirect:/org";
        }else{
            model.addAttribute("err","修改失败");
            return "org";
        }

    }


    //显示修改
    @RequestMapping(value = "org",method = RequestMethod.GET )
    public String department(Model model ,Department department    ){

        LoadDataBase.loadDictionary();
        LoadDataBase.loadDepartment();
        List<Dictionary> dictionaryList = LoadDataBase.DATA_BASE.get("dictionary");
        List<Department> departmentList = LoadDataBase.DATA_BASE.get("department");
        model.addAttribute("departmentList",departmentList);
        model.addAttribute("dictionaryList",dictionaryList);
        model.addAttribute("department2",department);
        return  "org";

    }
    //显示添加
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
    //处理添加
    @RequestMapping(value = "orgadd",method = RequestMethod.POST)
    public String orgAdd(@Valid Department department, BindingResult result, @RequestParam int enable,Model model){
        department.setHigherOffice(1);
        department.setEnable(enable);
        int rel =departmentService.addDepartment(department);
        if(rel>0){
            LoadDataBase.loadDictionary();
            LoadDataBase.loadPosition();
            LoadDataBase.loadDepartment();
            LoadDataBase.loadTitle();
            List<Dictionary> dictionaryList = LoadDataBase.DATA_BASE.get("dictionary");
            List<Department> departmentList = LoadDataBase.DATA_BASE.get("department");
            List<Position> positionList=LoadDataBase.DATA_BASE.get("position");
            List<Title> titleList=LoadDataBase.DATA_BASE.get("title");
            return "redirect:/org";
        }else{
            model.addAttribute("err","添加失败");
            return "orgadd";
        }

    }
    //删除
    @RequestMapping(value = "orgDet")
    public  String detDepartByID(Model model,@RequestParam int depID){
        int rel=departmentService.detDepartByID(depID);
        if(rel>0){
            return "redirect:/org";
        }else{
            model.addAttribute("err","删除失败");
            return "org";

        }

    }}