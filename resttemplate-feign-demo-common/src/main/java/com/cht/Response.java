package com.cht;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Response<T> implements Serializable {

    private static final long serialVersionUID = 6280855035125657876L;
    private String msg;
    private Integer code;
    private T data;
    private Boolean success;
    private String exception;
    private Map<String, String> attachment;
    private Integer errCode;

    private Response() {
    }

    private Response(String msg, Integer code, T data, Boolean success) {
        this.msg = msg;
        this.code = code;
        this.data = data;
        this.success = success;
        this.errCode = code;
    }

    public Response(String msg, T data, Boolean success) {
        this.msg = msg;
        this.data = data;
        this.success = success;
    }

    public Response(String msg, Boolean success) {
        this.msg = msg;
        this.success = success;
    }

    public Response(String msg, Integer code, T data, Boolean success, String exception) {
        this.msg = msg;
        this.code = code;
        this.data = data;
        this.success = success;
        this.exception = exception;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getErrCode() {
        return this.errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public static Response createSuccess(String msg) {
        return createSuccess(msg, (String[]) null);
    }

    public static Response createSuccess(Object data) {
        return createSuccess(ResEnum.SUCCESS.getMsg(), data);
    }

    public static Response createSuccess(String msg, Object data) {
        return createSuccess(msg, ResEnum.SUCCESS.getCode(), data);
    }

    public static Response createSuccess(String msg, Object data, String... args) {
        return createFormatMsg(msg, ResEnum.SUCCESS.getCode(), data, true, args);
    }

    public static Response createSuccess(String msg, String... args) {
        return createFormatMsg(msg, ResEnum.SUCCESS.getCode(), (Object) null, true, args);
    }

    public static Response createSuccess(String msg, Integer code, Object data) {
        return new Response(msg, code, data, true);
    }

    public Boolean isSuccess() {
        return this.success;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public String getException() {
        return this.exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public static Response createSuccess() {
        return new Response(ResEnum.SUCCESS.getMsg(), ResEnum.SUCCESS.getCode(), (Object) null, true);
    }

    public static Response createError() {
        return new Response(ResEnum.ERROR.getMsg(), ResEnum.ERROR.getCode(), (Object) null, false);
    }

    public static Response createError(String msg) {
        return createFormatMsg(msg, ResEnum.ERROR.getCode(), (Object) null, false);
    }

    public static Response createError(String msg, String... args) {
        return createFormatMsg(msg, ResEnum.ERROR.getCode(), (Object) null, false, args);
    }

    public static Response createError(String msg, Object data, String... args) {
        return createFormatMsg(msg, ResEnum.ERROR.getCode(), data, false, args);
    }

    public static Response createError(String msg, Object data) {
        return new Response(msg, ResEnum.ERROR.getCode(), data, false);
    }

    public static Response createError(String msg, Integer code, Object data) {
        return new Response(msg, code, data, false);
    }

    public static Response createError(String msg, Integer code) {
        return createFormatMsg(msg, code, (Object) null, false);
    }

    public static Response createError(String msg, String exception) {
        return new Response(msg, ResEnum.ERROR.getCode(), (Object) null, false, exception);
    }

    private static Response createFormatMsg(String msg, Integer code, Object data, Boolean success, String... args) {
        return new Response(String.format(msg, args), code, data, success);
    }

    public Map<String, String> getAttachment() {
        return this.attachment;
    }

    public void setAttachment(Map<String, String> attachment) {
        if (null != attachment) {
            this.attachment = attachment;
        }

    }

    public synchronized void setAttachment(String key, String value) {
        if (null == this.attachment) {
            this.attachment = new HashMap(8);
        }

        this.attachment.put(key, value);
    }
}
