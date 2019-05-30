package com.manage.hr.controller;

import com.manage.hr.dao.TitleDao;
import com.manage.hr.entity.Department;
import com.manage.hr.entity.Dictionary;
import com.manage.hr.entity.Position;
import com.manage.hr.entity.Title;
import com.manage.hr.service.DepartmentService;
import com.manage.hr.service.DictionaryService;
import com.manage.hr.service.TitleService;
import com.manage.hr.util.LoadDataBase;
import com.manage.hr.util.PageSurport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class TitleController {
    @Resource
    private DictionaryService dictionaryService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private TitleDao titleDao;
    @Resource
    private TitleService titleService;

    //动态获取职称编码
    @RequestMapping(value = "/codeTitle" ,method = RequestMethod.POST)
    @ResponseBody
    public  String findUserByArchive(@RequestParam (required = false ,value = "uname") String userName){
        String rel=   titleService.findtitleByCode(userName);
        return rel;
    }

    //显示职称列表
    @RequestMapping(value = "/zhichengshezhi")
    public String findAllTitle(@RequestParam(required = false) Integer pageIndex, Model model, Title title) {
        LoadDataBase.loadDictionary();
        LoadDataBase.loadDepartment();
        List<Department> departmentList = LoadDataBase.DATA_BASE.get("department");
        List<Dictionary> dictionaryList = LoadDataBase.DATA_BASE.get("dictionary");
        int pageSize = 3;
        int curIndex = 1;
        if (pageIndex != null) {
            curIndex = Integer.valueOf(pageIndex);
        }
        PageSurport<Title> pageSurport = titleService.findAllTitle(title, curIndex, pageSize);
        pageSurport.setPageIndex(curIndex);
        pageSurport.setPageSize(pageSize);
        model.addAttribute("pageSurport", pageSurport);
        model.addAttribute("departmentList", departmentList);
        model.addAttribute("dictionaryList", dictionaryList);
        model.addAttribute("title", title);

        return "zhichengshezhi";
    }


    //显示新增职称
    @RequestMapping(value = "/trainRanks", method = RequestMethod.GET)
    public String addTitle(Model model) {
        Title title = new Title();
        LoadDataBase.loadDictionary();
        LoadDataBase.loadDepartment();
        List<Dictionary> dictionaryList = LoadDataBase.DATA_BASE.get("dictionary");
        List<Department> departmentList = LoadDataBase.DATA_BASE.get("department");
        model.addAttribute("departmentList", departmentList);
        model.addAttribute("dictionaryList", dictionaryList);
        model.addAttribute("title", title);
        return "trainRanks";
    }

    //处理新增职称
    @RequestMapping(value = "/trainRanks", method = RequestMethod.POST)
    public String addTitle(Model model, Title title, @RequestParam("depId") Integer depId,
                           @RequestParam("enable") Integer enable) {
        title.setDepId(depId);
        title.setEnable(enable);
        int rel = titleDao.addTitle(title);

        if (rel > 0) {
            LoadDataBase.loadDictionary();
            LoadDataBase.loadPosition();
            LoadDataBase.loadDepartment();
            LoadDataBase.loadTitle();
            List<Dictionary> dictionaryList = LoadDataBase.DATA_BASE.get("dictionary");
            List<Department> departmentList = LoadDataBase.DATA_BASE.get("department");
            List<Position> positionList=LoadDataBase.DATA_BASE.get("position");
            List<Title> titleList=LoadDataBase.DATA_BASE.get("title");
            return "redirect:/zhichengshezhi";
        } else {
            model.addAttribute("err", "添加失败");
            return "trainRanks";
        }

    }

    //显示修改页面
    @RequestMapping(value = "/zhichengxiugai", method = RequestMethod.GET)
    public String updateTitle(@RequestParam int titleId, Model model) {
        Title title = titleDao.findTitleByID(titleId);
        model.addAttribute("title", title);
        LoadDataBase.loadDictionary();
        LoadDataBase.loadDepartment();
        List<Dictionary> dictionaryList = LoadDataBase.DATA_BASE.get("dictionary");
        List<Department> departmentList = LoadDataBase.DATA_BASE.get("department");
        model.addAttribute("departmentList", departmentList);
        model.addAttribute("dictionaryList", dictionaryList);
        return "zhichengxiugai";
    }


    //处理修改页面
    @RequestMapping(value = "/zhichengxiugai", method = RequestMethod.POST)
    public String updateTitle(Model model, @RequestParam("enable") int enable, @RequestParam("depId") int depId, Title title) {

        title.setDepId(depId);
        title.setEnable(enable);
        int rel = titleDao.updateTitle(title);
        if (rel > 0) {
            return "redirect:/zhichengshezhi";
        } else {
            model.addAttribute("err", "添加失败");
            return "zhichengxiugai";
        }
    }
//显示明细
    @RequestMapping(value = "zhichengmingxi",method = RequestMethod.GET)
    public String seeUser(@RequestParam() int titleId,Model model){
        Title title = titleDao.findTitleByID(titleId);
        model.addAttribute("title", title);


        return "zhichengmingxi";
    }
//删除
    @RequestMapping(value = "detTitle")
    public  String detTitle(@RequestParam int titleId,Model model){
     int rel=titleService.detTitleByID(titleId);
        if (rel > 0) {
            return "redirect:/zhichengshezhi";
        } else {
            model.addAttribute("err", "删除失败");
            return "zhichengshezhi";
        }

    }
}