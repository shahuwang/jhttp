package com.shahuwang.jhttp;

import java.util.function.Function;

/**
 * Created by shahuwang on 2017/4/21.
 */
public class Utils {
    private boolean[] isTokenTable= new boolean[127];
    private static Utils instance = null;
    private Utils(){
        putToken("!#$%&\'*+-.0123456789ABCDEFGHIJKLMNOPQRSTUWVXYZ^_`abcdefghijklmnopqrstuvwxyz|~");
    }

    public static Utils getInstance(){
        if(instance==null){
            instance = new Utils();
        }
        return instance;
    }

    public boolean isToken(char c){
        int i = (int)c;
        return i < this.isTokenTable.length && isTokenTable[i];
    }

    public boolean indexFunc(String s, Function<Character, Boolean> f){
        for(int i=0; i<s.length(); i++){
            char k = s.charAt(i);
            Character c = new Character(k);
            if(f.apply(c)){
                return true;
            }
        }
        return false;
    }

    private void putToken(String tokens){
        for(int i=0; i<tokens.length(); i++){
            char c = tokens.charAt(i);
            isTokenTable[(int)c] = true;
        }
    }
}
