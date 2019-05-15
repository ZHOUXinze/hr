package com.manage.hr.service.impl;

import com.manage.hr.dao.DictionaryDao;
import com.manage.hr.entity.Dictionary;
import com.manage.hr.service.DictionaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Resource
    private DictionaryDao dictionaryDao;

    @Override
    public List<Dictionary> listDictionary() {
       return dictionaryDao.listDictionary();
    }
}
