package com.manage.hr.service;

import com.manage.hr.entity.SalaryStandardDetail;

import java.util.List;

public interface SalaryStandardDetailService {
    //根据标准编号查询所有小项
    List<SalaryStandardDetail> listSalaryStandardDetailByCode(String standardCode);
}
