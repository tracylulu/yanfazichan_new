package com.eos.common.util;

import com.eos.common.constant.StatusCodeEnum;

/**
 * @author s17742
 * @date 2019/12/3
 */
public class Result<T> {
    private Boolean flag;
    private Integer code;
    private String message;
    //private String traceId;
    private T data;

    /*public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }*/

    public Result() {
    }

    public Result(Boolean flag, Integer code, String message, T data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(Boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;

        this.message = message;
    }
    public Result(Boolean flag, StatusCodeEnum statusCodeEnum, T data) {
        this.flag = flag;
        this.code = statusCodeEnum.getCode();
        this.message = statusCodeEnum.getMassage();
        this.data = data;
    }
    public Result(Boolean flag, StatusCodeEnum statusCodeEnum) {
        this.flag = flag;
        this.code = statusCodeEnum.getCode();

        this.message = statusCodeEnum.getMassage();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean isFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "flag=" + flag +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
