package com.manage.hr.entity;

import java.math.BigDecimal;

public class SalaryStandardDetail {
    private Integer id;
    private String standardCode;
    private String itemName;
    private BigDecimal itemAmount;
    private int isChange;

    public int getIsChange() {
        return isChange;
    }

    public void setIsChange(int isChange) {
        this.isChange = isChange;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStandardCode() {
        return standardCode;
    }

    public void setStandardCode(String standardCode) {
        this.standardCode = standardCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(BigDecimal itemAmount) {
        this.itemAmount = itemAmount;
    }
}
