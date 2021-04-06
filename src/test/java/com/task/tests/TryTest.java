package com.task.tests;

import org.testng.annotations.Test;

public class TryTest {

    @Test()
    public void test() {
        System.out.println(System.getProperty("user.dir") +"\\images\\tweet1.png");
    }
}
