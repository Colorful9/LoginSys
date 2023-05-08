package com.example.demo;

import lombok.Data;

@Data
public class Result {

    public Result() {
    }


    public Result(String msg, boolean flag){
        this.msg = msg;
        this.flag = flag;

    }

    public Result(String msg, boolean flag, Object obj){
        this.msg = msg;
        this.flag = flag;
        this.data = obj;

    }
    private String msg;

    private boolean flag;

    private Object data;


    public boolean isSuccess(){

        return flag;
    }


}
