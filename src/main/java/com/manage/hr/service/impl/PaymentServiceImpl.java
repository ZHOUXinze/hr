package com.manage.hr.service.impl;

import com.manage.hr.dao.ArchiveDao;
import com.manage.hr.dao.PaymentDao;
import com.manage.hr.dao.PayrollDao;
import com.manage.hr.dao.PayrollDetailDao;
import com.manage.hr.entity.Payment;
import com.manage.hr.service.PaymentService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
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
    public Payment insertPayment() {
        List<Payment> paymentList = paymentDao.listPayment();
        Payment lastPayment = paymentList.get(paymentList.size() - 1);
        Payment payment = new Payment();
        int pay = lastPayment.getId() + 1;
        payment.setPaymentCode("pay" + pay);
        payment.setLastTime(new Date());
        payment.setPaymentCount(lastPayment.getPaymentCount() + 1);
        paymentDao.insertPayment(payment);
        return paymentDao.getPaymentByCode(payment.getPaymentCode());
    }

    @Override
    public int updatePayment(Payment payment) {
        return paymentDao.updatePayment(payment);
    }

    @Override
    public String getNewCode() {
        List<Payment> paymentList = paymentDao.listPayment();
        Payment lastPayment = paymentList.get(paymentList.size() - 1);
        int pay = lastPayment.getId() + 1;
        return "pay" + pay;
    }

}
