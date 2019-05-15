package com.manage.hr.util;

import com.manage.hr.entity.Department;
import com.manage.hr.entity.Dictionary;
import com.manage.hr.service.DepartmentService;
import com.manage.hr.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
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

    @Autowired
    DictionaryService dictionaryServiceAuto;

    private static DictionaryService dictionaryService;  //静态对象

    @PostConstruct
    public void init() {
        dictionaryService = this.dictionaryServiceAuto;  //将注入的对象交给静态对象管理
    }

    public static Map<String, List> DATA_BASE = new HashMap<>();

    public static void loadDictionary() {
        List<Dictionary> dictionaryList = dictionaryService.listDictionary();
        DATA_BASE.put("dictionary", dictionaryList);
    }

}


