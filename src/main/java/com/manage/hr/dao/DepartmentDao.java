package com.manage.hr.dao;

import com.manage.hr.entity.Department;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository
public interface DepartmentDao {
    List<Department> listDepartment();
}
