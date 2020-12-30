package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class validateNavigationBar extends Base {
	
	public static Logger log=LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException {
		 driver = initializeDriver();
		 log.info("driver is initialized");
		 driver.get(prop.getProperty("url"));
		
	  driver.manage().window().maximize();
	}
	
	@Test
	public void valiadeNavigatebar() throws IOException {

	    
		
		LandingPage lp =new LandingPage(driver);
        
		Assert.assertTrue(lp.navBar().isDisplayed());
		log.info("navigation is displayed");

}
	@AfterTest
	   public void closebrowser() {
			driver.close();
			
		}
}