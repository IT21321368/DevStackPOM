package pom.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class ThreadLocalWebDriver {
    private static ThreadLocal<WebDriver> treadLocalWebDriver = new ThreadLocal<>();

    public static synchronized WebDriver createWebDriver(){
        WebDriver driver = WebDriverManager.chromedriver().create();
        treadLocalWebDriver.set(driver);
        return driver;
    }

    public static synchronized WebDriver getWebDriver(){
        return treadLocalWebDriver.get();
    }

    public static synchronized void removeWebDriver(){
        treadLocalWebDriver.remove();
    }
}
