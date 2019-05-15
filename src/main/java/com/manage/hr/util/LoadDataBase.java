package com.manage.hr.util;

import com.manage.hr.entity.Dictionary;
import com.manage.hr.service.impl.DataServiceImpl;

import java.util.List;
import java.util.Map;

public class LoadDataBase {
    private DataServiceImpl dataServiceImpl = new DataServiceImpl();
    public static Map<String, List> DATA_BASE;

    public void loadDictionary(){
        List<Dictionary> dictionaryList = dataServiceImpl.listDictionary();
        DATA_BASE.put("dictionary",dictionaryList);
    }

}
