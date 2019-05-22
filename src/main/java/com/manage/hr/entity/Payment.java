package com.manage.hr.entity;

import java.util.Date;

public class Payment {
    private Integer id;
    private String paymentCode;
    private Double salaryTotal;
    private Integer paymentCount;
    private Double actualTotal;
    private Date lastTime;
    private Date thisTime;
    private Integer status;

    private int modelStatus;

    public int getModelStatus() {
        return modelStatus;
    }

    public void setModelStatus(int modelStatus) {
        this.modelStatus = modelStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public Double getSalaryTotal() {
        return salaryTotal;
    }

    public void setSalaryTotal(Double salaryTotal) {
        this.salaryTotal = salaryTotal;
    }

    public Integer getPaymentCount() {
        return paymentCount;
    }

    public void setPaymentCount(Integer paymentCount) {
        this.paymentCount = paymentCount;
    }

    public Double getActualTotal() {
        return actualTotal;
    }

    public void setActualTotal(Double actualTotal) {
        this.actualTotal = actualTotal;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Date getThisTime() {
        return thisTime;
    }

    public void setThisTime(Date thisTime) {
        this.thisTime = thisTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
