package com.shahuwang.jhttp;

import com.shahuwang.jhttp.exceptions.NilTransport;
import com.shahuwang.jhttp.exceptions.NilURL;
import com.shahuwang.jhttp.exceptions.RequestURInReqeust;
import org.apache.logging.log4j.Logger;

import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by shahuwang on 2017/4/20.
 */
public class Client {
    RoundTripper transport;
    CheckRedirect checkRedirect;
    CookieJar jar;
    Duration timeout;
    private Logger logger = Log.getLogger(this.getClass().getName());
    public Client(){
        this.timeout = Duration.ZERO;
    }

    private Response send(Request req, Date deadline){
        if(this.jar != null){
            for(Cookie cookie: this.jar.cookies(req.getUrl())){
                req.addCookie(cookie);
            }
        }
        return null; //TODO
    }

    private Response send(Request ireq, RoundTripper rt, Date deadline)throws NilTransport, NilURL, RequestURInReqeust{
        Request req = ireq;
        if(rt == null){
            req.closeBody();
            throw new NilTransport();
        }
        if(req.getUrl() == null){
            req.closeBody();
            throw new NilURL();
        }
        if(req.getRequestURI() != ""){
            req.closeBody();
            throw new RequestURInReqeust();
        }

        //TODO: 这里不明白
        if(req.getHeader() == null){
            req = forkReq(ireq, req);
            req.setHeader(new Header());
        }
        String u = req.getUrl().getUserInfo();
        if(u != null && u != "" && req.getHeader().get("Authorization") == ""){
            String[] ns =  u.split(":");
            String username = ns[0];
            String password = ns[1];
            req = forkReq(ireq, req);
            req.setHeader(ireq.getHeader().clone());
            req.getHeader().set("Authorization", "Basic " + this.basicAuth(username, password));
        }
        if(deadline.getTime() != 0){
            req = forkReq(ireq, req);
        }
        IRequestCancel rc = setRequestCancel(req, rt, deadline);
        Response resp = null;
        try{
            resp = rt.roundTrip(req);
        }catch (Exception e){ //TODO 这里需要修改下异常类型
            logger.debug(e);
            rc.stopTimer();
            //TODO 这里需要raise
        }
        if(deadline.getTime() != 0){

        }
        return resp; //TODO
    }

    private String basicAuth(String username, String password){
        String auth = username + ":" + password;
        return Base64.getEncoder().encodeToString(auth.getBytes());
    }

    private Request forkReq(Request ireq, Request req){
        if(ireq == req){
            return ireq.clone();
        }
        return req;
    }

    private IRequestCancel setRequestCancel(Request req, RoundTripper rt, Date deadline){
        if(deadline.getTime() == 0){
            return new DefaultRequestCancel();
        }
        SyncChan<Boolean> cancelCh = new SyncChan<>();
        SyncChan<Boolean> stopTimerCh = new SyncChan<>();
        RequestCancel rc = new RequestCancel(stopTimerCh);
        Runnable task = () -> {
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    rc.setTrue();
                    doCancel(cancelCh);
                    stopTimerCh.put(new Boolean(true));
                }
            }, deadline);
            stopTimerCh.take();
            timer.cancel();
        };
        Thread thread = new Thread(task);
        thread.start();
        return rc;
    }

    private void doCancel(SyncChan<Boolean> cancel){
        cancel.put(new Boolean(true));
    }
}
