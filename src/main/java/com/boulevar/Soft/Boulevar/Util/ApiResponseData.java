package com.boulevar.Soft.Boulevar.Util;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApiResponseData<T> {

    private T data;

    public ApiResponseData(T data) {
        this.data = data;
    }

}
