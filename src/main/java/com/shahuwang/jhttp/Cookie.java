package com.shahuwang.jhttp;

import java.util.Date;
import java.util.function.Function;

/**
 * Created by shahuwang on 2017/4/20.
 */
public class Cookie {
    private String name;
    private String value;
    private String path;
    private String domain;
    private Date expires;
    private String rawExpires;
    private int maxAge;
    private boolean secure;
    private boolean httpOnly;
    private String raw;
    private String[] unparsed;

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    protected String sanitizeCookieName(String name){
        name = name.replaceAll("\n", "-");
        name = name.replaceAll("\r", "-");
        return name;
    }

    protected String sanitizeCookieValue(String v){
        String w = sanitizeOrWarn("Cookie.Value", (Byte b) -> validCookieValueByte(b.byteValue()), v);
        if(w.length() == 0){
            return w;
        }
        if(w.charAt(0) == ' ' || w.charAt(0) == ',' || w.charAt(w.length() -1) == ' ' || w.charAt(w.length() -1) == ','){
            return "\"" + w + "\"";
        }
        return w;
    }

    protected String sanitizeCookiePaht(String v){
        return sanitizeOrWarn("Cookie.Path", (Byte b) -> validCookieValueByte(b.byteValue()), v);
    }

    protected String sanitizeOrWarn(String fieldName, Function<Byte, Boolean> valid, String v){
        boolean ok = true;
        byte[] bytes = v.getBytes();
        for(int i=0; i<v.length(); i++){
            if(valid.apply(new Byte(bytes[i]))){
                continue;
            }
            ok = false;
            break;
        }
        if(ok){
            return v;
        }
        StringBuilder buf = new StringBuilder(v.length());
        for(int i=0; i<v.length(); i++){
            byte b = bytes[i];
            if(valid.apply(new Byte(b))){
                buf.append(b);
            }
        }
        return buf.toString();
    }

    protected boolean isCookieNameValid(String raw){
        if(raw == ""){
            return false;
        }
        return Utils.getInstance().indexFunc(raw,
                (Character c) -> Utils.getInstance().isToken(c.charValue()));
    }

    private boolean validCookieValueByte(byte b){
        return 0x20 <= b && b < 0x7f && b != '"' && b != ';' && b != '\\';
    }
}
