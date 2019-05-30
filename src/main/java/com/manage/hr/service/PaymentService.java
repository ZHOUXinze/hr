package com.manage.hr.service;

import com.manage.hr.entity.Payment;

import java.util.List;

public interface PaymentService {
    //查询所有
    List<Payment> listPayment();

    Payment insertPayment();

    int updatePayment(Payment payment);

    String getNewCode();
}
