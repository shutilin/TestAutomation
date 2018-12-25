package by.bsu.shutilin;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class FlightsPageTest {

    public static final String siteURL = "https://www.alternativeairlines.com/";
    private WebDriver webDriver;
    FlightsPage flightsPage;

    @Before
    public void beforeTest() {
        webDriver = new FirefoxDriver();
        webDriver.get(siteURL);
        flightsPage = PageFactory.initElements(webDriver, FlightsPage.class);
    }

    @After
    public void afterTest() {
       // webDriver.close();
    }

    /*
        TESTCASE: Check for selecting flight
        EXPECTED: Url contains /booking/details
     */
    @Test
    public void checkConfirmSelectionRedirect() {

        flightsPage.getFlightsThroughHomePage();

        flightsPage.selectFlight();

        int indexOfBookingDetailsInUrl = flightsPage.getCurrentUrl().indexOf("booking/details");

        Assert.assertTrue(indexOfBookingDetailsInUrl > 0);
    }

    /*
        TESTCASE: Check if selecting currency change currency suffix
        EXPECTED: Suffix for Swedish Krona = kr
     */
    @Test
    public void checkCurrencyRegion() {

        flightsPage.getFlightsThroughHomePage();

        String currencySuffix = flightsPage.selectCurrency("SEK - Swedish Krona");

        Assert.assertTrue(currencySuffix.equals("kr"));
    }

    /*
        TESTCASE: Check for sorting flights by airlines
        EXPECTED: Flights will be sorted by "Aeroflot"
     */
    @Test
    public void checkAirlineFilter() {
        flightsPage.getFlightsThroughHomePage();

        String airline = flightsPage.filterByAirlines();

        Assert.assertTrue(airline.equals("Aeroflot"));

    }
}
