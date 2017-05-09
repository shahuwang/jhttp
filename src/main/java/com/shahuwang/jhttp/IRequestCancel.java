package com.shahuwang.jhttp;

/**
 * Created by shahuwang on 2017/5/9.
 */
public interface IRequestCancel {
    public void stopTimer();
    public boolean didTimeout();
}
