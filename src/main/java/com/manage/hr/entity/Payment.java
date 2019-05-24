package com.manage.hr.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Payment {
    private Integer id;
    private String paymentCode;
    private BigDecimal salaryTotal;
    private Integer paymentCount;
    private BigDecimal actualTotal;
    private Date lastTime;
    private Integer status;
    private int peopleNumber;
    private int depId;

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public int getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(int peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

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

    public BigDecimal getSalaryTotal() {
        return salaryTotal;
    }

    public void setSalaryTotal(BigDecimal salaryTotal) {
        this.salaryTotal = salaryTotal;
    }

    public Integer getPaymentCount() {
        return paymentCount;
    }

    public void setPaymentCount(Integer paymentCount) {
        this.paymentCount = paymentCount;
    }

    public BigDecimal getActualTotal() {
        return actualTotal;
    }

    public void setActualTotal(BigDecimal actualTotal) {
        this.actualTotal = actualTotal;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
