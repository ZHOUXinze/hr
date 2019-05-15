package com.manage.hr.dao;

import com.manage.hr.entity.Dictionary;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DictionaryDao {
    List<Dictionary> listDictionary();
}
