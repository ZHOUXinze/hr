package com.manage.hr.service;

import com.manage.hr.entity.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentService {
    List<Department> listDepartment();
    List<Department> cacheDepartment();
    int addDepartment(Department department);
    int updateDepartmentByID(Department department);
    Department findDepartmentBydepName(String depName);
    int detDepartByID(int depID);
    Department getDepartmentById(int id);
}
