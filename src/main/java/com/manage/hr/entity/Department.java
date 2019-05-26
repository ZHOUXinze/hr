package com.manage.hr.entity;

import java.math.BigDecimal;

public class Department {
    private Integer id;
    private  String depCode;
    private  String depName;
    private  String abbreviation;
    private Integer higherOffice;
    private String address;
    private String  introduction;
    private String remark;
    private Integer enable;
    private String higherOfficeName;
    private int pNum;
    private BigDecimal totalSs;

    public BigDecimal getTotalSs() {
        return totalSs;
    }

    public void setTotalSs(BigDecimal totalSs) {
        this.totalSs = totalSs;
    }

    public int getpNum() {
        return pNum;
    }

    public void setpNum(int pNum) {
        this.pNum = pNum;
    }

    public String getHigherOfficeName() {
        return higherOfficeName;
    }

    public void setHigherOfficeName(String higherOfficeName) {
        this.higherOfficeName = higherOfficeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepCode() {
        return depCode;
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Integer getHigherOffice() {
        return higherOffice;
    }

    public void setHigherOffice(Integer higherOffice) {
        this.higherOffice = higherOffice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }
}
