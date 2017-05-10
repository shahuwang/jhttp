package com.shahuwang.jhttp;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by shahuwang on 2017/5/10.
 */
public class Once {
    private AtomicInteger done = new AtomicInteger(0);

    public void Do(IOnceFunction f){
        if(this.done.get() == 1){
            return;
        }
        synchronized (this){
           if(this.done.get() == 0){
               f.apply();
               this.done.set(1);
           }
        }
    }
}
