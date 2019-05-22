package com.manage.hr.service;

import com.manage.hr.entity.SalaryStandard;
import java.util.List;

public interface SalaryStandardService {
    List<SalaryStandard> listSalaryStandard();

    SalaryStandard getSalaryStandardById(int id);

    int insertSalaryStandard(SalaryStandard salaryStandard,int type);

    int updateSalaryStandard(SalaryStandard salaryStandard,int type);

    int deleteSalaryStandard(int id);

    int reviewSalaryStandard(int id, String review, String reviewOpinion);

    List<SalaryStandard> listSalaryStandardByCondition(String salaryStandardCode, String statusName, String start, String end);
}
