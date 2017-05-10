package com.shahuwang.jhttp;

/**
 * Created by shahuwang on 2017/5/10.
 */
public class Transport implements RoundTripper{
    private Once nextProtoOnce = new Once();

    @Override
    public Response roundTrip(Request req) throws Exception {
        this.nextProtoOnce.Do(()->{this.onceSetNextProtoDefaults();});
        return null;
    }

    private void onceSetNextProtoDefaults(){
        //TODO 这里主要是用于设置http2，目前先实现http1.1
    }
}
