package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}
	
	
	By Email =By.id("user_email");
	By Password =By.id("user_password");
	By login =By.name("commit");
	By forgotPassword =By.cssSelector("[href*='password']");
	
	public WebElement Email() {
		return driver.findElement(Email);
	}
	public WebElement Password() {
		return driver.findElement(Password);
	}
	public WebElement Login() {
		return driver.findElement(login);
	}
	public ForgotPassword forgotPassword() {
		driver.findElement(forgotPassword).click();
		return new ForgotPassword(driver);
		
		
	}
	
	
}
