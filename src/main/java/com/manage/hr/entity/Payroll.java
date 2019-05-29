package com.manage.hr.entity;

import java.util.List;

public class Payroll {
    private Integer id;
    private Integer paymentId;
    private Integer archId;
    private List<PayrollDetail> payrollDetails;

    public List<PayrollDetail> getPayrollDetails() {
        return payrollDetails;
    }

    public void setPayrollDetails(List<PayrollDetail> payrollDetails) {
        this.payrollDetails = payrollDetails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getArchId() {
        return archId;
    }

    public void setArchId(Integer archId) {
        this.archId = archId;
    }


}
