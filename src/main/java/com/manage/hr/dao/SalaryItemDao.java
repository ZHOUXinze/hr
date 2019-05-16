package com.manage.hr.dao;

import com.manage.hr.entity.SalaryItem;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SalaryItemDao {
    List<SalaryItem> listSalaryItem();
    SalaryItem insertSalaryItem();
}
