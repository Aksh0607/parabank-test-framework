package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ExcelUtils;
import utils.WaitUtils;

public class BillPayPage {

	private WebDriver driver;

	public BillPayPage(WebDriver driver) {
		this.driver = driver;
	}

	private By billPayLink = By.xpath("//a[contains(text(),'Bill Pay')]");
	private By payeeName = By.xpath("//input[contains(@name,'payee.name')]");
	private By addressStreet = By.xpath("//input[contains(@name,'payee.address.street')]");
	private By addressCity = By.xpath("//input[contains(@name,'payee.address.city')]");
	private By state = By.xpath("//input[contains(@name,'payee.address.state')]");
	private By zipcode = By.xpath("//input[contains(@name,'payee.address.zipCode')]");
	private By phoneNumber = By.xpath("//input[contains(@name,'payee.phoneNumber')]");
	private By amount = By.xpath("//input[contains(@name,'amount')]");
	private By accountNumber = By.xpath("//input[contains(@name,'payee.accountNumber')]");
	private By verifyAccount = By.xpath("//input[contains(@name,'verifyAccount')]");
	private By sendPaymentButton = By.xpath("//input[@value = 'Send Payment']");
	private By billPaidMessage = By.xpath("//div[@id='billpayResult']/h1");

	public void payBill(String filepath) throws Exception {
		ExcelUtils excelUtils = new ExcelUtils();
		Map<String, String> dataMap = excelUtils.getRowDataAsMap(filepath, "Bill Pay", 1);
		enterValues(dataMap);
		clickPayBill();
	}

	public void openBillPayLink() {
		driver.findElement(billPayLink).click();
	}

	private void enterValues(Map<String, String> dataMap) {
		WaitUtils.enterText(driver, payeeName, dataMap.get("Payee Name"));
		WaitUtils.enterText(driver, addressStreet, dataMap.get("Address"));
		WaitUtils.enterText(driver, addressCity, dataMap.get("City"));
		WaitUtils.enterText(driver, state, dataMap.get("State"));
		WaitUtils.enterText(driver, zipcode, dataMap.get("Zip Code"));
		WaitUtils.enterText(driver, phoneNumber, dataMap.get("Phone #"));
		WaitUtils.enterText(driver, amount, dataMap.get("Amount #"));
		WaitUtils.enterText(driver, accountNumber, dataMap.get("Account #"));
		WaitUtils.enterText(driver, verifyAccount, dataMap.get("Verify Account #"));
	}

	private void clickPayBill() {
		driver.findElement(sendPaymentButton).click();
		WaitUtils.waitForElementToBeVisible(driver, billPaidMessage, 10);
	}

	public String getBillPaidMessage() {
		return driver.findElement(billPaidMessage).getText();
	}
}
