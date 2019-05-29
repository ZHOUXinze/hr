package com.manage.hr.dao;

import com.manage.hr.entity.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentDao {
    //查询所有
    List<Payment> listPayment();

    int insertPayment(Payment payment);

    List<Payment> listPaymentByCode(String paymentCode);

    Payment getPaymentByCodeAndDep(@Param("paymentCode") String paymentCode, @Param("depId") int depId);
}

