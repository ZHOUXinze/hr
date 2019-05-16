package com.manage.hr.service.impl;

import com.manage.hr.dao.SalaryItemDao;
import com.manage.hr.entity.SalaryItem;
import com.manage.hr.service.SalaryItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SalaryItemServiceImpl implements SalaryItemService {

    @Resource
    private SalaryItemDao salaryItemDao;
    @Override
    public List<SalaryItem> listSalaryItem() {
        return salaryItemDao.listSalaryItem();
    }
}
