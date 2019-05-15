package com.manage.hr.service;

import com.manage.hr.entity.Title;

import java.util.List;

public interface TitleService {
    List<Title> listTitle();
    List<Title> cacheTitle();
}
