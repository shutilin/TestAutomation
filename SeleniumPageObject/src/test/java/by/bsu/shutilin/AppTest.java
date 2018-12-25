package by.bsu.shutilin;

import by.bsu.shutilin.driver.DriverProvider;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AppTest {

    private HomePageForm homePageForm;

    @Before
    public void setup() {
        homePageForm = new HomePageForm(DriverProvider.getDriver());
        homePageForm.openPage();
    }

    @After
    public void closeDriver() {
        DriverProvider.closeDriver();
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

}
