package com.manage.hr.util;

import com.manage.hr.entity.Department;
import com.manage.hr.entity.Dictionary;
import com.manage.hr.entity.Position;
import com.manage.hr.entity.Title;
import com.manage.hr.service.DataService;

import java.util.List;
import java.util.Map;

public class LoadDataBase {
    private DataService dataService;
    public static Map<String, List<Dictionary>> DICTIONARY;
    public static Map<String, List<Position>> POSITION;
    public static Map<String, List<Title>> TITILE;
    public static Map<String, List<Department>> DEPARTMENT;

    public void loadDataBase(){
        List<Dictionary> dictionaryList = dataService.listDictionary();
        DICTIONARY.put("dictionary",dictionaryList);
        System.out.println(dictionaryList.get(1).getDateName());
    }
}
