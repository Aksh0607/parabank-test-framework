package Tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listeners.ExtentReportListener;
import pages.LoginPage;
import utils.Links;

@Listeners(ExtentReportListener.class)
public class LoginTest extends BaseTest {

	@Test(priority = 2)
	public void verifyInvalidLogin() {
		LoginPage loginPage = new LoginPage(driver);
		driver.get(Links.BASE_URL);
		loginPage.enterUsername("jane.doe");
		loginPage.enterPassword("password123456");
		loginPage.clickSubmit();
		Assert.assertEquals(loginPage.getErrorMessage().toString(), "The username and password could not be verified.");
	}
	
}
