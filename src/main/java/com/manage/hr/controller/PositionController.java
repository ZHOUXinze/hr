package com.manage.hr.controller;

import com.manage.hr.dao.PositionDao;
import com.manage.hr.entity.Department;
import com.manage.hr.entity.Dictionary;
import com.manage.hr.entity.Position;
import com.manage.hr.entity.Title;
import com.manage.hr.service.DepartmentService;
import com.manage.hr.service.DictionaryService;
import com.manage.hr.service.PositionService;
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
public class PositionController {
    @Resource
    private DictionaryService dictionaryService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private PositionDao positionDao;
    @Resource
    private PositionService positionService;
    //显示职位编码
    @RequestMapping(value = "/codePos" ,method = RequestMethod.POST)
    @ResponseBody
    public  String findUserByArchive(@RequestParam (required = false ,value = "uname") String userName){
        String rel=   positionService.findPositByCode(userName);
        return rel;
    }



    //显示职位页面
    @RequestMapping(value = "/zhiweiguanli",method = RequestMethod.GET)
    public String findAllPostion(@RequestParam(required = false) Integer pageIndex, Model model,Position position){
        LoadDataBase.loadDictionary();
        LoadDataBase.loadDepartment();
        List<Department> departmentList = LoadDataBase.DATA_BASE.get("department");
        List<Dictionary> dictionaryList = LoadDataBase.DATA_BASE.get("dictionary");
        int pageSize = 3;
        int curIndex = 1;
        if (pageIndex != null) {
            curIndex = Integer.valueOf(pageIndex);
        }
        PageSurport<Position> pageSurport= positionService.findAllPosition(position,curIndex, pageSize);
        pageSurport.setPageIndex(curIndex);
        pageSurport.setPageSize(pageSize);
        model.addAttribute("pageSurport", pageSurport);
        model.addAttribute("departmentList", departmentList);
        model.addAttribute("dictionaryList", dictionaryList);
        model.addAttribute("position",position);
        return "zhiweiguanli";
    }
    //显示新增职位
    @RequestMapping(value = "/trainPosition",method = RequestMethod.GET)
    public String trainPosition(Model model){
        Position position=new Position();
        LoadDataBase.loadDictionary();
        LoadDataBase.loadDepartment();
        List<Dictionary> dictionaryList = LoadDataBase.DATA_BASE.get("dictionary");
        List<Department> departmentList = LoadDataBase.DATA_BASE.get("department");
        model.addAttribute("departmentList", departmentList);
        model.addAttribute("dictionaryList", dictionaryList);
        model.addAttribute("position",position);
        return "trainPosition";
    }
    //处理新增职位
    @RequestMapping(value = "/trainPosition",method = RequestMethod.POST)
    public String trainPosition(Model model,Position position,@RequestParam("depId") Integer depId,
                                @RequestParam("enable") Integer enable,
                                @RequestParam("posClass") Integer posClass){
        position.setDepId(depId);
        position.setEnable(enable);
        position.setPosClass(posClass);
        int rel=positionDao.addPosition(position);
        if (rel > 0) {
            LoadDataBase.loadDictionary();
            LoadDataBase.loadPosition();
            LoadDataBase.loadDepartment();
            LoadDataBase.loadTitle();
            List<Dictionary> dictionaryList = LoadDataBase.DATA_BASE.get("dictionary");
            List<Department> departmentList = LoadDataBase.DATA_BASE.get("department");
            List<Position> positionList=LoadDataBase.DATA_BASE.get("position");
            List<Title> titleList=LoadDataBase.DATA_BASE.get("title");
            return "redirect:/zhiweiguanli";
        } else {
            model.addAttribute("err", "添加失败");
            return "trainPosition";
        }

    }
    //显示修改页面
    @RequestMapping(value = "/zhiweiguanlixiugai" ,method = RequestMethod.GET)
    public  String updatePosition(Model model,@RequestParam  int positionId){
        Position position =positionService.findPositionByID(positionId);
        model.addAttribute("position",position);
        LoadDataBase.loadDictionary();
        LoadDataBase.loadDepartment();
        List<Dictionary> dictionaryList = LoadDataBase.DATA_BASE.get("dictionary");
        List<Department> departmentList = LoadDataBase.DATA_BASE.get("department");
        model.addAttribute("departmentList", departmentList);
        model.addAttribute("dictionaryList", dictionaryList);
        return "zhiweiguanlixiugai";
    }
    //处理修改页面
    @RequestMapping(value = "/zhiweiguanlixiugai" ,method = RequestMethod.POST)
    public  String updatePosition(Model model,@RequestParam("depId") Integer depId,
                                  @RequestParam("enable") Integer enable,
                                  @RequestParam("posClass") Integer posClass,Position position){
        position.setDepId(depId);
        position.setEnable(enable);
        position.setPosClass(posClass);
        int rel=positionService.updatePosition(position);
        if (rel > 0) {
            return "redirect:/zhiweiguanli";
        } else {
            model.addAttribute("err", "修改失败");
            return "trainPosition";
        }
    }
    //显示明细
    @RequestMapping(value = "/zhiweiguanlimingxi",method = RequestMethod.GET )
    public  String mxPosition(Model model,@RequestParam  int positionId){
        Position position =positionService.findPositionByID(positionId);
        model.addAttribute("position",position);
        LoadDataBase.loadDictionary();
        LoadDataBase.loadDepartment();
        List<Dictionary> dictionaryList = LoadDataBase.DATA_BASE.get("dictionary");
        List<Department> departmentList = LoadDataBase.DATA_BASE.get("department");
        model.addAttribute("departmentList", departmentList);
        model.addAttribute("dictionaryList", dictionaryList);
        return "zhiweiguanlimingxi";
    }
    //删除
    @RequestMapping(value = "detPostion")
    public  String detPositionByID(Model model,@RequestParam int positionId){
int rel=positionService.detPositionByID(positionId);
        if (rel > 0) {
            return "redirect:/zhiweiguanli";
        } else {
            model.addAttribute("err", "删除失败");
            return "zhiweiguanli";
        }
    }
}

