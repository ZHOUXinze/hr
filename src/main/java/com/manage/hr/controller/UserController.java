package com.manage.hr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {



 @RequestMapping("/xinzidengjii")
   public String aaa(){


     return "xinzidengjii";
 }



}
