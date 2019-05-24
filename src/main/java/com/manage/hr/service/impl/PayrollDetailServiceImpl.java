package com.manage.hr.service.impl;

import com.manage.hr.dao.PayrollDetailDao;
import com.manage.hr.entity.PayrollDetail;
import com.manage.hr.service.PayrollDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PayrollDetailServiceImpl implements PayrollDetailService {

    @Resource
    private PayrollDetailDao payrollDetailDao;



    @Override
    public List<PayrollDetail> listPayrollDetailByPrId(int payrollId) {
        return payrollDetailDao.listPayrollDetailByPrId(payrollId);
    }
}
