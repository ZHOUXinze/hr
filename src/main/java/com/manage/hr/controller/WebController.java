package com.manage.hr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
/*@RequestMapping("/main")
    public String asasaffa(){
        return "register";
    }*/
@RequestMapping("/daibanliebiaomingxi")
public String daibanliebiaomingxi(){
    return "daibanliebiaomingxi";
}
    @RequestMapping("/daibanliebiao")
    public String daibanliebiao(){
        return "daibanliebiao";
    }
    @RequestMapping("/daibanliebiaochuli")
    public String daibanliebiaochuli(){
        return "daibanliebiaochuli";
    }
    @RequestMapping("/danganbiangeng")
    public String danganbiangeng(){
        return "danganbiangeng";
    }
    @RequestMapping("/danganxiugai")
    public String danganxiugai(){
        return "danganxiugai";
    }
    @RequestMapping("/gaimima")
    public String gaimima(){
        return "gaimima";
    }
    @RequestMapping("/renshidanganfuhe")
    public String renshidanganfuhe(){
        return "renshidanganfuhe";
    }
    @RequestMapping("/renshidanganmingxi")
    public String renshidanganmingxi(){
        return "renshidanganmingxi";
    }
    @RequestMapping("/trainCheck")
    public String trainCheck(){
        return "trainCheck";
    }
    @RequestMapping("/trainFeedback")
    public String trainFeedback(){
        return "trainFeedback";
    }
    @RequestMapping("/trainPlan")
    public String trainPlan(){
        return "trainPlan";
    }
    @RequestMapping("/trainPlanOrg")
    public String trainPlanOrg(){
        return "trainPlanOrg";
    }



    @RequestMapping("/xinchou")
    public String xinchou(){
        return "xinchou";
    }
    @RequestMapping("/xinchoufafangguanli")
    public String xinchoufafangguanli(){
        return "xinchoufafangguanli";
    }
    @RequestMapping("/xinzibiaozhunguanlifuhe")
    public String xinzibiaozhunguanlifuhe(){
        return "xinzibiaozhunguanlifuhe";
    }
    @RequestMapping("/xinzibiaozhunguanlibiangeng")
    public String xinzibiaozhunguanlibiangeng(){
        return "xinzibiaozhunguanlibiangeng";
    }
    @RequestMapping("/xinzibiaozhunguanlimingxi")
    public String xinzibiaozhunguanlimingxi(){
        return "xinzibiaozhunguanlimingxi";
    }
    @RequestMapping("/xinzibiaozhunguanlixiugai")
    public String xinzibiaozhunguanlixiugai(){
        return "xinzibiaozhunguanlixiugai";
    }
    @RequestMapping("/xinzidengji")
    public String xinzidengji(){
        return "xinzidengji";
    }







    @RequestMapping("/zhiyuanmingxibiao")
    public String zhiyuanmingxibiao(){
        return "zhiyuanmingxibiao";
    }
}
