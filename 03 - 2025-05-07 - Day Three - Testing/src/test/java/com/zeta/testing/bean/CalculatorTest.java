package com.zeta.testing.bean;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    private static Calculator calculator;

    @BeforeAll public static void setUp() { calculator = new Calculator(); }

    @Test public void testAddition() {
        assertEquals(2, calculator.calculate(1, 1, '+'));
    }

    @Test public void testSubtraction() {
        assertEquals(0, calculator.calculate(1, 1, '-'));
    }

    @Test public void testMultiplication() {
        assertEquals(1, calculator.calculate(1, 1, '*'));
    }

    @Test public void testDivision() {
        assertEquals(1, calculator.calculate(1, 1, '/'));
    }

    @AfterAll public static void tearDown() { calculator = null; }

}
