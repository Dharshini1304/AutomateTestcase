package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups= {"Sanity","Regression","Master","DataDriven"})
	@Parameters({"os","browser"})
	public void setup(@Optional("Windows") String os, @Optional("chrome") String br) throws IOException {
		
		logger=LogManager.getLogger(this.getClass());
		
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		switch(br.toLowerCase())
		{
		case "chrome" : driver=new ChromeDriver(); break;
		case "edge"   : driver=new EdgeDriver(); break;
		case "firefox" : driver=new FirefoxDriver(); break;
		}
	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(p.getProperty("appURL"));  //reading url from properties file
		driver.manage().window().maximize();
	}
	
    @AfterClass(groups= {"Sanity","Regression","Master"})
    public void teardown() {
    	driver.quit();
    }
    
    //Methods to create RandomString or number or alphanumeric numbers
	public String randomString() {
    	String generatedString=RandomStringUtils.randomAlphabetic(5);
    	return generatedString;
    }
  
	public String randomNumber() {
    	String generatedNumber=RandomStringUtils.randomNumeric(10);
    	return generatedNumber;
    }
	public String randomAlphaNumeric() {
		String generatedString=RandomStringUtils.randomAlphabetic(5);
    	String generatedNumber=RandomStringUtils.randomNumeric(10);
    	return (generatedString+"@"+generatedNumber);
    }
	public String captureScreen(String tname) {
        /*if (driver == null) {
            System.out.println("Error: WebDriver instance is null. Screenshot capture failed.");
            return null;
        }*/
        
		String timeStamp=new SimpleDateFormat("yyyyMMDHHMMss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourceFile=ts.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}

}
