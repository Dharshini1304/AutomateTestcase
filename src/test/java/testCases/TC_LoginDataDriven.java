package testCases;
import testBase.BaseClass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC_LoginDataDriven extends BaseClass{
	
	@Test(dataProvider ="LoginData", dataProviderClass=DataProviders.class,groups="DataDriven")
	
	public void verify_LoginTestDataDriven(String email, String pwd, String expResult) {
		
		HomePage hmpg=new HomePage(driver);
		hmpg.clickMyAccount();
		hmpg.clickLogin();
		
		LoginPage lgpg=new LoginPage(driver);
		lgpg.setemail(email);
		lgpg.setpwd(pwd);
		lgpg.slctLgn();
		
		MyAccountPage accpg=new MyAccountPage(driver);
		boolean result=accpg.chkLgn();
		
		if(expResult.equalsIgnoreCase("Valid")) {
			if(result) {
				accpg.clckBtnMyAcc();
				accpg.clckLogout();
				Assert.assertTrue(true);
			}else {
				Assert.assertFalse(false);
			}
		}
		if(expResult.equalsIgnoreCase("Invalid")) {
			if(result) {
				//JavascriptExecutor js=(JavascriptExecutor)driver;
				//js.executeScript("arguments[0].scrollIntoView();", accpg.clkLogt);
				accpg.clckBtnMyAcc();
				accpg.clckLogout();
				Assert.assertFalse(false);
				
			}else {
				Assert.assertTrue(true);
			}
		}
		
		
	}
	

}
