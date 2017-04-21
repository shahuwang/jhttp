package com.shahuwang.jhttp;

import com.shahuwang.jhttp.exceptions.NilTransport;
import com.shahuwang.jhttp.exceptions.NilURL;
import com.shahuwang.jhttp.exceptions.RequestURInReqeust;

import java.time.Duration;
import java.util.Date;

/**
 * Created by shahuwang on 2017/4/20.
 */
public class Client {
    RoundTripper transport;
    CheckRedirect checkRedirect;
    CookieJar jar;
    Duration timeout;

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

    private Response send(Request req, RoundTripper rt, Date deadline)throws NilTransport, NilURL, RequestURInReqeust{
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
        return null; //TODO
    }
}
