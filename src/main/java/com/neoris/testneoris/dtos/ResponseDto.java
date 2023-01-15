package com.neoris.testneoris.dtos;

public class ResponseDto<T> {
    T data;
    String error;

    public ResponseDto(T data, String error) {
        this.data = data;
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
