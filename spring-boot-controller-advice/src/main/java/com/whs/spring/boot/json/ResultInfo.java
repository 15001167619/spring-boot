package com.whs.spring.boot.json;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-05 13:33
 */
public class ResultInfo {

    private static final String OK = "ok";
    private static final String ERROR = "error";

    private Meta meta;
    private Object data;

    public ResultInfo success() {
        this.meta = new Meta(true, OK);
        return this;
    }

    public ResultInfo success(Object data) {
        this.meta = new Meta(true, OK);
        this.data = data;
        return this;
    }

    public ResultInfo failure() {
        this.meta = new Meta(false, ERROR);
        return this;
    }

    public ResultInfo failure(String message) {
        this.meta = new Meta(false, message);
        return this;
    }

    public Meta getMeta() {
        return meta;
    }

    public Object getData() {
        return data;
    }

    public class Meta {

        private boolean success;
        private String message;

        public Meta(boolean success) {
            this.success = success;
        }

        public Meta(boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getMessage() {
            return message;
        }
    }

}
