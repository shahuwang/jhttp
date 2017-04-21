package com.shahuwang.jhttp.exceptions;

/**
 * Created by shahuwang on 2017/4/21.
 */
public class NilURL extends HttpException{
    private String message = "http: nil request.URL";
    public String getMessage(){
        return message;
    }
}
