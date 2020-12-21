package com.cht.provider.dto;

import java.io.Serializable;
import java.util.Date;

public class DemoDto implements Serializable {

    private String name;

    private String blackTime;

    private Date blackTime2;

    private DemoChildDto ageDto;

    private Date testField;

    private String testField2;

    private String driverUuid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlackTime() {
        return blackTime;
    }

    public void setBlackTime(String blackTime) {
        this.blackTime = blackTime;
    }

    public Date getBlackTime2() {
        return blackTime2;
    }

    public void setBlackTime2(Date blackTime2) {
        this.blackTime2 = blackTime2;
    }

    public DemoChildDto getAgeDto() {
        return ageDto;
    }

    public void setAgeDto(DemoChildDto ageDto) {
        this.ageDto = ageDto;
    }

    public Date getTestField() {
        return testField;
    }

    public void setTestField(Date testField) {
        this.testField = testField;
    }

    public String getTestField2() {
        return testField2;
    }

    public void setTestField2(String testField2) {
        this.testField2 = testField2;
    }

    public String getDriverUuid() {
        return driverUuid;
    }

    public void setDriverUuid(String driverUuid) {
        this.driverUuid = driverUuid;
    }
}
