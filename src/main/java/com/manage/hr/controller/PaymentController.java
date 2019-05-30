package com.manage.hr.controller;

import com.manage.hr.entity.*;
import com.manage.hr.service.*;
import com.manage.hr.util.LoadDataBase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Controller
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private ArchiveService archiveService;
    @Resource
    private SalaryStandardDetailService salaryStandardDetailService;
    @Resource
    private PaymentDepService paymentDepService;
    @Resource
    private PayrollService payrollService;


    @RequestMapping(value = "/payment")
    public String showPayment(Model model) {
        //显示payment
        List<Payment> paymentList = paymentService.listPayment();
        for (Payment payment : paymentList) {
            //计算人数
            payment.setPeopleNumber(payrollService.countPayrollByPaymentId(payment.getId()));
            //计算总额

        }
        model.addAttribute("paymentList", paymentList);
        return "payment";
    }


    @RequestMapping(value = "/paymentAdd")
    public String paymentAdd(Model model) {
        BigDecimal sT = BigDecimal.valueOf(0);
        LoadDataBase.loadDepartment();
        List<Department> departmentList = LoadDataBase.DATA_BASE.get("department");
        for (Department department : departmentList) {
            List<Archive> archives = archiveService.listArchiveByDep(department.getId());
            if (department.getHigherOffice() != 0) {
                department.setHigherOfficeName(
                        departmentService.getDepartmentById(department.getHigherOffice()).getDepName());
            }
            department.setpNum(archives.size());
            for (Archive archive : archives) {
                List<SalaryStandardDetail> salaryStandardDetailList = salaryStandardDetailService.listSalaryStandardDetailByCode(archive.getStandardCode());
                for (SalaryStandardDetail salaryStandardDetail : salaryStandardDetailList) {
                    sT = sT.add(salaryStandardDetail.getItemAmount());
                }
            }
            department.setTotalSs(sT);
        }
        Payment payment = new Payment();
        payment.setPaymentCode(paymentService.getNewCode());
        model.addAttribute("payment", payment);
        model.addAttribute("departmentList", departmentList);
        return "paymentAdd";
    }


}

