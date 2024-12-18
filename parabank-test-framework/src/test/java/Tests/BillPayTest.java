package Tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listeners.ExtentReportListener;
import pages.BillPayPage;
import pages.LoginPage;
import utils.Links;

@Listeners(ExtentReportListener.class)
public class BillPayTest extends BaseTest{
	
	@Test(priority = 3)
	public void testBillPayment() throws Exception {
		driver.get(Links.BASE_URL);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername("john");
		loginPage.enterPassword("demo");
		loginPage.clickSubmit();
		
		BillPayPage billPayPage = new BillPayPage(driver);
		billPayPage.openBillPayLink();
		billPayPage.payBill(Links.BILL_PAY_TEST_DATA_FILE_PATH);
		Assert.assertEquals(billPayPage.getBillPaidMessage(), "Bill Payment Complete");
		
	}
	
}
