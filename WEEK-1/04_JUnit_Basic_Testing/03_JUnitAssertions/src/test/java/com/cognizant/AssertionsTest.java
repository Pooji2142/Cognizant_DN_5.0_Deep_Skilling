package com.cognizant;

import static org.junit.Assert.*;

import org.junit.Test;

public class AssertionsTest {

    @Test
    public void testAssertions() {

        // Assert Equals
        assertEquals(6, 2 + 3);

        // Assert True
        assertTrue(5 > 3);

        // Assert False
        assertFalse(5 < 3);

        // Assert Null
        assertNull(null);

        // Assert Not Null
        assertNotNull(new Object());

        // Assert Same
        String str = "JUnit";
        assertSame(str, str);

        // Assert Not Same
        assertNotSame(new String("JUnit"), new String("JUnit"));
    }
}