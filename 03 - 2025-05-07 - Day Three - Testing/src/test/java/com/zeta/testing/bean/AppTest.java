package com.zeta.testing.bean;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test public void concatAndConvertString() {
        System.out.println("AppTest : concatAndConvertString");
        String expected = "HELLOWORLD";
        App app = new App();
        String actual = app.concatAndConvertString("Hello", "World");
        assertEquals(expected, actual);
    }

}