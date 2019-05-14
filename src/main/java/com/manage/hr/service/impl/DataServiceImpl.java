package com.manage.hr.service.impl;

import com.manage.hr.dao.DataDao;
import com.manage.hr.entity.Dictionary;
import com.manage.hr.service.DataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service
public class DataServiceImpl implements DataService {
    @Resource
    private DataDao dataDao;

    @Override
    public List<Dictionary> listDictionary() {
       return dataDao.listDictionary();
    }
}
