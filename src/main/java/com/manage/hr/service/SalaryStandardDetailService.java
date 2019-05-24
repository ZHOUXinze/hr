package com.manage.hr.service;

import com.manage.hr.entity.SalaryStandardDetail;
import com.manage.hr.entity.Ssd;

import java.util.List;

public interface SalaryStandardDetailService {
    //根据标准编号查询所有小项
    List<SalaryStandardDetail> listSalaryStandardDetailByCode(String standardCode);

    //update
    int updateSalaryStandardDetail(List<SalaryStandardDetail> salaryStandardDetails);

    //insert
    int insertSalaryStandardDetail(List<SalaryStandardDetail> salaryStandardDetails);
}
