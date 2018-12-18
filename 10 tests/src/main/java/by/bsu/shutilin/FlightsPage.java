package by.bsu.shutilin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightsPage {
    private final static int DEFAULT_TIMEOUT = 5;

    private final WebDriver driver;
    private final WebDriverWait wait;
    private HomePageForm homePageForm;


    public FlightsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
    }

    By loaderEnd = By.id("loader-end");
    By selectFlightBtn = By.xpath("//button[contains(text(),'CONFIRM SELECTION ')]");
    By currencyPicklist = By.id("search-currency-change");
    By currencySuffix = By.className("result-fare-suffix");
    By airlineCheckbox = By.xpath("/html/body/main/section[4]/div/div[4]/div[1]/div/div[6]/div/div[1]/div");
    By airlinesInfo = By.xpath("/html/body/main/section[4]/div/div[4]/div[2]/div[3]/div[7]/div[2]/div[2]/div[1]/div[4]/div[1]");
    By cookiesAccept = By.id("gdpr-cookie-accept");

    public void getFlightsThroughHomePage() {
        HomePageForm homePageForm = PageFactory.initElements(driver, HomePageForm.class);
        acceptCookies();
        homePageForm.populateArrivalInput("Moscow");
        homePageForm.populateDepartureInput("Minsk");
        homePageForm.submitForm();

        waitLoadEnd();
    }

    private void waitLoadEnd() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loaderEnd));
    }

    public void selectFlight() {
        driver.findElement(selectFlightBtn).click();
    }

    public String selectCurrency(String currencyContext) {
        Select currencySelector = new Select(driver.findElement(currencyPicklist));
        currencySelector.selectByVisibleText(currencyContext);

        waitLoadEnd();
        return driver.findElement(currencySuffix).getText();
    }

    public String filterByAirlines() {
        wait.until(ExpectedConditions.elementToBeClickable(airlineCheckbox));
        driver.findElement(airlineCheckbox).click();
        waitLoadEnd();

        return driver.findElement(airlinesInfo).getText();

    }

    public void acceptCookies() {
        driver.findElement(cookiesAccept).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getAlertMessage() {
        Alert sameDestinationAlert = driver.switchTo().alert();
        String alertMessage = sameDestinationAlert.getText();
        sameDestinationAlert.accept();

        return alertMessage;
    }
}
