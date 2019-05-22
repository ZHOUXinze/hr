package com.manage.hr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class paymentController {

    @RequestMapping(value = "/payment")
    public String showPayment(){
        return "payment";
    }
}
