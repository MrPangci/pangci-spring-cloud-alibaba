package com.pangci.commom;

public class ResultMessage<T> {
    private Integer code;
    private String message;
    private T data;

    public Integer getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
    public T getData() {
        return data;
    }
    public ResultMessage(Integer code, String message, T data){
        this.code=code;
        this.message=message;
        this.data=data;
    }
    public ResultMessage(){}//这个是无参构造
    public ResultMessage(Integer code, String message){
        //下面这个就直接是调用构造方法了
        this(code,message,null);
    }
    public ResultMessage<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public ResultMessage<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public ResultMessage<T> setData(T data) {
        this.data = data;
        return this;
    }
}
