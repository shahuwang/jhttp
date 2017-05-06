package com.shahuwang.jhttp;

import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.nio.channels.SocketChannel;

/**
 * Created by rickey on 2017/4/20.
 */
public class Request implements Cloneable{
    private String method;
    private URL url;
    private String proto;
    private int protoMajor;
    private int protoMinor;
    private SocketChannel body;
    private long  contentLength;
    private boolean close;
    private String host;
    private String remoteAddr;
    private String requestURI;
    private Header header;

    private Logger logger = Log.getLogger(this.getClass().getName());
    public void addCookie(Cookie c){
        String s = String.format("%s=%s", c.sanitizeCookieName(c.getName()),
                c.sanitizeCookieValue(c.getValue()));
        String ck = this.header.get("Cookie");
        if(ck != null || ck != ""){
            this.header.set("Cookie", ck + "; " + s);
        }else{
            this.header.set("Cookie", s);
        }
    }

    public String getRequestURI() {
        return requestURI;
    }

    public URL getUrl() {
        return url;
    }

    protected void closeBody(){
        if(this.body != null){
            try {
                this.body.close();
            }catch (IOException e){
                logger.debug(e);
            }
        }
    }

    public Request clone(){
        try {
            Request r = (Request)super.clone();
            return r;
        }catch (CloneNotSupportedException e){
            logger.debug(e);
            return null;
        }
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }
}
