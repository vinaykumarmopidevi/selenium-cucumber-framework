package Managers;

import PageObjects.*;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private final WebDriver webDriver;
    private HomePage homePage;
    private LoginPage loginPage;
    private ProductListPage productListPage;
    private ProductDetailPage productDetailPage;
    private ScandicLoginPage scandicLoginPage;
    private MakeMyTripPage makeMyTripPage;
    private SauceLoginPage sauceLoginPage;
    public PageObjectManager(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //Short Hand If...Else
    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(webDriver) : homePage;
    }

    //General If...Else
    public LoginPage getLoginPage() {

        if (loginPage == null) {
            loginPage = new LoginPage(webDriver);
        }
        return loginPage;
    }

    public ProductListPage getProductListPage() {
        return (productListPage == null) ? productListPage = new ProductListPage(webDriver) : productListPage;
    }

    public ProductDetailPage getProductDetailPage() {
        if (productDetailPage == null) productDetailPage = new ProductDetailPage(webDriver);
        return productDetailPage;
    }

    public ScandicLoginPage getScandicLoginPage() {

        if (scandicLoginPage == null) {
            scandicLoginPage = new ScandicLoginPage(webDriver);
        }
        return scandicLoginPage;
    }
    public MakeMyTripPage getMakeMyTripPage() {

        if (makeMyTripPage == null) {
            makeMyTripPage = new MakeMyTripPage(webDriver);
        }
        return makeMyTripPage;
    }
    public SauceLoginPage getSauceLoginPage() {

        if (sauceLoginPage == null) {
            sauceLoginPage = new SauceLoginPage(webDriver);
        }
        return sauceLoginPage;
    }
}
