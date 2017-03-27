package com.linewow.xhyy.testbasic2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by LXR on 2017/1/2.
 */
public class CalculatorTest {
    private Calculator calculator;
    @Before
    public void setUp()throws Exception{
        calculator=new Calculator();
    }

    @Test
    public void sum() throws Exception {
        assertEquals(6,calculator.sum(1,5));
    }

    @Test
    public void getName() throws Exception {
        assertEquals("name",calculator.getName("name"));
    }

    @Test
    public void divide() throws Exception {
        assertTrue(calculator.divide());
    }

    @Test
    public void multiply() throws Exception {

    }

}