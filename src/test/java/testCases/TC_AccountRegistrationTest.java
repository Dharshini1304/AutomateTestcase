package testCases;
import testBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;


public class TC_AccountRegistrationTest extends BaseClass{
    @Test(groups={"Regression","Master"})
    public void verify_account_registration() {
    		logger.info("**********starting tc001_Accountregistrationtest*****");
    		try
    		{
    		//HomePage
    		HomePage hp=new HomePage(driver);
    		hp.clickMyAccount();
    		logger.info("Click on MyAccount Link");
    		hp.clickRegister();
    		logger.info("Click on Register Link");
    		
    		//AccountRegistrationPage
    		AccountRegistrationPage ar=new AccountRegistrationPage(driver);
    		logger.info("Providing customer details..");
    		ar.setUserName(randomString().toUpperCase());
    		ar.setlastname(randomString().toUpperCase());
    		ar.setemail(randomString()+"@gmail.com");
    		ar.setTelephone(randomNumber());
    		String password=randomAlphaNumeric();
    		ar.setPassword(password);
    		ar.setPasswordCnf(password);
    		ar.chckPolicy();
    		ar.clickContinue();
    		
    		
    		logger.info("validating expected message..");
    		String cnfmsg=ar.getConfirmationMsg();
    		Assert.assertEquals(cnfmsg,"Your Account Has Been Created!"); 
    		}
    		catch(Exception e)
    		{
    			logger.error("Test failed...");
    			logger.debug("Debug logs..");
    			Assert.fail();
    		}
    }

	
}
