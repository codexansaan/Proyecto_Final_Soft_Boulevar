package com.boulevar.Soft.Boulevar.Util;

public class ApiRespuestaData<T> {

    private T data;

    public ApiRespuestaData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
