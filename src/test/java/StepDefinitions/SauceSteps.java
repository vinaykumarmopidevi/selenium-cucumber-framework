package StepDefinitions;


import PageObjects.SauceLoginPage;
import Utilities.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SauceSteps {

    TestContext testContext;
    SauceLoginPage sauceLoginPage;
    public SauceSteps(TestContext context){
        testContext=context;
        sauceLoginPage=testContext.getPageObjectManager().getSauceLoginPage();

    }
    @Given("Sauce home page")
    public void sauce_home_page() {
        Assert.assertEquals(sauceLoginPage.SauceLoginPageIsDisplayed(),true);
    }
    @Then("I entered the username {string} in filed")
    public void i_entered_the_username_in_filed(String string) {
        sauceLoginPage.enterUserName(string);
    }
    @Then("I entered the password {string} in filed")
    public void i_entered_the_password_in_filed(String string) {
        sauceLoginPage.enterPassword(string);
    }
    @Then("I click on login button")
    public void i_click_on_login_button() {
        sauceLoginPage.ClickOnLoginButton();
    }
    @Then("I verified the logo and shopping card link in the page")
    public void i_verified_the_logo_and_shopping_card_link_in_the_page() {
        sauceLoginPage.verifyLandingPage();
    }
}
