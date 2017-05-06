package com.shahuwang.jhttp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shahuwang on 2017/4/21.
 */
public class Header implements Cloneable{
    private HashMap<String, List<String>> h = new HashMap<>();
    public String get(String key){
        //TODO
        return null;
    }

    public String set(String key, String value){
        //TODO
        return null;
    }

    public Header clone(){
        Header header = new Header();
        for(Map.Entry<String, List<String>> e: this.h.entrySet()){
            String key = e.getKey();
            List<String> value = e.getValue();
            List<String> nv = new ArrayList<>(value.size());
            nv.addAll(value);
            header.h.put(key, nv);
        }
        return header;
    }
}
