package Tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.RegisterPage;

@Listeners(ExtentReportListener.class)
public class RegisterTest extends BaseTest {

    @Test
    public void registerNewUser() {
        
        driver.get("https://parabank.parasoft.com/parabank/register.htm");

        
        RegisterPage registerPage = new RegisterPage(driver);

        
        registerPage.enterFirstName("Jane");
        registerPage.enterLastName("Doe");
        registerPage.enterStreet("123 Main St");
        registerPage.enterCity("SampleCity");
        registerPage.enterState("SampleState");
        registerPage.enterZipCode("12345");
        registerPage.enterPhoneNumber("1234567890");
        registerPage.enterSSN("123-45-6789");
        registerPage.enterUsername("jane.doe");
        registerPage.enterPassword("password123");
        registerPage.enterRepeatedPassword("password123");
        registerPage.clickRegisterButton();

        
        Assert.assertTrue(registerPage.isRegistrationSuccessful());
    }
}
