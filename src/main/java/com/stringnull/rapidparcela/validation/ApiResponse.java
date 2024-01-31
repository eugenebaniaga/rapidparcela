package com.stringnull.rapidparcela.validation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


/**
 * Customize Api Response
 * @param <T>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    public T data;
    public boolean success;
    public String msg;

    public ApiResponse<T> success(T data) {
      return this.success(data, "");
    }
    public ApiResponse<T> success(T data, String msg) {
        ApiResponse<T> resp = new ApiResponse<T>();
        resp.data = data;
        resp.success = true;
        return resp;
    }

    public ApiResponse<T> error(T data){

        ApiResponse<T> resp = new ApiResponse<T>();
        resp.data = data;
        resp.success = false;
        return resp;
    }
    public ApiResponse<T> error(String msg){

        ApiResponse<T> resp = new ApiResponse<T>();

        resp.success = false;
        resp.msg = msg;
        return resp;
    }


}
