package com.shahuwang.jhttp;

import java.net.URL;
import java.nio.channels.SocketChannel;

/**
 * Created by rickey on 2017/4/20.
 */
public class Request {
    private String method;
    private URL url;
    private String proto;
    private int protoMajor;
    private int protoMinor;
    private Header header;
    private SocketChannel body;
    private long  contentLength;
    private boolean close;
    private String host;
    private String remoteAddr;
    private String requestURI;

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

}
