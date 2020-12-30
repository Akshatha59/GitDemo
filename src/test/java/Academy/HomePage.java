package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	
	public static Logger log=LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException {
		 driver = initializeDriver();
		
	}
	

	@Test(dataProvider="getData")
	public void basePageNavaigation(String username,String password,String text) throws IOException {
		
		 driver.get(prop.getProperty("url"));
		  driver.manage().window().maximize();
		LandingPage lp =new LandingPage(driver);
		LoginPage login=lp.getlogin();
		login.Email().sendKeys(username);
		login.Password().sendKeys(password);
		//System.out.println(text);
		 log.info(text);
		login.Login().click();
	ForgotPassword	fp=login.forgotPassword();
	fp.getemail().sendKeys("akshathashetty9062gmail.com");
	fp.sendMeInstruction().click();
		
		log.info("sucessfully ran home page ");
	}
	
		@AfterTest 
		public void closebrowser() {
				driver.close();
			}
		

	@DataProvider
	public Object[][] getData() {
		Object[][] obj =new Object[2][3];
		
		obj[0][0]="hello@gmail.com";
		obj[0][1]="abcd";
		obj[0][2]="restricted user";
		
		obj[1][0]="akshatha@gmail.com";
		obj[1][1]="123abc";
		obj[1][2]="nonrestricted user";
		
		return obj;
		
	}
}
