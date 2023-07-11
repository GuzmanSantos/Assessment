package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtil {
    private static WebDriver driver = null;

    private DriverUtil() {
    }

    public static synchronized WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigurationsReader.getProperties("browser")) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(options);
                    break;
                    // added firefox just to have multiple browser options to use configuration properties
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
            }
        }
        return driver;
    }


    public static void closeDriver(){
        if (driver!=null){
            driver.quit();
            driver = null;
        }

    }

}
