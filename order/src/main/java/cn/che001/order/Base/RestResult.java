package cn.che001.order.Base;

public class RestResult {
    public static final String SUCCESS_MSG = "SUCCESS";
    public static final int SUCCESS_CODE = 200;
    public static final String ERROR_MSG = "ERROR";
    public static final int ERROR_CODE = 500;
    private int code = 200;
    private String msg = null;
    private Object data = null;

    public RestResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public RestResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}