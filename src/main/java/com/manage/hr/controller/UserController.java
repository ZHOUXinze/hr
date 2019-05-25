//package com.manage.hr.controller;
//
//import com.manage.hr.dao.UserDao;
//import com.manage.hr.entity.Archive;
//import com.manage.hr.entity.Department;
//import com.manage.hr.entity.Dictionary;
//import com.manage.hr.entity.User;
//import com.manage.hr.service.ArchiveService;
//import com.manage.hr.service.DepartmentService;
//import com.manage.hr.service.DictionaryService;
//import com.manage.hr.service.UserService;
//import com.manage.hr.util.LoadDataBase;
//import com.manage.hr.util.PageSurport;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpSession;
//import javax.validation.Valid;
//import java.util.List;
//
//@Controller
//public class UserController {
//    @Resource
//    private DictionaryService dictionaryService;
//    @Resource
//    private DepartmentService departmentService;
//   @Resource
//   private UserDao userDao;
//    @Resource
//    private UserService userService;
//    @Resource
//    private ArchiveService archiveService;
//    //获取档案名字
//
//   @RequestMapping(value = "/nameuser" ,method = RequestMethod.POST)
//   @ResponseBody
//    public  String findUserByArchive(@RequestParam (required = false ,value = "uname") String userName){
//   String rel=    archiveService.findArchiveByName(userName);
//      return rel;
//    }
//   //显示新增用户
//@RequestMapping(value = "/trainUser",method = RequestMethod.GET)
//public String addUser(Model model){
//    User user=new User();
//    LoadDataBase.loadDictionary();
//    LoadDataBase.loadDepartment();
//    List<Dictionary> dictionaryList = LoadDataBase.DATA_BASE.get("dictionary");
//    List<Department> departmentList = LoadDataBase.DATA_BASE.get("department");
//    model.addAttribute("departmentList",departmentList);
//    model.addAttribute("dictionaryList",dictionaryList);
//    model.addAttribute("user",user);
//
//return "trainUser";
//}
////处理新增用户
//    @RequestMapping(value = "/trainUser",method = RequestMethod.POST)
//    public String addUser(@Valid User user, BindingResult result,  @RequestParam("depId") Integer depId ,
//                          @RequestParam("dictionid") Integer dictionid,Model model ){
//
//   /*if(result.hasErrors())
//   {
//
//
//       return "redirect:/trainUser";
//   }*/
//
//    user.setDepId(depId);
//    user.setUserRole(dictionid);
// int rel=   userDao.addUser(user);
//
//        if(rel>0){
//            return "redirect:/yonghuguanli";
//        }else{
//            model.addAttribute("err","添加失败");
//            return "trainUser";
//        }
//
//
//    }
///*    //显示用户管理
//    @RequestMapping("/yonghuguanli")
//public String findAllUser(Model model,User user
//            , @RequestParam(required = false) Integer pageIndex  , HttpSession session ){
//       /* @RequestParam(required = false) String userRole, @RequestParam(required = false) String depId   */
//        LoadDataBase.loadDictionary();
//        LoadDataBase.loadDepartment();
//        List<Department> departmentList = LoadDataBase.DATA_BASE.get("department");
//        List<Dictionary> dictionaryList = LoadDataBase.DATA_BASE.get("dictionary");
//int pageSize=3;
//        int curIndex=1;
//        if(pageIndex!=null){
//            curIndex=Integer.valueOf(pageIndex);
//        }
//       /* User user =new User();
//        if(depId!=null &&!depId.equals("") ) {
//            user.setId(Integer.parseInt(depId));
//        }
//        if(userRole!=null && !userRole.equals("")) {
//            user.setUserRole(Integer.parseInt(userRole));
//        }*/
//        PageSurport<User> pageSurport=userService.findAllUser(user, curIndex,pageSize);
//    pageSurport.setPageIndex(curIndex);
//    pageSurport.setPageSize(pageSize);
//    model.addAttribute("pageSurport",pageSurport);
//        model.addAttribute("departmentList",departmentList);
//        model.addAttribute("dictionaryList",dictionaryList);
//    model.addAttribute("user",user);
//
//return "yonghuguanli";
//}*/
//
////显示修改页面
//    @RequestMapping(value = "yonghuguanlixiugai",method = RequestMethod.GET)
//    public String updateUser(@RequestParam int userid,Model model){
//    User user=    userDao.findUserByID(userid);
//        LoadDataBase.loadDictionary();
//        LoadDataBase.loadDepartment();
//        List<Dictionary> dictionaryList = LoadDataBase.DATA_BASE.get("dictionary");
//        List<Department> departmentList = LoadDataBase.DATA_BASE.get("department");
//        model.addAttribute("departmentList",departmentList);
//        model.addAttribute("dictionaryList",dictionaryList);
//        model.addAttribute("user",user);
//   return "yonghuguanlixiugai";
//    }
////处理修改页面
//    @RequestMapping(value = "yonghuguanlixiugai",method = RequestMethod.POST)
//    public String updateUser(@Valid User user, BindingResult result,  @RequestParam("depId") int depId ,
//                             @RequestParam("dictionid") int dictionid,Model model){
//    //user.setId(Integer.parseInt(userid));
//      user.setDepId(depId);
//        user.setUserRole(dictionid);
//        int rel=   userDao.updateUser(user);
//
//        if(rel>0){
//            return "redirect:/yonghuguanli";
//        }else{
//            model.addAttribute("err","修改失败");
//            return "yonghuguanlixiugai";
//        }
//
//
//    }
//
//    @RequestMapping(value = "yonghuguanlimingxi",method = RequestMethod.GET)
//    public String Usermingxi(@RequestParam int userid,Model model){
//        User user=    userDao.findUserByID(userid);
//        LoadDataBase.loadDictionary();
//        LoadDataBase.loadDepartment();
//        List<Dictionary> dictionaryList = LoadDataBase.DATA_BASE.get("dictionary");
//        List<Department> departmentList = LoadDataBase.DATA_BASE.get("department");
//        model.addAttribute("departmentList",departmentList);
//        model.addAttribute("dictionaryList",dictionaryList);
//        model.addAttribute("user",user);
//        return "yonghuguanlimingxi";
//    }
//    @RequestMapping(value = "detUser",method = RequestMethod.GET)
//    public String detUserByID(@RequestParam int userid,Model model ){
//
//int rel=userService.delUserById(userid);
//        if(rel>0){
//            return "redirect:/yonghuguanli";
//        }else{
//            model.addAttribute("err","修改失败");
//            return "yonghuguanli";
//        }
//
//    }
//}
