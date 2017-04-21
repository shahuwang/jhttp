package com.shahuwang.jhttp;

/**
 * Created by rickey on 2017/4/20.
 */
@FunctionalInterface
public interface CheckRedirect {
    public void check(Request req, Request[] via);
}
