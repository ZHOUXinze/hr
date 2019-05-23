package com.manage.hr.controller;

import com.manage.hr.entity.*;
import com.manage.hr.service.ArchiveService;
import com.manage.hr.service.DictionaryService;
import com.manage.hr.util.ArchiveTools;
import com.manage.hr.util.LoadDataBase;
import com.manage.hr.util.PageSurport;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ArchiveController {
    @Resource
    private DictionaryService dictionaryService;
    @Resource
    private ArchiveService archiveService;
    @Value("${web.upload-path}")
    private String fileUpload;





    //处理变更复核

    @RequestMapping(value = "/doCheckChangeArchive",method = RequestMethod.POST)
    public  String doCheckChangeArchive(Archive archive,Model model){
        int rel=archiveService.updateArchive(archive);
        if(rel>0){
            return "redirect:/registerList";//进入列表页面
        }else {
            model.addAttribute("error","变更复核失败！！！");
            return "renshidanganbiangengfuhe";
        }

    }
    //显示变更复核的页面
    @RequestMapping(value = "/checkChangeArchive",method = RequestMethod.GET)
    public  String checkChangeArchive(@RequestParam int id,Model model){

        Archive archive=archiveService.findArchiveById(id);
        init(model);
        model.addAttribute("archive",archive);

        return "renshidanganbiangengfuhe";
    }

    @RequestMapping(value = "/doCheckArchive",method = RequestMethod.POST)
    public  String doCheckArchive(Archive archive,Model model){
        int rel=archiveService.updateArchive(archive);
        if(rel>0){
            return "redirect:/registerList";//进入列表页面
        }else {
            model.addAttribute("error","复核失败！！！");
            return "renshidanganfuhe";
        }

    }
    //显示复核的页面
    @RequestMapping(value = "/checkArchive",method = RequestMethod.GET)
    public  String checkArchive(@RequestParam int id,Model model){


        Archive archive=archiveService.findArchiveById(id);
        init(model);
        model.addAttribute("archive",archive);

        return "renshidanganfuhe";
    }

    //处理变更
    @RequestMapping(value = "/doChangeArchive",method = RequestMethod.POST)
    public  String doChangeArchive(Archive archive,Model model){
        int rel=archiveService.updateArchive(archive);
        if(rel>0){
            return "redirect:/registerList";//进入列表页面
        }else {
            model.addAttribute("error","变更失败！！！");
            return "renshidanganbiangeng";
        }

    }
    //显示变更的页面
    @RequestMapping(value = "/changeArchive",method = RequestMethod.GET)
    public  String changeArchive(@RequestParam int id,Model model){

        Archive archive=archiveService.findArchiveById(id);
        init(model);
        model.addAttribute("archive",archive);

        return "renshidanganbiangeng";
    }

    //处理单纯修改
    @RequestMapping(value = "/doModifyArchive",method = RequestMethod.POST)
    public  String doModifyArchive(Archive archive,@RequestParam(value = "docFile",required = false) MultipartFile docFile,Model model){
        String path=fileUpload;
        String docName=null;
        MultipartFile doc=docFile;
        if(!doc.isEmpty()){
            docName=doc.getOriginalFilename();
            /*  path=path+"/doc/";*/
            File docfile =new File(path+"/"+docName);
            if(!docfile.getParentFile().exists()){
                docfile.getParentFile().mkdirs();
            }
            try{
                doc.transferTo(docfile);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }

        /*archive.setAnnex("doc/"+docName);*/
        archive.setAnnex(docName);
        int rel=archiveService.updateArchive(archive);
        if(rel>0){
            return "redirect:/registerList";//进入列表页面
        }else {
            model.addAttribute("error","修改失败！！！");
            return "renshidanganxiugai";
        }
    }
    //显示修改的页面
    @RequestMapping(value = "/modifyArchive",method = RequestMethod.GET)
    public  String modifyArchive(@RequestParam int id,Model model){


        Archive archive=archiveService.findArchiveById(id);
        init(model);
        model.addAttribute("archive",archive);

        return "renshidanganxiugai";
    }

    //处理添加页面
    @RequestMapping(value = "/addArchive",method = RequestMethod.POST)
    public String doAddArchive(Archive archive, Model model, @RequestParam(value = "photos",required = true) MultipartFile photos,@RequestParam(value = "docFile",required = true) MultipartFile docFile,HttpSession session){
        String path=fileUpload;
        String photoName=null;
        String docName=null;
        MultipartFile photo=photos;
        MultipartFile doc=docFile;

        if(!photo.isEmpty()){
            photoName=photo.getOriginalFilename();
            File photofile =new File(path+"/"+photoName);
            if(!photofile.getParentFile().exists()){
                photofile.getParentFile().mkdirs();
            }
            try{
                photo.transferTo(photofile);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        if(!doc.isEmpty()){
            docName=doc.getOriginalFilename();
            /*path=path+"/doc/";*/
            File docfile =new File(path+"/"+docName);
            if(!docfile.getParentFile().exists()){
                docfile.getParentFile().mkdirs();
            }
            try{
                doc.transferTo(docfile);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        Integer i=null;
        if(archiveService.findMaxId()==null){
            i=0;
        }else{
            i=archiveService.findMaxId();
        }
        /* archive.setReviewStatus(7);*/
        archive.setChangeStatus(0);
        archive.setArchCode("BDQN"+(i+1));
        archive.setPhotoPath(photoName);
        archive.setAnnex("doc/"+docName);
        int rel= archiveService.addArchive(archive);
        if(rel>0){
            return "redirect:/registerList";
        }else{
            model.addAttribute("error","添加失败！");
            return "register";
        }

    }
    //显示登记页面
    @RequestMapping(value = "/addArchive",method = RequestMethod.GET)
    public String addArchive(Model model){
        init(model);

        return "/register";
    }

    //显示登记列表
    @RequestMapping("/registerList")
    public String show(ArchiveTools archiveTools,@RequestParam(required=false) Integer pageIndex,HttpSession session,Model model){
     /*   User user =new User();
        user.setUserRoleName("人事经理");*/

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


        PageSurport<Archive> pageSurport=archiveService.findArchiveList(archiveTools, curIndex, pageSize);
        pageSurport.setPageIndex(curIndex);
        pageSurport.setPageSize(pageSize);
        //向页面传值
        model.addAttribute("pageSurport", pageSurport);
        model.addAttribute("dictionaryList",dictionaryList);
        model.addAttribute("archiveTools",archiveTools);
        /*model.addAttribute("user",user);*/
        return "registerList";
    }

    //显示人事明细
    @RequestMapping("/archiveView")
    public String archiveView(@RequestParam String id,Model model){
        int i=Integer.parseInt(id);

        Archive archive=archiveService.findArchiveById(i);
        init(model);
        model.addAttribute("archive",archive);
        if(archive.getReviewStatus()==6||archive.getReviewStatus()==7||archive.getReviewStatus()==8){
            return "renshidanganmixi";
        }else{
            return "renshidanganbiangengmingxi";
        }

    }
    //联动显示职位编码
    @RequestMapping(value = "/findPosCode",method = RequestMethod.GET)
    @ResponseBody
    public String findPosCode(int id) {
        String str=  archiveService.findPosCode(id);
        return str;
    }
    //永久删除
    @RequestMapping(value = "/deleteReg",method = RequestMethod.GET)
    @ResponseBody
    public String delRegister(int id) {
        int rel=  archiveService.deleteArchive(id);
        if(rel>0){
            return "true";
        }else {
            return "false";
        }

    }
    //假删除
    @RequestMapping("/delReg")
    public String delReg(int id) {
        int rel = archiveService.delUpdateArchiveStatus(id);
        if (rel > 0) {
            return "redirect:/registerList";
        }else{
            return "redirect:/registerList";
        }
    }
    //恢复档案
    @RequestMapping("/recoverReg")
    @ResponseBody
    public String recoverReg(int id){
        Archive archive=archiveService.findArchiveById(id);
        int isdelete= archive.getArchStatus();
        int rel =archiveService.recoverReg(id,isdelete);
        if(rel>0){
            return "true";
        }else {
            return "false";
        }
    }
    //删除doc文件服务器端
    @RequestMapping(value = "/delDocFile",method = RequestMethod.GET)
    @ResponseBody
    public Object deleteApk(@RequestParam(value="id",required=false) String id){
        Map<String,Object> map=new HashMap<String,Object>();
        //获得文件路径直接用 fileUpload
        String path=fileUpload;
        Archive archive= archiveService.findArchiveById(Integer.parseInt(id));
        String fileName=archive.getAnnex();
        if(id==null&&("").equals(id)){
            map.put("result","failed");
        }else{
            File file=new File(path+"/"+fileName);
            if(file.getParentFile().exists()){
                if(file.delete()){
                    if(archiveService.deleteAnnex(Integer.parseInt(id))>0){
                        map.put("rst","success");
                    }else {
                        map.put("rst","noexist");
                    }
                }
            }else{
                map.put("rst","noexist");
            }
        }
        return map;
    }
    public void  init(Model model){
        LoadDataBase.loadDictionary();
        LoadDataBase.loadDepartment();
        LoadDataBase.loadPosition();
        LoadDataBase.loadTitle();
        List<Dictionary> dictionaryList = LoadDataBase.DATA_BASE.get("dictionary");
        List<Department> departmentList = LoadDataBase.DATA_BASE.get("department");
        List<Position> positionList = LoadDataBase.DATA_BASE.get("position");
        List<Title> titleList = LoadDataBase.DATA_BASE.get("title");
        model.addAttribute("dictionaryList",dictionaryList);
        model.addAttribute("departmentList",departmentList);
        model.addAttribute("positionList",positionList);
        model.addAttribute("titleList",titleList);
    }
}
