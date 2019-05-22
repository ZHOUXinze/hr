package com.manage.hr.dao;

import com.manage.hr.entity.SalaryStandard;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SalaryStandardDao {
    List<SalaryStandard> listSalaryStandard();

    SalaryStandard getSalaryStandardById(int id);

    int insertSalaryStandard(SalaryStandard salaryStandard);

    int updateSalaryStandard(SalaryStandard salaryStandard);

    int deleteSalaryStandard(int id);

    int reviewSalaryStandard(SalaryStandard salaryStandard);

    List<SalaryStandard> listSalaryStandardByCondition(@Param("standardCode") String salaryStandardCode,
                                                       @Param("status") int status,
                                                       @Param("start") Date start,
                                                       @Param("end") Date end);
}
