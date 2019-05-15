package com.manage.hr.util;

import com.manage.hr.entity.Department;
import com.manage.hr.entity.Dictionary;
import com.manage.hr.service.impl.DictionaryServiceImpl;
import com.manage.hr.service.impl.DepartmentServiceImpl;

import java.util.List;
import java.util.Map;

public class LoadDataBase {
    private DictionaryServiceImpl dataServiceImpl;
    private DepartmentServiceImpl departmentServiceImpl;
    public static Map<String, List> DATA_BASE;

    public void loadDictionary(){
        List<Dictionary> dictionaryList = dataServiceImpl.listDictionary();
        DATA_BASE.put("dictionary",dictionaryList);
    }

    public void loadDepartment(){
        List<Department> departmentList = departmentServiceImpl.listDepartment();
        DATA_BASE.put("department",departmentList);
    }
}
