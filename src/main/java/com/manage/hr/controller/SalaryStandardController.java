package com.manage.hr.controller;

import com.manage.hr.entity.SalaryStandard;
import com.manage.hr.entity.User;
import com.manage.hr.service.SalaryStandardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class SalaryStandardController {
    @Resource
    private SalaryStandardService salaryStandardService;

    @RequestMapping(value = "/showSalaryStandardList")
    public String showSalaryStandardList(Model model) {
        User user = new User();
        user.setUserRoleName("薪酬经理");
        List<SalaryStandard> salaryStandardList = salaryStandardService.listSalaryStandard();
        model.addAttribute("salaryStandardList", salaryStandardList);
        model.addAttribute("user", user);
        return "salaryStandard";
    }

    @RequestMapping(value = "/showSalaryStandard")
    public String showSalaryStandard(int id, Model model) {
        model.addAttribute("salaryStandard", salaryStandardService.getSalaryStandardById(id));
        return "salaryStandardDetail";
    }


}
