package com.manage.hr.service;

import com.manage.hr.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> listDepartment();
    List<Department> cacheDepartment();
    int addDepartment(Department department);
}
