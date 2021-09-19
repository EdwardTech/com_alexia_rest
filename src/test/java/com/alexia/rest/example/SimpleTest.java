package com.alexia.rest.example;

import org.junit.Assert;
import org.junit.Test;

public class SimpleTest {
    @Test
    public void test() {
        int a = 1;
        int b = 14;

        Assert.assertEquals(15, a + 15);
    }
}
