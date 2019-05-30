package com.manage.hr.dao;

import com.manage.hr.entity.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentDao {
    int updatePayment(Payment payment);

    int insertPayment(Payment payment);

    List<Payment> listPayment();

    Payment getPaymentByCode(String paymentCode);
}

