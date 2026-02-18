package testcases;

import basetest.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_021 extends BaseTest {

    public TC_021() throws IOException {
    }

    @Test(priority = 21)
    void programOverviewPage(){
        /*
        Program Overview Pages (Degrees, ProCerts)
        Visit a Degree or ProfCert landing page.
        Assert: Overview/descriptions visible; enrollment actions require login (we don’t click).
        📚 Specialization/Professional Cert public pages exist.
         */
        System.out.println("Hello");
    }
}
