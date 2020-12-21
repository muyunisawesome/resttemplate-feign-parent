package com.cht;

public enum ResEnum {

    SUCCESS(200, "成功"),
    ERROR(500, "失败");

    private Integer code;
    private String msg;

    private ResEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
