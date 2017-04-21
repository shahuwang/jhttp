package com.shahuwang.jhttp.exceptions;

/**
 * Created by shahuwang on 2017/4/21.
 */
public abstract class HttpException extends Exception{
    public HttpException(){
        super();
    }

    public HttpException(String message){
        super(message);
    }
}
