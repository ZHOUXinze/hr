package com.manage.hr.service;

import com.manage.hr.entity.SalaryStandard;

import java.util.List;

public interface SalaryStandardService {
    List<SalaryStandard> listSalaryStandard();

    SalaryStandard getSalaryStandardById(int id);

    int insertSalaryStandard(SalaryStandard salaryStandard);

    int updateSalaryStandard(SalaryStandard salaryStandard);

    int deleteSalaryStandard(int id);
}
