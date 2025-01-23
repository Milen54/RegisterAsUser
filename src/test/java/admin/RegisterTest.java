package admin;

import base.BaseTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.base.WebApp;
import utils.RandomEmailGenerator;

import java.time.Duration;

public class RegisterTest extends BaseTest {
    private WebDriverWait wait;

    @Test
    public void testUserRegistration() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebApp webApp = new WebApp(driver);

        // Click on 'My Account'
        webApp.homePage().clickMyAccount();
        // Click on 'Register'
        webApp.homePage().clickRegister();

        // Generating random email
        String randomEmail = RandomEmailGenerator.generateRandomEmail();
        System.out.println("Имейлът е: " + randomEmail);

        // Fill registration form
        webApp.registerPage().fillRegistrationForm("Milen", "Denkov", randomEmail, "parola123!");

        // Accept 'Privacy Policy'
        webApp.registerPage().clickAgreeCheckBoxUsingJs();

        // Submit registration, click on 'Continue' button
        webApp.registerPage().clickContinueUsingJs();

        String partialUrl = "https://auto.pragmatic.bg/index.php?route=account/success&language=en-gb";
        wait.until(ExpectedConditions.urlContains("success&language"));

        String currentUrl = driver.getCurrentUrl();
        // Assert if we are on the final page
        //Assert.assertTrue(currentUrl.contains(partialUrl), "Не сте на правилната страница!");

        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='col']/h1"));
        String actualText = actualTextElement.getText();
        System.out.println(actualText);
        String expectedText = "Your Account Has Been Created!";
        // Assert if the displayed text is equals
        //Assert.assertEquals(actualText, expectedText, "Неуспешно създаване на акаунт!");
    }
}
