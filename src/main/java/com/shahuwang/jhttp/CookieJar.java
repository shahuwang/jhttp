package com.shahuwang.jhttp;

import java.net.URL;

/**
 * Created by shahuwang on 2017/4/20.
 */
public interface CookieJar {
    public void setCookies(URL u, Cookie[] cookies);
    public Cookie [] cookies(URL u);
}
