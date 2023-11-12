package PageObjects;

import dev.failsafe.internal.util.Assert;
import org.json.JSONObject;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.network.Network;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.List;
import java.util.Optional;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class MakeMyTripPage {
    WebDriver driver;
    public MakeMyTripPage(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(this.driver,this);
    }
    @FindBy(css="li[data-cy='oneWayTrip'][class='selected']")
    private WebElement defaultTrip;
    @FindBy(css="span.commonModal__close")
    private WebElement closeLoginPopUp;

    @FindBy(id="fromCity")
    private WebElement fromCity;

    @FindBy(id="toCity")
    private WebElement toCity;

    @FindBy(className="listingRhs")
    private WebElement listingRhs;

    @FindBy(css="a[class*='widgetSearchBtn']")
    private WebElement clickSearch;
    @FindBy(css="span[class='linkText pointer']")
    private WebElement expandFlightList;

    @FindBy(css="span[class~='overlayCrossIcon']")
    private List<WebElement> overlayCrossIcon;
    @FindBy(xpath="//span[@class='linkText pointer']/preceding::div[@class='makeFlex spaceBetween appendBottom12']")
    private List<WebElement> flightsLists;
    @FindBy(xpath="//p[text()='Popular Filters']/following::div[4]/label/div/p[@class='checkboxTitle']")
    private WebElement flightTitle;

    @FindBy(xpath="//p[text()='Popular Filters']/following::div[4]/label/span/input[@id='listingFilterCheckbox']")
    private WebElement flightsCheckBox;

    @FindBy(css="div[class='listingCard  appendBottom5']")
    private List<WebElement> listingCard;

    @FindBy(css="#listing-id > div > div.clusterContent > div > div:nth-child(1) > div.listingCard.appendBottom5 > div:nth-child(2) > div.priceSection.priceLockPersuasionExists > div > button")
    private WebElement clickViewPrices;
    @FindBy(css="#listing-id > div > div.clusterContent > div > div:nth-child(1) > div.collapse.show > div > div:nth-child(2) > div > div.make_flex > div.viewFareBtnCol > button")
    private WebElement clickBookingBtn;
    @FindBy(xpath="//div")
    private WebElement journeySection;

    public boolean isOnewayTripSelected() {
        return defaultTrip.isDisplayed();

    }
    public void  overlayCrossIcon(){
        if(overlayCrossIcon.size()>0){
            overlayCrossIcon.get(0).click();
        }

    }
    public boolean isResultsDispalyed() {

        return listingRhs.isDisplayed();

    }
    public void closeLoginPopUp() {
        closeLoginPopUp.isDisplayed();
        closeLoginPopUp.click();

    }
    public void enterFromCity(String string) {
        fromCity.isDisplayed();
        fromCity.click();
        fromCity.sendKeys(string);
    }
    public void enterToCity(String string) {
        toCity.isDisplayed();
        toCity.click();
        toCity.sendKeys(string);
    }
    public void chooseFromCityFromDD(String string) {
        driver.findElement(By.xpath("//p[text()='"+string+"']")).click();

    }
    public void chooseToCityFromDD(String string) {
        driver.findElement(By.xpath("//p[text()='"+string+"']")).click();
    }
    public void chooseTravelDate(String string) {
        driver.findElement(By.cssSelector("div[aria-label='"+string+"']")).click();
    }
    public void clickSearchBtn() {
        clickSearch.isEnabled();
        clickSearch.click();


    }

    public boolean isFlightsCriteriaMatching(){
            expandFlightList.click();
           String title=flightTitle.getText();
           System.out.println(title);
           int flightCount=Integer.parseInt(getStringBetweenTwoCharacters(title, "(", ")"));

           flightsCheckBox.click();

           int flightListing=listingCard.size();
           if(flightCount==flightListing){
               return true;
           }


        return false;
    }

    public static String getStringBetweenTwoCharacters(String input, String to, String from){
        return input.substring(input.indexOf(to)+1,input.indexOf(from));

    }
    public void clickOnViewPricesBtn() {
        clickViewPrices.isEnabled();
        clickViewPrices.click();


    }
    public void clickOnBookingBtn() {
        clickBookingBtn.isEnabled();
        clickBookingBtn.click();


    }
    public boolean isjourneySectionDisplayed() {
        return journeySection.isDisplayed();

    }
}




