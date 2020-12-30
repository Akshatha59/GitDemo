package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	public WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver() throws IOException {
	
     prop =new Properties();
	FileInputStream file =new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
	
	prop.load(file);
	//this is using data properties
	String browsername=prop.getProperty("browser");
	//by using maven 
	//String browsername =System.getProperty("browser");
	System.out.println(browsername);
	
	if(browsername.contains("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
		ChromeOptions option =new ChromeOptions();
		if(browsername.contains("headless")) {
		option.addArguments("headless");
		}
		driver =new ChromeDriver(option);
		
	}
	
	else if(browsername.equals("Firefox")) {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
		 driver =new FirefoxDriver();
	}
	else if(browsername.equals("IE")) {
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\IEDriverServer.exe");
		 driver =new InternetExplorerDriver();
	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
}
public String getScreenShotPath(String testcaseName,WebDriver driver) throws IOException {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	String destinationfile=System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
	FileUtils.copyFile(src,new File(destinationfile));
	return destinationfile;
}
}
