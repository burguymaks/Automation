package com.dice;

import com.dice.base.BaseTest;
import org.testng.annotations.Test;

public class SecondTest extends BaseTest {

    @Test
    public void secondTestMethod() {
        // open linkedin.com
        driver.get("http://www.linkedin.com");
        System.out.println("Linkedin Opened. Test passed!");
    }
}
