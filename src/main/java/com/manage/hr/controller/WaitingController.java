package com.manage.hr.controller;

import com.manage.hr.entity.Archive;
import com.manage.hr.entity.Dictionary;
import com.manage.hr.entity.User;
import com.manage.hr.service.ArchiveService;
import com.manage.hr.util.ArchiveTools;
import com.manage.hr.util.LoadDataBase;
import com.manage.hr.util.PageSurport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class WaitingController {
    @Resource
    private ArchiveService archiveService;

    //显示代办列表
    @RequestMapping("/waitList")
    public String show(ArchiveTools archiveTools,@RequestParam(required=false) Integer pageIndex, HttpSession session, Model model){
        User user =new User();
        user.setUserRoleName("人事专员");
        /* 人事专员    人事经理*/
        LoadDataBase.loadDictionary();
        List<Dictionary> dictionaryList = LoadDataBase.DATA_BASE.get("dictionary");
        //分页
        int pageSize=3;
        //当前页默认为1
        int curIndex=1;
        if(pageIndex!=null){
            curIndex=Integer.valueOf(pageIndex);
        }
        //查询Archive的信息

        PageSurport<Archive> pageSurport=archiveService.findArchiveWaitList(archiveTools, curIndex, pageSize);
        pageSurport.setPageIndex(curIndex);
        pageSurport.setPageSize(pageSize);
        //向页面传值
        model.addAttribute("pageSurport", pageSurport);
        model.addAttribute("dictionaryList",dictionaryList);
        model.addAttribute("archiveTools",archiveTools);
        model.addAttribute("user",user);
        return "daibanliebiao";
    }


}
