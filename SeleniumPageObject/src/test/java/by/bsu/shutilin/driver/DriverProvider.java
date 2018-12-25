package by.bsu.shutilin.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverProvider {
    private static WebDriver driver;

    private DriverProvider() {};

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new FirefoxDriver();
        }

        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
