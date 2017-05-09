package com.shahuwang.jhttp;

/**
 * Created by shahuwang on 2017/5/9.
 */
public class DefaultRequestCancel implements IRequestCancel{
    public void stopTimer(){}

    public boolean didTimeout(){
        return false;
    }
}
