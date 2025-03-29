package pageObjects;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

//Constructor to invoke WebDriver	
	public AccountRegistrationPage (WebDriver driver)
	{
		super(driver);
	}
	
//Locator
@FindBy(xpath="//input[@id='input-firstname']")
WebElement txtfirstname;

@FindBy(xpath="//input[@id='input-lastname']")
WebElement txtlastname;

@FindBy(xpath="//input[@id='input-email']")
WebElement txtemail;

@FindBy(xpath="//input[@id='input-telephone']")
WebElement telephone;

@FindBy(xpath="//input[@id='input-password']")
WebElement txtpss;

@FindBy(xpath="//input[@id='input-confirm']")
WebElement  txtpssconfirm;

@FindBy(xpath="//input[@type='checkbox']")
WebElement  chkpolicy;

@FindBy(xpath="//input[@type='submit']")
WebElement  btnsbmt;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgConfirmation;

public void setUserName(String fname) {
	txtfirstname.sendKeys(fname);
}

public void setlastname(String lname) {
	txtlastname.sendKeys(lname);
}

public void setemail(String email) {
	txtemail.sendKeys(email);
}

public void setTelephone(String tel) {
	telephone.sendKeys(tel);
}

public void setPassword(String pwd) {
	txtpss.sendKeys(pwd);
}

public void setPasswordCnf(String cnfpwd) {
	txtpssconfirm.sendKeys(cnfpwd);
}

public void chckPolicy() {
	chkpolicy.click();
}

public void clickContinue() {
	btnsbmt.click();
}

public String getConfirmationMsg() {
	try {
		return(msgConfirmation.getText());
	}catch(Exception e) {
		return (e.getMessage());
	}
}

}
