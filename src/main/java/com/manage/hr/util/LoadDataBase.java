package com.manage.hr.util;

import com.manage.hr.entity.Department;
import com.manage.hr.entity.Dictionary;
import com.manage.hr.entity.Position;
import com.manage.hr.entity.Title;
import com.manage.hr.service.DepartmentService;
import com.manage.hr.service.DictionaryService;
import com.manage.hr.service.PositionService;
import com.manage.hr.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
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

    //此map用来缓存常用表
    public static Map<String, List> DATA_BASE = new HashMap<>();
    public static Map<String, Map<Integer, String>> DICTIONARY = new HashMap<>();

    @Autowired
    DictionaryService dictionaryServiceAuto;
    @Autowired
    DepartmentService departmentServiceAuto;
    @Autowired
    PositionService positionServiceAuto;
    @Autowired
    TitleService titleServiceAuto;
    //静态对象
    private static DictionaryService dictionaryService;
    private static DepartmentService departmentService;
    private static PositionService positionService;
    private static TitleService titleService;

    @PostConstruct
    public void init() {
        dictionaryService = this.dictionaryServiceAuto;  //将注入的对象交给静态对象管理
        departmentService = this.departmentServiceAuto;
        positionService = this.positionServiceAuto;
        titleService = this.titleServiceAuto;
    }


    public static void loadDictionary() {
        List<Dictionary> dictionaryList = dictionaryService.listDictionary();
        DATA_BASE.put("dictionary", dictionaryList);
        Map<Integer, String> revStatus = new HashMap<>();
        Map<Integer, String> archStatus = new HashMap<>();
        Map<Integer, String> education = new HashMap<>();
        Map<Integer, String> political = new HashMap<>();
        Map<Integer, String> userRole = new HashMap<>();
        Map<Integer, String> posClass = new HashMap<>();
        Map<Integer, String> gender = new HashMap<>();
        for (Dictionary dictionary : dictionaryList) {
            if (dictionary.getDataType().equals("revStatus")) {
                revStatus.put(dictionary.getId(), dictionary.getDataName());
            } else if (dictionary.getDataType().equals("archStatus")) {
                archStatus.put(dictionary.getId(), dictionary.getDataName());
            } else if (dictionary.getDataType().equals("education")) {
                education.put(dictionary.getId(), dictionary.getDataName());
            } else if (dictionary.getDataType().equals("political")) {
                political.put(dictionary.getId(), dictionary.getDataName());
            } else if (dictionary.getDataType().equals("userRole")) {
                userRole.put(dictionary.getId(), dictionary.getDataName());
            } else if (dictionary.getDataType().equals("posClass")) {
                posClass.put(dictionary.getId(), dictionary.getDataName());
            } else if (dictionary.getDataType().equals("gender")) {
                gender.put(dictionary.getId(), dictionary.getDataName());
            }
        }
        DICTIONARY.put("revStatus", revStatus);
        DICTIONARY.put("archStatus", archStatus);
        DICTIONARY.put("education", education);
        DICTIONARY.put("gender", gender);
        DICTIONARY.put("political", political);
        DICTIONARY.put("posClass", posClass);
        DICTIONARY.put("userRole", userRole);
    }

    public static void loadDepartment() {
        List<Department> departmentCache = departmentService.cacheDepartment();
        DATA_BASE.put("department", departmentCache);
    }

    public static void loadPosition() {
        List<Position> positionCache = positionService.cachePosition();
        DATA_BASE.put("position", positionCache);
    }

    public static void loadTitle() {
        List<Title> titleCache = titleService.cacheTitle();
        DATA_BASE.put("title", titleCache);
    }

}


