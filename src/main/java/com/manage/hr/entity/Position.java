package com.manage.hr.entity;

public class Position {
    private Integer id;
    private String posCode;
    private String posName;
    private Integer posClass;
    private Integer depId;
    private String introduction;
    private String remark;
    private Integer enable;
    private String dicClass;
    private String depName;
    private  String dataName;
    public String getDicClass() {
        return dicClass;
    }

    public void setDicClass(String dicClass) {
        this.dicClass = dicClass;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosCode() {
        return posCode;
    }

    public void setPosCode(String posCode) {
        this.posCode = posCode;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public Integer getPosClass() {
        return posClass;
    }

    public void setPosClass(Integer posClass) {
        this.posClass = posClass;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
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
