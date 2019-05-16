package com.manage.hr.controller;

import com.manage.hr.entity.Department;
import com.manage.hr.entity.Dictionary;
import com.manage.hr.entity.Position;
import com.manage.hr.entity.Title;
import com.manage.hr.service.DictionaryService;
import com.manage.hr.util.LoadDataBase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class TestController {

    @Resource
    private DictionaryService dictionaryService;

    @RequestMapping(value = "/test")
    public String test(Model model) {

        LoadDataBase.loadDictionary();
        LoadDataBase.loadDepartment();
        LoadDataBase.loadPosition();
        LoadDataBase.loadTitle();


        List<Dictionary> dictionaryList = LoadDataBase.DATA_BASE.get("dictionary");
        List<Department> departmentList = LoadDataBase.DATA_BASE.get("department");
        List<Position> positionList = LoadDataBase.DATA_BASE.get("position");
        List<Title> titleList = LoadDataBase.DATA_BASE.get("title");


        model.addAttribute("name1", dictionaryList.get(0).getDataName());
        model.addAttribute("name2", departmentList.get(0).getDepName());
        model.addAttribute("name3", positionList.get(0).getPosName());
        model.addAttribute("name4", titleList.get(1).getTitleName());

        return "test";
    }

}
