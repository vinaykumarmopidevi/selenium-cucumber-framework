package PageObjects;

import net.bytebuddy.pool.TypePool;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {

    public HomePage(WebDriver webDriver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 15), this);
    }

    @FindBy(className = "logo-bhinneka")
    private WebElement headerLogoButton;

    @FindBy(className ="search-query")
    private WebElement searchInput;
    @FindBy(xpath ="/html/body/div[1]/header/nav/div[3]/div[2]/form/div[2]/a[1]/div/div/div[1]")
    private WebElement searchButton;
    @FindBy(className = "bmd-btn-cart")
    private WebElement cartButton;

    @FindBy(id = "copyrightWrapper")
    private WebElement bhinnekaCopyrightFooter;

    @FindBy(className = "bmd-login-button")
    private WebElement loginButton;

    @FindBy(xpath = "/html/body/div[1]/main/div/section/div[2]/div[2]/h1")
    private WebElement searchProductLink;

    @FindBy(xpath = "//*[invalid locators]")
    private WebElement invalidLocators;

    public boolean defaultHomePageIsDisplayed() {
        headerLogoButton.isDisplayed();
        searchInput.isDisplayed();
        cartButton.isDisplayed();
        bhinnekaCopyrightFooter.isDisplayed();
        return true;
    }

    public void clickLoginButton() {
        loginButton.isDisplayed();
        loginButton.isEnabled();
        loginButton.click();
    }

    public void clickCartButton() {
        cartButton.isEnabled();
        cartButton.click();
    }

    public void setSearchInput(String product)  {
        searchInput.isEnabled();
        searchInput.click();
        String value= "";
        for (char index = 0; index < product.chars().count(); index++)
        {
            String str= String.valueOf(product.charAt(index));
            value=value+str;
            searchInput.clear();
            searchInput.sendKeys(value);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        //searchButton.click();
    }

    public String getSearchProductLink() {
        searchProductLink.isDisplayed();
        return searchProductLink.getText();
    }

    public void getInvalidLocators() {
        invalidLocators.isDisplayed();
    }

    public void searchProductData(String product) {

        setSearchInput(product);
        searchInput.sendKeys(Keys.ENTER);
    }
}
