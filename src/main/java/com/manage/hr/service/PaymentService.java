package com.manage.hr.service;

import com.manage.hr.entity.Payment;

import java.util.List;

public interface PaymentService {
    //查询所有
    List<Payment> listPayment();

    //保存
    int savePayment(List<Payment> paymentList);
}
