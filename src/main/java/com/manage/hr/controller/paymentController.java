package com.manage.hr.controller;

import com.manage.hr.entity.Payment;
import com.manage.hr.service.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class paymentController {

    @Resource
    PaymentService paymentService;

    @RequestMapping(value = "/payment")
    public String showPayment(Model model) {
        model.addAttribute("paymentList", paymentService.listPayment());
        return "payment";
    }

    //保存新增和修改
    @RequestMapping(value = "/savePayment", method = RequestMethod.POST)
    @ResponseBody
    public String saveSalaryItem(@RequestBody List<Payment> paymentList) {
        return paymentService.savePayment(paymentList) > 0 ? "success" : "error";
    }
}
