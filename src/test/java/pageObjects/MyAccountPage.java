package pageObjects;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	public MyAccountPage(WebDriver driver){
		super(driver);
	}
	@FindBy(xpath="//*[@id='content']//*[normalize-space()='My Account']")
	WebElement chkLogin;
	
	@FindBy(xpath="//*[@class='list-group']//a[text()='Logout']")
	public WebElement clkLogt;
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	public WebElement clckMyAcc;
	
	
	public boolean chkLgn() {
		Boolean actString=chkLogin.isDisplayed();
		if(actString)
		{
			return true;
		}else {
			return false;
		}
	}
	
	public void clckLogout() {
		clkLogt.click();
	}
	
	
	public void clckBtnMyAcc() {
		clckMyAcc.click();
	}
}
