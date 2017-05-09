package com.shahuwang.jhttp;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by shahuwang on 2017/5/9.
 */
public class RequestCancel implements IRequestCancel{
    private AtomicInteger atom = new AtomicInteger(0);
    private SyncChan<Boolean> stopCh;

    public RequestCancel(SyncChan<Boolean> stopCh){
        this.stopCh = stopCh;
    }

    protected void setTrue(){
        this.atom.set(1);
    }

    @Override
    public boolean didTimeout() {
        return this.atom.get() != 0;
    }

    @Override
    public void stopTimer() {
        this.stopCh.put(new Boolean(true));
    }
}
