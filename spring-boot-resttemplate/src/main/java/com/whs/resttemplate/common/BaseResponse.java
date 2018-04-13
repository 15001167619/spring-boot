package com.whs.resttemplate.common;

import lombok.Data;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-04-13 16:32
 */
@Data
public class BaseResponse<T> {

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 说明
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    public BaseResponse() {

    }

    public BaseResponse(boolean success, String msg, T data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

}
