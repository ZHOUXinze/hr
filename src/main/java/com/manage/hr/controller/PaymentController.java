package com.manage.hr.controller;

import com.manage.hr.entity.Archive;
import com.manage.hr.entity.Department;
import com.manage.hr.entity.Payment;
import com.manage.hr.entity.SalaryStandardDetail;
import com.manage.hr.service.ArchiveService;
import com.manage.hr.service.DepartmentService;
import com.manage.hr.service.PaymentService;
import com.manage.hr.service.SalaryStandardDetailService;
import com.manage.hr.util.LoadDataBase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Controller
public class PaymentController {

    @Resource
    PaymentService paymentService;
    @Resource
    DepartmentService departmentService;
    @Resource
    ArchiveService archiveService;
    @Resource
    SalaryStandardDetailService salaryStandardDetailService;

    @RequestMapping(value = "/showPayment")
    public String showPayment(Model model) {
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
                for (SalaryStandardDetail salaryStandardDetail: salaryStandardDetailList){
                     sT = sT.add(salaryStandardDetail.getItemAmount());
                }
            }
            department.setTotalSs(sT);
        }
        //查询所有人数
        model.addAttribute("pNum",archiveService.countAll());
        model.addAttribute("paymentList", paymentService.listPayment());
        model.addAttribute("depList", departmentList);
        return "payment";
    }

    //保存新增和修改
    @RequestMapping(value = "/savePayment", method = RequestMethod.POST)
    @ResponseBody
    public String saveSalaryItem(@RequestBody List<Payment> paymentList) {
        return paymentService.savePayment(paymentList) > 0 ? "success" : "error";
    }

}
