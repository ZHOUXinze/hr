package com.manage.hr.service;

import com.manage.hr.entity.SalaryStandard;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SalaryStandardService {
    List<SalaryStandard> listSalaryStandard();

    SalaryStandard getSalaryStandardById(int id);

    int insertSalaryStandard(SalaryStandard salaryStandard);

    int updateSalaryStandard(SalaryStandard salaryStandard);

    int deleteSalaryStandard(int id);

    int reviewSalaryStandard(int id, String review, String reviewOpinion);

    List<SalaryStandard> listSalaryStandardByCondition(String salaryStandardCode, String statusName, Date start, Date end);
}
