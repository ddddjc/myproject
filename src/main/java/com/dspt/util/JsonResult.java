package com.dspt.util;

import java.io.Serializable;

/**
 * 响应结果类
 * @param <E> 响应数据的类型
 */
public class JsonResult<E> implements Serializable {
    /** 状态码 */
    private Integer state;

    /** 状态描述信息 */
    private String messag;

    /** 数据 */
    private E Da;

    public JsonResult() {
        super();
    }

    public JsonResult(Integer state) {
        super();
        this.state = state;
    }

    /** 出现异常时调用 */
    public JsonResult(Throwable e) {
        super();
        // 获取异常对象中的异常信息
        this.messag = e.getMessage();
    }

    public JsonResult(Integer state, E data) {
        super();
        this.state = state;
        this.Da = data;
    }

    public JsonResult(Integer state, String message, E Da) {
        this.state = state;
        this.messag = message;
        this.Da = Da;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return messag;
    }

    public void setMessage(String message) {
        this.messag = message;
    }

    public E getData() {
        return Da;
    }

    public void setData(E data) {
        this.Da = data;
    }
}
