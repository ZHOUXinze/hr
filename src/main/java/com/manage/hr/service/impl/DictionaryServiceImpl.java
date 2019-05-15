package com.manage.hr.service.impl;

import com.manage.hr.dao.DataDao;
import com.manage.hr.entity.Dictionary;
import com.manage.hr.service.DictionaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Resource
    private DataDao dataDao;

    @Override
    public List<Dictionary> listDictionary() {
       return dataDao.listDictionary();
    }
}
