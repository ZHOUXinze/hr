package com.manage.hr.service;

import com.manage.hr.entity.SalaryItem;

import java.util.List;

public interface SalaryItemService {
    List<SalaryItem> listSalaryItem();

    int saveSalaryItem(List<SalaryItem> salaryItemList);

    int deleteSalaryItem(int id);
}
