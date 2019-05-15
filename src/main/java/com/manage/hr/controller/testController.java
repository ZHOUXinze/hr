package com.manage.hr.controller;

import com.manage.hr.entity.Department;
import com.manage.hr.entity.Dictionary;
import com.manage.hr.service.DictionaryService;
import com.manage.hr.util.LoadDataBase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class testController {

//    @Resource
//    private DictionaryService dictionaryService;
//
//    @RequestMapping(value = "/test")
//    public String test(Model model) {
////        LoadDataBase.loadDictionary();
////        List<Dictionary> dictionaryList = LoadDataBase.DATA_BASE.get("Dictionary");
//        List<Dictionary> dictionaryList = dictionaryService.listDictionary();
//        Dictionary dictionary = dictionaryList.get(0);
//        model.addAttribute("id", dictionary.getId());
//        return "test";
//    }
    @RequestMapping(value = "/test")
    public String test() {
        return "test";
    }
}
