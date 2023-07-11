package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.BrowserUtil;
import utilities.DriverUtil;

public class Hooks extends BrowserUtil {
// set up and tear down methods for our tests
    @Before
    public void setUp(){
        DriverUtil.getDriver().manage().window().maximize();
        System.out.println("Driver successfully started");
    }

    @After
    public void tearDown(){
        DriverUtil.closeDriver();
    }


}
