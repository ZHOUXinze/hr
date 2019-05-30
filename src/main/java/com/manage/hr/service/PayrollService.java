package com.manage.hr.service;

import com.manage.hr.entity.Payroll;

import java.util.List;

public interface PayrollService {
    //根据薪酬单id查询所有payroll
    List<Payroll> listPayrollByPm(int paymentId);
    //根据部门id查询所有payroll
    List<Payroll> listPayrollByDep(int depId);
    //根据部门id和薪酬单id查询payroll
    Payroll getPayrollByPmDdp(int paymentId,int depId);

    int countPayrollByPaymentId(int paymentId);
}
