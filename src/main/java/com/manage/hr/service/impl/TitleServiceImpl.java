package com.manage.hr.service.impl;

import com.manage.hr.dao.TitleDao;
import com.manage.hr.entity.Title;
import com.manage.hr.service.TitleService;
import com.manage.hr.util.PageSurport;
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

    @Override
    public PageSurport<Title> findAllTitle(Title title, int pageIndex, int pageSize) {
        PageSurport<Title> pageSurport=new PageSurport<>();
        int from=(pageIndex-1)*pageSize;
        pageSurport.setDataList(titleDao.findAllTitle(title,from,pageSize));
        pageSurport.setTotalCount(titleDao.findAllTitleCount(title));
        return pageSurport;
    }

    @Override
    public int addTitle(Title title) {
        return titleDao.addTitle(title);
    }

    @Override
    public int updateTitle(Title title) {
        return titleDao.updateTitle(title);
    }

    @Override
    public Title findTitleByID(int titleId) {
        return titleDao.findTitleByID(titleId);
    }

    @Override
    public int detTitleByID(int titleId) {
        return titleDao.detTitleByID(titleId);
    }

    @Override
    public String findtitleByCode(String titleCode) {
        return titleDao.findtitleByCode(titleCode);
    }


}
