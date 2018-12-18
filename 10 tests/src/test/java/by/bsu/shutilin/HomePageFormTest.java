package by.bsu.shutilin;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePageFormTest {

    public static final String siteURL = "https://www.alternativeairlines.com/";
    private WebDriver webDriver;
    private HomePageForm homePageForm;

    @Before
    public void beforeTest() {
        webDriver = new FirefoxDriver();
        webDriver.get(siteURL);
        homePageForm = PageFactory.initElements(webDriver, HomePageForm.class);
    }

    @After
    public void afterTest() {
        webDriver.close();
    }

    /*
        TESTCASE: Check for selecting same airports for from/to fields
        EXPECTED: Alert message
     */
    @Test
    public void catchAlertMessageAfterSelectingSameAirports() {

        homePageForm.populateArrivalInput("Moscow Domodedovo");
        homePageForm.populateDepartureInput("Moscow Domodedovo");
        homePageForm.submitForm();

        String alertMessage = homePageForm.getAlertMessage();

        Assert.assertEquals("Origin and destination cannot be the same", alertMessage);

    }

    /*
        TESTCASE: Check for selecting no airports for from/to fields
        EXPECTED: Alert message
     */
    @Test
    public void catchAlertMessageAfterSelectingNoAirports() {

        homePageForm.submitForm();

        String alertMessage = homePageForm.getAlertMessage();

        Assert.assertEquals("Please enter a departure airport", alertMessage);

    }

    /*
        TESTCASE: Check for selecting more then 9 adults
        EXPECTED: Alert message
     */
    @Test
    public void catchAlertMessageAfterSelecting9MoreAdults() {

        homePageForm.addAdults(9);

        String alertMessage = homePageForm.getAlertMessage();

        Assert.assertEquals("For bookings of 10 or more, please use our Group Bookings form", alertMessage);

    }

    /*
        TESTCASE: Check that submit button redirects to flights
        EXPECTED: Url contains /flights/
     */
    @Test
    public void checkFormSubmitRedirectsToFlights() {

        homePageForm.populateArrivalInput("Hangzhou");
        homePageForm.populateDepartureInput("Huambo");
        homePageForm.submitForm();

        int indexOfFlightsInUrl = homePageForm.getCurrentUrl().indexOf("flights");

        Assert.assertTrue(indexOfFlightsInUrl > 0);

    }



}
