package StepDefinitions;

import PageObjects.MakeMyTripPage;
import PageObjects.ScandicLoginPage;
import Utilities.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MakeMyTripSteps {

    TestContext testContext;
    MakeMyTripPage makeMyTripPage;
    public MakeMyTripSteps(TestContext context){
        testContext=context;
        makeMyTripPage=testContext.getPageObjectManager().getMakeMyTripPage();

    }

    @Given("makemytrip home page")
    public void makemytrip_home_page() {
        Assert.assertEquals(makeMyTripPage.isOnewayTripSelected(),true);
    }
    @Then("I closed login popup page")
    public void i_closed_login_popup_page() {
        makeMyTripPage.closeLoginPopUp();
    }
    @Then("I entered the from {string} city")
    public void i_entered_the_from_city(String string) {
        makeMyTripPage.enterFromCity(string);
    }
    @Then("I choose the from {string} city from drop down")
    public void i_choose_the_from_city_from_drop_down(String string) {
        makeMyTripPage.chooseFromCityFromDD(string);
    }
    @Then("I entered the to {string} city")
    public void i_entered_the_to_city(String string) {
        makeMyTripPage.enterToCity(string);
    }
    @Then("I choose the to {string} city from drop down")
    public void i_choose_the_to_city_from_drop_down(String string) {
        makeMyTripPage.chooseToCityFromDD(string);
    }
    @Then("I choose the travelling date {string} from calender")
    public void i_choose_the_travelling_date_from_calender(String string) {
        makeMyTripPage.chooseTravelDate(string);
    }
    @Then("I search button")
    public void i_search_button() {
        makeMyTripPage.clickSearchBtn();
    }
    @Then("I click on the overlay Cross Icon")
    public void i_click_on_the_overlay_cross_icon() {
        makeMyTripPage.overlayCrossIcon();
    }
    @Then("I verify search results are displayed")
    public void i_verify_search_results_are_displayed() {
        Assert.assertEquals(makeMyTripPage.isResultsDispalyed(),true);
        Assert.assertEquals( makeMyTripPage.isFlightsCriteriaMatching(),true);

    }
    @Then("I click on view prices button for first item on the list")
    public void i_click_on_view_prices_button_for_first_item_on_the_list() {
        makeMyTripPage.clickOnViewPricesBtn();
    }
    @Then("I click on view booking button")
    public void i_click_on_view_booking_button() {
        makeMyTripPage.clickOnBookingBtn();
    }
    @Then("I verify journey section")
    public void i_verify_journey_section() {
        makeMyTripPage.isjourneySectionDisplayed();
    }
}
