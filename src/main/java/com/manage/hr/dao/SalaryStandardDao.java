package com.manage.hr.dao;

import com.manage.hr.entity.SalaryStandard;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryStandardDao {
    List<SalaryStandard> listSalaryStandard();

    SalaryStandard getSalaryStandardById(int id);

    int insertSalaryStandard(SalaryStandard salaryStandard);

    int updateSalaryStandard(SalaryStandard salaryStandard);

    int deleteSalaryStandard(int id);
}
