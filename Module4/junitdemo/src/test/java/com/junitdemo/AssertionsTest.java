package com.junitdemo;

import org.junit.Test;

import static org.junit.Assert.*;

public class AssertionsTest {

    @Test

    public void testAssertions() {

        // Equal check

        assertEquals(5, 2 + 3);

        // True condition

        assertTrue(10 > 5);

        // False condition

        assertFalse(5 > 10);

        // Null check

        assertNull(null);

        // Object exists check

        assertNotNull(new Object());

    }

}