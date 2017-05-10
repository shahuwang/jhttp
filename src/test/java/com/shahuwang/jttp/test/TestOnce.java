package com.shahuwang.jttp.test;

import com.shahuwang.jhttp.Once;
import junit.framework.TestCase;

/**
 * Created by shahuwang on 2017/5/11.
 */
public class TestOnce extends TestCase{
    public void testOnce(){
        Once once = new Once();
        once.Do(() -> {System.out.println("hello world");});
    }
}
