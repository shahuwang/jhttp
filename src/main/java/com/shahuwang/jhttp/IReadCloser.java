package com.shahuwang.jhttp;

/**
 * Created by shahuwang on 2017/5/10.
 */
public interface IReadCloser {
    public void close();
    public int read(byte[] p);
}
