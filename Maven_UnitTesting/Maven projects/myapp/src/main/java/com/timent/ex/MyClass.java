package com.timent.ex;

/**
 * Created by Andrei.Vasiliu on 7/10/2017.
 */
public class MyClass {

    public String concatenate(String one, String two){
        if(one==null)
            return two;
        else
            if (two==null)
            { return one;}
            return one+two;
    }
    public boolean getBoolean(){
        return new java.util.Random().nextBoolean();
    }

}
