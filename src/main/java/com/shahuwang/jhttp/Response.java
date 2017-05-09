package com.shahuwang.jhttp;

/**
 * Created by rickey on 2017/4/20.
 */
public class Response {
    public IReadCloser body;

    public IReadCloser getBody() {
        return body;
    }
}
