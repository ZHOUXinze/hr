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

    @RequestMapping(value = "/salaryItem2")
    public String showSalaryItem(Model model) {
        List<SalaryItem> salaryItemList = salaryItemService.listSalaryItem();
        model.addAttribute("salaryItemList", salaryItemList);
        return "salaryItem2";
    }

    @RequestMapping(value = "/saveSalaryItem", method = RequestMethod.POST)
    @ResponseBody
    public String saveSalaryItem(@RequestBody List<SalaryItem> salaryItemList) {
        return salaryItemService.saveSalaryItem(salaryItemList) == 1 ? "success" : "error";
    }


    @RequestMapping(value = "/deleteSalaryItem", method = RequestMethod.GET)
    @ResponseBody
    public String updateSalaryItem(int id) {
        return salaryItemService.deleteSalaryItem(id) > 0 ? "success" : "error";
    }

}
