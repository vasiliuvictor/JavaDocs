package com.timent.ex;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Andrei.Vasiliu on 7/10/2017.
 */
public class MyUnitTest {
    @Test
    public void testConcatenate(){
        MyClass myUnit = new MyClass();

        String result = myUnit.concatenate("one","two");

        assertEquals("onetwo",result);
    }

    @Test
    public void testConcatenateNull(){
        MyClass unit = new MyClass();

        String result = unit.concatenate(null,null);
        assertEquals(null,result);

        result=unit.concatenate("one",null);
        assertNotNull(result);
        assertEquals("one",result);
    }

    @Test
    public void testGetBoolean(){
        MyClass myUnit = new MyClass();
        assertTrue(myUnit.getBoolean());
    }

}
