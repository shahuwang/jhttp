package com.shahuwang.jhttp;

/**
 * Created by shahuwang on 2017/5/10.
 */
public class CancelTimerBody implements IReadCloser{
    private IReadCloser rc;
    public CancelTimerBody(IReadCloser rc){
        this.rc = rc;
    }

    @Override
    public int read(byte[] p) {
        return 0;
    }

    @Override
    public void close() {

    }
}
