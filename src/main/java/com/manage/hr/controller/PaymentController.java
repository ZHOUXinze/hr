package com.manage.hr.controller;

import com.manage.hr.entity.Department;
import com.manage.hr.entity.Payment;
import com.manage.hr.service.DepartmentService;
import com.manage.hr.service.PaymentService;
import com.manage.hr.util.LoadDataBase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class PaymentController {

    @Resource
    PaymentService paymentService;
    @Resource
    DepartmentService departmentService;

    @RequestMapping(value = "/payment")
    public String showPayment(Model model) {
        LoadDataBase.loadDepartment();
        List<Department> departmentList = LoadDataBase.DATA_BASE.get("department");
        for (Department department : departmentList) {
            if (department.getHigherOffice() != 0) {
                department.setHigherOfficeName(
                        departmentService.getDepartmentById(department.getHigherOffice()).getDepName());
            }
        }
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
