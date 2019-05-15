package com.manage.hr.service.impl;

import com.manage.hr.dao.DepartmentDao;
import com.manage.hr.entity.Department;
import com.manage.hr.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentDao departmentDao;
    @Override
    public Department listDepartment() {
        return departmentDao.listDepartment();
    }
}
