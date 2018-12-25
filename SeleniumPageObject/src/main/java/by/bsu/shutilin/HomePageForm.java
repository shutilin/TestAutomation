package by.bsu.shutilin;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageForm {

    private final String BASE_URL = "https://www.alternativeairlines.com/";
    private final int DEFAULT_TIMEOUT = 5;

    private final WebDriver driver;
    private final WebDriverWait wait;


    public HomePageForm(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        PageFactory.initElements(this.driver, this);
    }


    By arrivalInput = By.id("flight-search-arrival-input");
    By departureInput = By.id("flight-search-departure-input");
    By travellersToggle = By.id("flight-search-travellers-toggle");
    By travellersToggleAdultsPlus = By.xpath("//*[@id=\"flight-search-form-hj\"]/section[2]/div[3]/div/div[1]/div[2]/div/button[2]");
    By submitButton = By.name("submit");
    By confirmSubmit = By.id("flight-search-form-button-pm");
    By suggestionAutocomplete = By.className("autocomplete-suggestion");

    public void openPage() {
        driver.navigate().to(BASE_URL);
    }

    public void populateArrivalInput(String countryName) {
        driver.findElement(arrivalInput).sendKeys(countryName);
        waitSuggestion();
    }

    public void populateDepartureInput(String countryName) {
        driver.findElement(departureInput).sendKeys(countryName);
        waitSuggestion();
    }

    private void waitSuggestion() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(suggestionAutocomplete)).click();
    }

    public void addAdults(int adultsNumber) {
        driver.findElement(travellersToggle).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(travellersToggleAdultsPlus));

        for (int i = 0; i < adultsNumber; i++) {
            driver.findElement(travellersToggleAdultsPlus).click();
        }
    }

    public void submitForm() {
        driver.findElement(submitButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmSubmit)).click();
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
