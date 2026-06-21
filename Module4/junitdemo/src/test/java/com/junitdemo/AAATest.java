package com.junitdemo;

import org.junit.*;

import static org.junit.Assert.*;

public class AAATest {

    Calculator calculator;

    @Before

    public void setup() {

        calculator = new Calculator();

        System.out.println(
                "Before each test");

    }

    @After

    public void tearDown() {

        System.out.println(
                "After each test");

    }

    @Test

    public void testAddition() {

        // Arrange

        int a = 10;

        int b = 15;

        // Act

        int result = calculator.add(a, b);

        // Assert

        assertEquals(
                25,
                result);

    }

}