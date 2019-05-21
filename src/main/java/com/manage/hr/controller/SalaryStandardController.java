package com.manage.hr.controller;

import com.manage.hr.entity.SalaryItem;
import com.manage.hr.entity.SalaryStandard;
import com.manage.hr.entity.SalaryStandardDetail;
import com.manage.hr.entity.User;
import com.manage.hr.service.SalaryItemService;
import com.manage.hr.service.SalaryStandardDetailService;
import com.manage.hr.service.SalaryStandardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class SalaryStandardController {
    @Resource
    private SalaryStandardDetailService salaryStandardDetailService;
    @Resource
    private SalaryStandardService salaryStandardService;
    @Resource
    private SalaryItemService salaryItemService;

    @RequestMapping(value = "/salaryStandard")
    public String showSalaryStandardList(Model model, HttpSession session) {
        User user = new User();
        user.setUserRoleName("薪酬经理");
        user.setUserName("张3");
        List<SalaryStandard> salaryStandardList = salaryStandardService.listSalaryStandard();
        model.addAttribute("salaryStandardList", salaryStandardList);
        session.setAttribute("user", user);
        return "salaryStandard";
    }

    @RequestMapping(value = "/operatingSalaryStandard")
    public String operatingSalaryStandard(int id, Model model, String operating) {
        if (id == 0) {
            List<SalaryItem> salaryItemList = salaryItemService.listSalaryItem();
            model.addAttribute("salaryItemList", salaryItemList);
            return "sidInsert";
        }
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
        } else if (operating.equals("delete")) {
            salaryStandardService.deleteSalaryStandard(id);
            return "salaryStandard";
        }
        return "salaryStandard";
    }

    @RequestMapping(value = "/reviewSalaryStandard")
    @ResponseBody
    public String reviewSalaryStandard(int id, String review, String reviewOpinion) {
        int rel = salaryStandardService.reviewSalaryStandard(id, review, reviewOpinion);
        return rel > 0 ? "success" : "error";
    }

    @RequestMapping(value = "/selectSalaryStandard", method = RequestMethod.POST)
    public String selectSalaryStandard(String salaryStandardCode, String statusName, Date start, Date end, Model model) {
        System.out.println(salaryStandardCode + statusName + start + end);
        List<SalaryStandard> salaryStandardList = salaryStandardService.listSalaryStandardByCondition(salaryStandardCode, statusName, start, end);
        model.addAttribute("salaryStandardList", salaryStandardList);
        return "salaryStandard";
    }

    @RequestMapping(value = "/updateSalaryStandard", method = RequestMethod.POST)
    @ResponseBody
    public String updateSalaryStandard(SalaryStandard salaryStandard) {
        //修改
        int type = 1;
        return salaryStandardService.updateSalaryStandard(salaryStandard, type) > 0 ? "success" : "error";
    }

    @RequestMapping(value = "/saveSalaryStandard", method = RequestMethod.POST)
    @ResponseBody
    public String saveSalaryStandard(SalaryStandard salaryStandard) {
        //保存
        int type = 0;
        return salaryStandardService.updateSalaryStandard(salaryStandard, type) > 0 ? "success" : "error";
    }


    @RequestMapping(value = "/insertSalaryStandard", method = RequestMethod.POST)
    @ResponseBody
    public String insertSalaryStandard(SalaryStandard salaryStandard) {
        //保存
        int type = 0;
        return salaryStandardService.insertSalaryStandard(salaryStandard, type) > 0 ? "success" : "error";
    }

    @RequestMapping(value = "/submitSalaryStandard", method = RequestMethod.POST)
    @ResponseBody
    public String submitSalaryStandard(SalaryStandard salaryStandard) {
        //提交
        int type = 1;
        return salaryStandardService.insertSalaryStandard(salaryStandard, type) > 0 ? "success" : "error";
    }

    @RequestMapping(value = "/insertSalaryStandardDetail", method = RequestMethod.POST)
    @ResponseBody
    public String insertSalaryStandardDetail(@RequestBody List<SalaryStandardDetail> salaryStandardDetails) {
        return salaryStandardDetailService.insertSalaryStandardDetail(salaryStandardDetails) > 0 ? "success" : "error";
    }

    @RequestMapping(value = "/updateSalaryStandardDetail", method = RequestMethod.POST)
    @ResponseBody
    public String updateSalaryStandardDetail(@RequestBody List<SalaryStandardDetail> salaryStandardDetails) {
        return salaryStandardDetailService.updateSalaryStandardDetail(salaryStandardDetails) > 0 ? "success" : "error";
    }


}
