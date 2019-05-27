package com.manage.hr.dao;

import com.manage.hr.entity.Title;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitleDao {
    List<Title> listTitle();
    List<Title> cacheTitle();
    List<Title> findAllTitle(@Param("title")Title title,@Param("from")int from,
                             @Param("pageSize") int pageSize  );
    int findAllTitleCount(@Param("title")Title title);
    int addTitle(Title title);
    Title findTitleByID(@Param("titleId") int titleId );
    int updateTitle(Title title);
    int detTitleByID(int titleId);
    String findtitleByCode(String titleCode);
}
