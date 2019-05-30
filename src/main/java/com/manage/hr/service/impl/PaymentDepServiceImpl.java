package com.manage.hr.service.impl;

import com.manage.hr.dao.PaymentDepDao;
import com.manage.hr.entity.PaymentDep;
import com.manage.hr.service.PaymentDepService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PaymentDepServiceImpl implements PaymentDepService {
    @Resource
    private PaymentDepDao paymentDepDao;

    @Override
    public List<PaymentDep> listPaymentDep(int paymentId) {
        return paymentDepDao.listPaymentDep(paymentId);
    }
}
