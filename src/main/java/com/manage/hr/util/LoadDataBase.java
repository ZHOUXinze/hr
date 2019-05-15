package com.manage.hr.util;

import com.manage.hr.entity.Department;
import com.manage.hr.entity.Dictionary;
import com.manage.hr.service.DepartmentService;
import com.manage.hr.service.DictionaryService;
import com.manage.hr.service.impl.DictionaryServiceImpl;
import com.manage.hr.service.impl.DepartmentServiceImpl;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoadDataBase {
    //    public static class LoadDatabaseHolder {
//        private static final LoadDatabase INSTANCE = new LoadDatabase();
//    }
//
//    private LoadDatabase() {}
//
//    public static final LoadDatabase getInstance() {
//        return LoadDatabaseHolder.INSTANCE;
//    }
    @Resource
    private static DictionaryService dictionaryService;
    @Resource
    private static DepartmentService departmentService;

    public static Map<String, List> DATA_BASE = new HashMap<>();

    public static void loadDictionary() {
        List<Dictionary> dictionaryList = dictionaryService.listDictionary();
        System.out.println(2);
        DATA_BASE.put("dictionary", dictionaryList);
    }

    public static void loadDepartment() {
        List<Department> departmentList = departmentService.listDepartment();
        System.out.println(departmentList.get(0));
        DATA_BASE.put("department", departmentList);
    }
}


