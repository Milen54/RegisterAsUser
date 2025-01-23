package pages.admin;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;

import java.time.Duration;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "input-firstname")
    private WebElement firstNameField;

    @FindBy (id = "input-lastname")
    private WebElement lastNameField;

    @FindBy (id = "input-email")
    private WebElement emailField;

    @FindBy (id = "input-password")
    private WebElement passwordField;

    @FindBy (xpath = "//input[@name='agree']")
    private WebElement policyAgree;

    @FindBy (xpath = "//button[@type='submit']")
    private WebElement continueButton;

    public void fillRegistrationForm(String firstname, String lastname, String email, String password){
        typeText(firstNameField, firstname);
        typeText(lastNameField, lastname);
        typeText(emailField, email);
        typeText(passwordField, password);
    }

    public void clickAgreeCheckBoxUsingJs() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(policyAgree));
        scrollToElement(policyAgree);
        clickUsingJs(policyAgree);
    }

    public void clickContinueUsingJs() {
        clickUsingJs(continueButton);
    }
}
