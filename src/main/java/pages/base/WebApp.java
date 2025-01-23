package pages.base;

import org.openqa.selenium.WebDriver;
import pages.admin.HomePage;
import pages.admin.RegisterPage;
import pages.admin.SuccessPage;

public class WebApp {

    private WebDriver driver;
    public RegisterPage registerPage;
    private BasePage basePage;
    private HomePage homePage;
    private SuccessPage successPage;

    public WebApp(WebDriver driver) {
        this.driver = driver;
        this.registerPage = new RegisterPage(driver); // Инициализираме registerPage тук

    }


    public RegisterPage registerPage() {
        if(registerPage == null){
            registerPage = new RegisterPage(driver);
        }
        return registerPage;
    }

    public BasePage basePage() {
        if (basePage == null) { // Проверяваш полето, а не метода
            basePage = new BasePage(driver);
        }
        return basePage;
    }

    public HomePage homePage() {
        if (homePage == null) {
            homePage = new HomePage(driver);
        }
        return homePage;
    }

    public SuccessPage successPage(){
        if (successPage == null) {
            successPage = new SuccessPage(driver);
        }
        return successPage;
    }


}
