package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By usernameField = By.xpath("//input[@name = 'username']");
	private By passwordField = By.xpath("//input[@name = 'password']");
	private By loginButton = By.xpath("//input[@type= 'submit']");
	private By errorMessage = By.xpath("//p[@class='error']");
	
	public void enterUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void clickSubmit() {
		driver.findElement(loginButton).click();
	}
	
	public String getErrorMessage() {
		
		return driver.findElement(errorMessage).getText();
	}
	

}
