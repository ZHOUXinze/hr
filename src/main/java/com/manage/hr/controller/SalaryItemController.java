package com.manage.hr.controller;

import com.manage.hr.entity.SalaryItem;
import com.manage.hr.service.SalaryItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class SalaryItemController {
    @Resource
    private SalaryItemService salaryItemService;

    //显示薪资项目
    @RequestMapping(value = "/salaryItem")
    public String showSalaryItem(Model model) {
        List<SalaryItem> salaryItemList = salaryItemService.listSalaryItem();
        model.addAttribute("salaryItemList", salaryItemList);
        return "salaryItem";
    }

    //保存新增和修改
    @RequestMapping(value = "/saveSalaryItem", method = RequestMethod.POST)
    @ResponseBody
    public String saveSalaryItem(@RequestBody List<SalaryItem> salaryItemList) {
        System.out.println(3);
        return salaryItemService.saveSalaryItem(salaryItemList) == 1 ? "success" : "error";
    }

    //删除
    @RequestMapping(value = "/deleteSalaryItem", method = RequestMethod.GET)
    @ResponseBody
    public String updateSalaryItem(int id) {
        return salaryItemService.deleteSalaryItem(id) > 0 ? "success" : "error";
    }
}
