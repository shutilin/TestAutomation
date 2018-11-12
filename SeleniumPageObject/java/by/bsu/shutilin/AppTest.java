package by.bsu.shutilin;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class AppTest {

    /*
        TESTCASE: Check for selecting same airports for from/to fields
        EXPECTED: Alert message
     */
    @Test
    public void catchAlertMessageAfterSelectingSameAirports() {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.alternativeairlines.com/");

        HomePageForm homePageForm = PageFactory.initElements(webDriver, HomePageForm.class);
        homePageForm.populateArrivalInput("Moscow Domodedovo");
        homePageForm.populateDepartureInput("Moscow Domodedovo");
        homePageForm.submitForm();

        String alertMessage = homePageForm.getAlertMessage();

        Assert.assertEquals("Origin and destination cannot be the same", alertMessage);

    }

}
