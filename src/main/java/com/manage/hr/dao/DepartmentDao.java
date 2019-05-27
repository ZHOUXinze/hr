package com.manage.hr.dao;

import com.manage.hr.entity.Department;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentDao {
    List<Department> listDepartment();
    List<Department> cacheDepartment();
    int addDepartment(Department department);
    Department getDepartmentById(int id);
    int updateDepartmentByID(Department department);
    Department findDepartmentBydepName(@Param("depName") String depName);
    int detDepartByID(int depID);
}
