package com.manage.hr.dao;

import com.manage.hr.entity.Payroll;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayrollDao {
    //根据薪酬单id查询所有payroll
    List<Payroll> listPayrollByPm(int paymentId);

    //根据部门id查询所有payroll
    List<Payroll> listPayrollByDep(int depId);

    Payroll getPayrollByPmDdp(@Param("paymentId") int paymentId, @Param("depId") int depId);


    int countPayrollByPaymentId(int paymentId);
}
