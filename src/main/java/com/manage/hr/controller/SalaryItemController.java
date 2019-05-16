package com.manage.hr.controller;

import com.manage.hr.entity.SalaryItem;
import com.manage.hr.service.SalaryItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class SalaryItemController {
    @Resource
    private SalaryItemService salaryItemService;

    @RequestMapping(value = "/test")
    public String showSalaryItem(Model model){
        List<SalaryItem> salaryItemList = salaryItemService.listSalaryItem();
        model.addAttribute("salaryItemList",salaryItemList);
        return "test";
    }

}
