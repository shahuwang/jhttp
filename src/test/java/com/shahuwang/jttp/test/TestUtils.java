package com.shahuwang.jttp.test;

import com.shahuwang.jhttp.exceptions.NilURL;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

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

    public void testDatetime(){
        Date d = new Date(0);
        System.out.println(d.getTime() == 0);
        System.out.println(d);
    }

    public void testClone(){
        example em = new example(3);
        example em2 = em.clone();
        System.out.println(em2.a);
    }

    class example implements Cloneable{
        public int a;
        public example(int a){
            this.a = a;
        }
        public example clone(){
            try {
                return (example)super.clone();
            }catch (CloneNotSupportedException e){
                System.out.println(e);
            }
            return null;
        }
    }
}
