package com.manage.hr.dao;

import com.manage.hr.entity.Payment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentDao {
    //查询所有
    List<Payment> listPayment();

    int savePayment(Payment payment);
}

