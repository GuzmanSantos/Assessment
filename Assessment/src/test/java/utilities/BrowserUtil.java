package utilities;


import java.util.concurrent.TimeUnit;

public class BrowserUtil {
    public static void setWaitTime(){
        DriverUtil.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

}
