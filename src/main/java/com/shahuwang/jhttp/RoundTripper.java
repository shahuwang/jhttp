package com.shahuwang.jhttp;

/**
 * Created by rickey on 2017/4/20.
 */
public interface RoundTripper {
    public Response roundTrip(Request r) throws Exception;
}
