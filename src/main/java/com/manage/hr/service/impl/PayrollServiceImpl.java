package com.manage.hr.service.impl;

import com.manage.hr.dao.PayrollDao;
import com.manage.hr.entity.Payroll;
import com.manage.hr.service.PayrollService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PayrollServiceImpl implements PayrollService {
    @Resource
    private PayrollDao payrollDao;

    @Override
    public List<Payroll> listPayrollByPm(int paymentId) {
        return payrollDao.listPayrollByPm(paymentId);
    }

    @Override
    public List<Payroll> listPayrollByDep(int depId) {
        return payrollDao.listPayrollByDep(depId);
    }

    @Override
    public Payroll getPayrollByPmDdp(int paymentId, int depId) {
        return payrollDao.getPayrollByPmDdp(paymentId,depId);
    }

    @Override
    public int countPayrollByPaymentId(int paymentId) {
        return payrollDao.countPayrollByPaymentId(paymentId);
    }


}
