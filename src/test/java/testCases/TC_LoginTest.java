package testCases;

import testBase.BaseClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC_LoginTest extends BaseClass{
	@Test(groups={"sanity","Master"})
	public void verifyLoginTest() {
		try
		{
			logger.info("***Starting TC02_LoginTest****");
			//HomePage
			HomePage hmpg=new HomePage(driver);
			hmpg.clickMyAccount();
			hmpg.clickLogin();
			
			//LoginPage
			LoginPage lgnpg=new LoginPage(driver);
			lgnpg.setemail(p.getProperty("email"));
			lgnpg.setpwd(p.getProperty("password"));
			
			//AccountPage
			MyAccountPage accpg=new MyAccountPage(driver);
			lgnpg.slctLgn();
			boolean Myacnt=accpg.chkLgn();
			Assert.assertTrue(Myacnt);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("****Finished TC_002LoginTest********");
	}

}
