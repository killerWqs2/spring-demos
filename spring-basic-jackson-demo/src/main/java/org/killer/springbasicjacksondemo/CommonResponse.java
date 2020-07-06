package org.killer.springbasicjacksondemo;

import java.util.HashMap;

/**
 * 继承HashMap主要是为了能够使用@JsonView来自定义返回数据，，真是有意思，，
 * 也可以不用继承HashMap但是不继承的话会有问题
 *
 * @author killer
 * @date 2020/06/10 - 17:17
 */
public class CommonResponse<T> extends HashMap<String, Object> {

    private Integer code;

    private String msg;

    private T data;

    public static CommonResponse success(Object data) {
        CommonResponse<Object> response = new CommonResponse<>();
        // response.setCode(0);
        // response.setMsg("success");
        // response.setData(data);
        response.put("code", 0);
        response.put("msg", "successs");
        response.put("data", data);

        return response;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
