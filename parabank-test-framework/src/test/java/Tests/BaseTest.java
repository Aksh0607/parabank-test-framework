package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();  // Initialize WebDriver for Selenium tests
        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close WebDriver after test execution
        }
    }
    
    public void waitTillVisible(By locator) {
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
}
