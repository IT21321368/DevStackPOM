package pom.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.pages.MobileSearchPage;
import pom.utils.ThreadLocalWebDriver;

public class SearchTest {
    private MobileSearchPage mobileSearchPage;

    @BeforeMethod
    public void setup(){
        WebDriver driver = ThreadLocalWebDriver.createWebDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        mobileSearchPage = new MobileSearchPage(driver);

    }

    @Test
    public void searchForIphone(){
        mobileSearchPage.searchMobile("iphone");
    }

    public void tearDown(){
        WebDriver webDriver = ThreadLocalWebDriver.getWebDriver();
        if(webDriver != null){
            webDriver.quit();
            ThreadLocalWebDriver.removeWebDriver();
        }
    }
}
