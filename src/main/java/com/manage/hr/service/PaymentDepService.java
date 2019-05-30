package com.manage.hr.service;

import com.manage.hr.entity.PaymentDep;

import java.util.List;

public interface PaymentDepService {
    List<PaymentDep> listPaymentDep(int paymentId);
}
