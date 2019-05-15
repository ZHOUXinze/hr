package com.manage.hr.dao;

import com.manage.hr.entity.Title;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitleDao {
    List<Title> listTitle();
    List<Title> cacheTitle();
}
