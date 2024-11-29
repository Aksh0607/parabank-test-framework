package Tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.LoginPage;

@Listeners(ExtentReportListener.class)
public class LoginTest extends BaseTest {

	@Test
	public void verifyInvalidLogin() {
		LoginPage loginPage = new LoginPage(driver);
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		loginPage.enterUsername("jane.doe");
		loginPage.enterPassword("password123456");
		loginPage.clickSubmit();
		Assert.assertEquals(loginPage.getErrorMessage().toString(), "The username and password could not be verified.");
	}
	
}
