package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sun.tools.sjavac.Log;

import pageObjects.LandingPage;
import resources.Base;

public class validateTitle extends Base {
	
	public static Logger log=LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	LandingPage lp;
	@BeforeTest
	public void initialize() throws IOException {
		 driver = initializeDriver();
		 driver.get(prop.getProperty("url"));
	  driver.manage().window().maximize();
	}
	
	
	@Test
	public void validatePageTitle() throws IOException {

		 lp =new LandingPage(driver);
		Assert.assertEquals(lp.pageTtile().getText(), "FEATURED 123COURSES");
		log.info("The title is same as expected result");
		
}
	@Test
	public void validateHeaderTitle() throws IOException {

		 lp =new LandingPage(driver);
		Assert.assertEquals(lp.gethearder().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("The Header title is same as expected result");
		
		
}
	@AfterTest
   public void closebrowser() {
		driver.close();
	}
}