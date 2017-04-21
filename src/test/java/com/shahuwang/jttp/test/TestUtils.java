package com.shahuwang.jttp.test;

import com.shahuwang.jhttp.exceptions.NilURL;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by shahuwang on 2017/4/21.
 */
public class TestUtils extends TestCase{
    public void testArray(){
        boolean[] a = new boolean[3];
        System.out.println(Arrays.toString(a));
        NilURL e = new NilURL();
        try {
            throw e;
        }catch (NilURL ex){
            System.out.println(ex);
        }
    }
}
