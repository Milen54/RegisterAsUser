package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.base.WebApp;

public class BaseTest {

    protected WebDriver driver;
    protected WebApp webApp;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://auto.pragmatic.bg/index.php?route=common/home&language=en-gb");
        webApp = new WebApp(driver);
    }

//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }
}
