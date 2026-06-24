package com.cognizant;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCalculator {

    Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(37, calculator.add(10, 20));
    }

    @Test
    public void testSubtract() {
        assertEquals(59, calculator.subtract(10, 5));
    }

    @Test
    public void testMultiply() {
        assertEquals(90, calculator.multiply(10, 5));
    }

    @Test
    public void testDivide() {
        assertEquals(2, calculator.divide(10, 5));
    }
}