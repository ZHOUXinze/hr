package com.manage.hr.controller;

import com.manage.hr.entity.SalaryStandard;
import com.manage.hr.entity.SalaryStandardDetail;
import com.manage.hr.entity.User;
import com.manage.hr.service.SalaryStandardDetailService;
import com.manage.hr.service.SalaryStandardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
public class SalaryStandardController {
    @Resource
    private SalaryStandardDetailService salaryStandardDetailService;
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

    @RequestMapping(value = "/operatingSalaryStandard")
    public String operatingSalaryStandard(int id, Model model, String operating) {
        SalaryStandard salaryStandard = salaryStandardService.getSalaryStandardById(id);
        List<SalaryStandardDetail> salaryStandardDetailList = salaryStandardDetailService.listSalaryStandardDetailByCode(salaryStandard.getStandardCode());
        model.addAttribute("salaryStandard", salaryStandard);
        model.addAttribute("salaryStandardDetailList", salaryStandardDetailList);
        //根据operating跳转页面
        if (operating.equals("review")) {
            return "sidReview";
        } else if (operating.equals("change")) {
            return "sidChange";
        } else if (operating.equals("update")) {
            return "sidUpdate";
        } else if (operating.equals("show")) {
            return "sidShow";
        }
        return "salaryStandard";
    }

    @RequestMapping(value = "/reviewSalaryStandard")
    @ResponseBody
    public String reviewSalaryStandard(int id, String review, String reviewOpinion) {
        int rel = salaryStandardService.reviewSalaryStandard(id, review, reviewOpinion);
        return rel > 0 ? "success" : "error";
    }

    @RequestMapping(value = "/selectSalaryStandard",method = RequestMethod.POST)
    public String selectSalaryStandard(String salaryStandardCode, String statusName, Date start, Date end) {

        return "salaryStandard";
    }

}
