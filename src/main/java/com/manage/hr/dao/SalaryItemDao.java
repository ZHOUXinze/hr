package com.manage.hr.dao;

import com.manage.hr.entity.SalaryItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryItemDao {
    List<SalaryItem> listSalaryItem();

    int insertSalaryItem(SalaryItem salaryItem);

    int updateSalaryItem(SalaryItem salaryItem);

    int deleteSalaryItem(int id);
}
