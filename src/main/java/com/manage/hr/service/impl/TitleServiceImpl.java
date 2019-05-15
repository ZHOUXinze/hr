package com.manage.hr.service.impl;

import com.manage.hr.dao.TitleDao;
import com.manage.hr.entity.Title;
import com.manage.hr.service.TitleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TitleServiceImpl implements TitleService {
    @Resource
    private TitleDao titleDao;
    @Override
    public List<Title> listTitle() {
        return titleDao.listTitle();
    }

    @Override
    public List<Title> cacheTitle() {
        return titleDao.cacheTitle();
    }
}
