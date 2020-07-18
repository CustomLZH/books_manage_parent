package com.guaiwuxue.entity;

/**
 * @Author: Custom
 * @Date: 2020/7/11 14:28
 * @Version: 1.0
 */

import java.io.Serializable;

/**
 * 封装返回结果
 */
public class Result implements Serializable {
    /**
     * 执行结果，true为执行成功，false为执行失败
     */
    private Boolean flag;
    /**
     * 返回结果信息
     */
    private String message;
    /**
     * 返回数据
     */
    private Object data;

    public Result(Boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }

    public Result(Boolean flag, String message, Object data) {
        this.flag = flag;
        this.message = message;
        this.data = data;
    }

    public Boolean getFlag() {
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
