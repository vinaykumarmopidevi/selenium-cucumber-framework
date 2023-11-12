package PageObjects;

import Managers.PageObjectManager;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ScandicLoginPage {
    WebDriver driver;
    public ScandicLoginPage(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(this.driver,this);
    }
    @FindBy(css="a[id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll'][class='CybotCookiebotDialogBodyButton']")
    private WebElement acceptCookiesBtn;
    @FindBy(id="widget-search__text")
    private WebElement hotelField;
    @FindBy(className="widget-search__list-item")
    private List<WebElement> chooseHotels;
    @FindBy(id="date-picker")
    private WebElement arrivalDepartureField;

    @FindBy(css = "button[class^='date-picker__apply']")
    private WebElement applyDate;

    @FindBy(xpath = "//button[@class='dp-prev ']/following-sibling::button[@class='dp-next ']")
    private WebElement nextDate;
    @FindBy(css="div.booking-widget__submit.hidden.visible-medium-up-block button")
    private WebElement seeRoomsBtn;



    @FindBy(css=".booking-summary-list__item--checkin__info strong")
    private WebElement checkInDate;
    public String getCheckInDate() {
        return checkInDate.getText();
    }
    @FindBy(css="#booking-summary-checkout strong")
    private WebElement checkOutDate;
    public String getCheckOutDate() {
        return checkOutDate.getText();
    }

    @FindBy(css="#booking-summary-number-of-nights strong")
    private WebElement noOfNights;
    public String getNoOfNights() {
        return noOfNights.getText();
    }
    @FindBy(css=".booking-summary-list__guests span")
    private WebElement noOfGuests;
    public String getNoOfGuests() {
        return noOfGuests.getText();
    }
    @FindBy(id="booking--price--details")
    private WebElement bookingPriceDetails;
    public String getBookingPriceDetails() {
        return bookingPriceDetails.getText();
    }
    @FindBy(className="rateLabel")
    private WebElement rateLabel;
    public String getRateLabel() {
        return rateLabel.getText();
    }
    public boolean isAcceptButtonButtonDisplayed() {
        return acceptCookiesBtn.isEnabled();

    }
    public void clickAcceptButtonButton() {
        acceptCookiesBtn.isEnabled();
        acceptCookiesBtn.click();
    }
    public boolean hotelFiledIsDisplayed() {
        return  hotelField.isDisplayed();
    }
    public void fillHotelAndChooseHotelfromDD(String hotelName) {
        hotelField.isDisplayed();
        hotelField.sendKeys(hotelName);
        for(WebElement element:chooseHotels){
            String attributeValue=element.getAttribute("innerText");
            if(attributeValue.equals(hotelName)){
                element.click();
            }
        }
    }
    public void clickCalanderIcon() {
        arrivalDepartureField.isEnabled();
        arrivalDepartureField.click();
    }
    public void chooseArrivalDate(String arrivalDate) {
        List<WebElement> elements= driver.findElements(By.cssSelector("button[class='dp-day '][data-date-specflow='"+arrivalDate+"']"));
        int count=elements.size();
        while(count==0){
             nextDate.click();
             elements= driver.findElements(By.cssSelector("button[class='dp-day '][data-date-specflow='"+arrivalDate+"']"));
             count=elements.size();
        }
        elements.get(0).click();
    }
    public void chooseDepartureDate(String departureDate) {
        driver.findElement(By.cssSelector("button[class='dp-day '][data-date-specflow='"+departureDate+"']")).click();
    }
    public void clickApplyDate() {
        applyDate.isEnabled();
        applyDate.click();
    }
    public void clickSeeHotelsButton() {
        seeRoomsBtn.isEnabled();
        seeRoomsBtn.click();
    }
    public void chooseRoomType(String rateCode,String roomType) {
        List<WebElement> elements= driver.findElements(By.cssSelector("div[data-text-section-name='"+roomType+"'] button"));
        if(elements.size() > 0){
            for(WebElement element:elements){
               String value= element.getAttribute("data-selectrate");
                System.out.println(value);
                JSONObject json = new JSONObject(value);
                JSONObject data = json.getJSONObject("rate");
                String rateCodeValue = data.getString("rateCode");
                //String roomTypeName = json.getString("roomTypeName");

                if(rateCodeValue.equals(rateCode)){
                    element.click();
                }

            }

        }

    }
}
