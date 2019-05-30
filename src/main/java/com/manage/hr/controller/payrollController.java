package com.manage.hr.controller;

import com.manage.hr.entity.Archive;
import com.manage.hr.entity.SalaryItem;
import com.manage.hr.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class payrollController {
    @Resource
    private PayrollService payrollService;
    @Resource
    private SalaryItemService salaryItemService;
    @Resource
    private ArchiveService archiveService;
    @Resource
    private SalaryStandardDetailService salaryStandardDetailService;
    @Resource
    private PaymentService paymentService;

    @RequestMapping(value = "showPayroll")
    public String showPayroll(String paymentCode, int depId, Model model) {

        //显示employee
        List<Archive> archiveList = archiveService.listArchiveByDep(depId);
        List<Archive> newArchList = new ArrayList<>();
        for (Archive archive : archiveList) {
            archive.setSalaryStandardDetailList(salaryStandardDetailService.listSalaryStandardDetailByCode(archive.getStandardCode()));
            System.out.println(salaryStandardDetailService.listSalaryStandardDetailByCode(archive.getStandardCode()).size());
            newArchList.add(archive);
        }
        //显示薪酬项目
        List<SalaryItem> salaryItemList = salaryItemService.listSalaryItem();
        //查询payment
        // model.addAttribute("payment", paymentService.listPaymentByCode(paymentCode));
        model.addAttribute("salaryItemList", salaryItemList);
        model.addAttribute("archiveList", newArchList);
        return "payroll";
    }
}
