package com.manage.hr.service.impl;

import com.manage.hr.dao.DepartmentDao;
import com.manage.hr.entity.Department;
import com.manage.hr.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentDao departmentDao;

    @Override
    public List<Department> listDepartment() {
        return departmentDao.listDepartment();
    }

    @Override
    public List<Department> cacheDepartment() {
        return departmentDao.cacheDepartment();
    }

    @Override
    public int addDepartment(Department department) {
        return departmentDao.addDepartment(department);
    }
}
