package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public LandingPage(WebDriver driver){
		this.driver=driver;
	}

	public WebDriver driver;
	
	private By signin =By.cssSelector("a[href*='sign_in']");
	
	private By pagetitle=By.xpath("//div[@class='text-center']//h2");
	
	private By NavBar=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	
	private  By header =By.cssSelector("div[class*='video-banner'] h3");
		


	public LoginPage getlogin() {
		
	 driver.findElement(signin).click();
	 LoginPage login =new LoginPage(driver);
	 return login;
	}
   public WebElement pageTtile() {
		
		return driver.findElement(pagetitle);
	}
   public WebElement navBar() {
		
		return driver.findElement(NavBar);
	}
   public WebElement gethearder() {
		
		return driver.findElement(header);
	}
	
}
