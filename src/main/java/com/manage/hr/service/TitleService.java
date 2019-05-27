package com.manage.hr.service;

import com.manage.hr.entity.Title;
import com.manage.hr.util.PageSurport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TitleService {
    List<Title> listTitle();
    List<Title> cacheTitle();
    PageSurport<Title> findAllTitle(Title title,int pageIndex, int pageSize );
    int addTitle(Title title);
    int updateTitle(Title title);
    Title findTitleByID( int titleId );
    int detTitleByID(int titleId);
    String findtitleByCode(String titleCode);
}
