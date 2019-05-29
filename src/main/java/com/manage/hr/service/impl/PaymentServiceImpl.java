package com.manage.hr.service.impl;

import com.manage.hr.dao.ArchiveDao;
import com.manage.hr.dao.PaymentDao;
import com.manage.hr.dao.PayrollDao;
import com.manage.hr.dao.PayrollDetailDao;
import com.manage.hr.entity.Payment;
import com.manage.hr.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Resource
    private PayrollDao payrollDao;
    @Resource
    private PayrollDetailDao payrollDetailDao;
    @Resource
    private ArchiveDao archiveDao;

    //查询所有
    public List<Payment> listPayment() {
        //查询所有薪酬单
        List<Payment> paymentList = paymentDao.listPayment();
        //查询所有
        return paymentDao.listPayment();
    }

    @Override
    public int savePayment(List<Payment> paymentList) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        for (Payment payment : paymentList) {
            int ms = payment.getModelStatus();
            if (ms != 0) {
                try {
                    payment.setLastTime(simpleDateFormat.parse(payment.getLast()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (ms == 2) {
                    payment.setStatus(6);
                    paymentDao.insertPayment(payment);
                }
            }
        }
        return 1;
    }

    @Override
    public List<Payment> listPaymentByCode(String paymentCode) {
        return paymentDao.listPaymentByCode(paymentCode);
    }

    @Override
    public Payment getPaymentByCodeAndDep(String paymentCode, int depId) {
        return paymentDao.getPaymentByCodeAndDep(paymentCode, depId);
    }


}
