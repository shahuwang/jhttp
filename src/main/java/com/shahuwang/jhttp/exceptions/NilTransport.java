package com.shahuwang.jhttp.exceptions;

/**
 * Created by shahuwang on 2017/4/21.
 */
public class NilTransport extends HttpException{
    private String message = "http: no Client.Transport or DefaultTransport";

    public String getMessage(){
        return this.message;
    }
}
