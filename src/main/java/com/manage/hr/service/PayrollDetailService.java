package com.manage.hr.service;

import com.manage.hr.entity.PayrollDetail;

import java.util.List;

public interface PayrollDetailService {
    //根据工资条id查询的payrollDetail
    List<PayrollDetail> listPayrollDetailByPrId(int payrollId);
}
