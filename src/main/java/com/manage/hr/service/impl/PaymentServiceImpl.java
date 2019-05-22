package com.manage.hr.service.impl;

import com.manage.hr.dao.PaymentDao;
import com.manage.hr.entity.Payment;
import com.manage.hr.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    //查询所有
    public List<Payment> listPayment(){
        return paymentDao.listPayment();
    }

    @Override
    public int savePayment(List<Payment> paymentList) {
        for (Payment payment:paymentList){
            paymentDao.savePayment(payment);
        }
        return 1;
    }


}
