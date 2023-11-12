package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceLoginPage {
    public SauceLoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCartContainer;

    @FindBy(className = "app_logo")
    private WebElement appLogo;

    public boolean SauceLoginPageIsDisplayed() {
        usernameInput.isDisplayed();
        passwordInput.isDisplayed();
        loginBtn.isDisplayed();
        return true;
    }
    public void enterUserName(String username) {
        usernameInput.isDisplayed();
        usernameInput.sendKeys(username);

    }
    public void enterPassword(String password) {
        passwordInput.isDisplayed();
        passwordInput.sendKeys(password);

    }
    public void ClickOnLoginButton() {
        loginBtn.isDisplayed();
        loginBtn.click();
    }

    public boolean verifyLandingPage(){
        shoppingCartContainer.isDisplayed();
        appLogo.isDisplayed();
        return true;
    }

}
