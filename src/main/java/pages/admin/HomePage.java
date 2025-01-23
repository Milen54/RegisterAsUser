package pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement buttonMyAccount;

    @FindBy(xpath = "//a[text()='Register']")
    private WebElement registerButton;

    public void clickMyAccount(){
        buttonMyAccount.click();
    }

    public void clickRegister() {
        registerButton.click();
    }

}
