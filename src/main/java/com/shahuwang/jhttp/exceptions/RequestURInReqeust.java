package com.shahuwang.jhttp.exceptions;

/**
 * Created by shahuwang on 2017/4/21.
 */
public class RequestURInReqeust extends HttpException{
    private String message = "http: Request.RequestURI can't be set in client requests.";

    @Override
    public String getMessage() {
        return message;
    }
}
