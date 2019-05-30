package com.manage.hr.dao;

import com.manage.hr.entity.PaymentDep;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PaymentDepDao {
    List<PaymentDep> listPaymentDep(int paymentId);
}
