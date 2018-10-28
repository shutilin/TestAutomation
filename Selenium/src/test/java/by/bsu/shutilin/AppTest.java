package by.bsu.shutilin;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AppTest {

    /*
        TESTCASE: Check for selecting same airports for from/to fields
        EXPECTED: Alert message
     */
    @Test
    public void test1() {
        WebDriver webDriver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 5);

        webDriver.get("https://www.alternativeairlines.com/");

        //Wait for 10 seconds for page loading (otherwise TimeoutException)
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        populateAirportsFields("flight-search-arrival-input", webDriver, wait);
        populateAirportsFields("flight-search-departure-input", webDriver, wait);

        //Submit form
        webDriver.findElement(By.name("submit")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flight-search-form-button-pm"))).click();

        //Catch alert
        Alert sameDestinationAlert = webDriver.switchTo().alert();
        String alertMessage = sameDestinationAlert.getText();
        sameDestinationAlert.accept();

        webDriver.close();

        Assert.assertEquals("Origin and destination cannot be the same", alertMessage);

    }

    private static void populateAirportsFields(String inputId, WebDriver webDriver, WebDriverWait wait) {
        WebElement airportInput = webDriver.findElement(By.id(inputId));
        airportInput.sendKeys("Moscow Domodedovo");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("autocomplete-suggestion"))).click();
    }

}
