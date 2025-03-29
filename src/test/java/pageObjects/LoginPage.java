package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpwd;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement clkLgn;
	
	
	public void setemail(String email){
		txtemail.sendKeys(email);
	}
	
	public void setpwd(String pwd) {
		txtpwd.sendKeys(pwd);	
	}
	
	public void slctLgn() {
		clkLgn.click();
	}
	

}
