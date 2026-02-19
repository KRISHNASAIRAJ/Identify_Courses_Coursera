package testcases;

import basetest.BaseTest;
import org.testng.annotations.Test;
import pageObjects.Base;

import java.io.IOException;

public class TC_030 extends BaseTest {
    @Test
    void test() throws IOException {
        Base base=new Base(driver,wait);
        base.test();
    }
}
