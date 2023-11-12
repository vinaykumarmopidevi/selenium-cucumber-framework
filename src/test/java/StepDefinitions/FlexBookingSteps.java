package StepDefinitions;

import PageObjects.ScandicLoginPage;
import Utilities.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class FlexBookingSteps {

    TestContext testContext;
    ScandicLoginPage scandicLoginPage;
    public FlexBookingSteps(TestContext context){
        testContext=context;
        scandicLoginPage=testContext.getPageObjectManager().getScandicLoginPage();

    }

    @Given("Scandic home page")
    public void scandic_home_page() {
        Assert.assertTrue(scandicLoginPage.isAcceptButtonButtonDisplayed(),"Scandic home is displayed");
    }
    @Then("Accept all cooking of the website")
    public void accept_all_cooking_of_the_website() {
       scandicLoginPage.clickAcceptButtonButton();
    }

    @When("I enter hotel {string} name")
    public void i_enter_hotel_name(String string) {
        scandicLoginPage.fillHotelAndChooseHotelfromDD("Scandic Alvik");
    }
    String arrDate, depDate=null;
    @When("I choose the arrival date {string} and  departure  date {string} from calendar")
    public void i_choose_the_arrival_date_and_departure_date_from_calendar(String arrivalDate, String departureDate) {
        scandicLoginPage.clickCalanderIcon();
        arrDate=arrivalDate;
        scandicLoginPage.chooseArrivalDate(arrivalDate);
        depDate=departureDate;
        scandicLoginPage.chooseDepartureDate(departureDate);
    }
    @When("I click on See rooms and prices button")
    public void i_click_on_see_rooms_and_prices_button() {
        scandicLoginPage.clickSeeHotelsButton();
    }


    @When("I click on rate code {string} button for room type {string} from the list room types")
    public void i_click_on_flex_button_for_room_type_from_the_list_room_types(String rateCode,String roomType) {
        scandicLoginPage.chooseRoomType(rateCode,roomType);
    }
    @Then("I validate the enter details page")
    public void i_validate_the_enter_details_page() {

        System.out.println(scandicLoginPage.getCheckInDate());
        System.out.println(scandicLoginPage.getCheckOutDate());
        System.out.println(scandicLoginPage.getNoOfNights());
        System.out.println(scandicLoginPage.getNoOfGuests());
        System.out.println(scandicLoginPage.getBookingPriceDetails());
        System.out.println(scandicLoginPage.getRateLabel());
    }
}
