package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	
 public WebDriver driver;
	ForgotPassword(WebDriver driver){
		this.driver=driver;
	}
	
	By email=By.cssSelector("[id='user_email']");
	By sendMeInstructions =By.cssSelector("[type='submit']");
	
	public WebElement getemail() {
		return driver.findElement(email);
		
	}
	
	public WebElement sendMeInstruction() {
		// TODO Auto-generated method stub
		return driver.findElement(sendMeInstructions);
	}
}
