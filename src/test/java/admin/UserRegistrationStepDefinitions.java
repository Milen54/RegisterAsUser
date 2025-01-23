package admin;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.base.WebApp;
import utils.RandomEmailGenerator;

public class UserRegistrationStepDefinitions {

    private WebDriver driver;
    private WebApp webApp;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        webApp = new WebApp(driver); // Инициализирай webApp тук

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        driver.get("https://auto.pragmatic.bg/index.php?route=common/home&language=en-gb");
    }

    @When("I click on 'My Account' and then 'Register'")
    public void iClickOnMyAccountAndThenRegister() {
        webApp.homePage().clickMyAccount();
        webApp.homePage().clickRegister();
    }

    @When("I fill in the registration form with valid data")
    public void IFillInTheRegistrationFormWithValidData () {
        String randomEmail = RandomEmailGenerator.generateRandomEmail();
        webApp.registerPage.fillRegistrationForm("Milen", "Denkov", randomEmail, "parola123!");
    }

    @When("I accept the privacy policy")
    public void iAcceptThePrivacyPolicy () {
        webApp.registerPage.clickAgreeCheckBoxUsingJs();
    }

    @When("I submit the form")
    public void iSubmitTheForm() {
        webApp.registerPage.clickContinueUsingJs();
    }

    @Then("I should see the success page with the message {string}")
    public void iShouldSeeTheSuccessPageWithTheMessage(String expectedMessage) {
        webApp.successPage().verifyUrlContains("success&language");
        webApp.successPage().verifySuccessMessage(expectedMessage);
    }
}
