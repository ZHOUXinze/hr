package com.manage.hr.dao;

import com.manage.hr.entity.PayrollDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayrollDetailDao {
    //根据工资条id查询的payrollDetail
    List<PayrollDetail> listPayrollDetailByPrId(int payrollId);
}
