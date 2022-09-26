package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPage {
	
	@FindBy (xpath = "(//label[@class='su-radio-label'])[1]") private WebElement rememberMyUserId;
	@FindBy (xpath = "(//label[@class='su-radio-label'])[2]") private WebElement forgotMyUserId;
	@FindBy (xpath = "(//input[@type='text'])[1]") private WebElement userId;
	@FindBy (xpath = "(//input[@type='text'])[2]") private WebElement pan;
	@FindBy (xpath = "(//label[@class='su-radio-label'])[3]") private WebElement receiveOnEmail;
	@FindBy (xpath = "(//label[@class='su-radio-label'])[4]") private WebElement receiveOnSms;
	@FindBy (xpath = "(//input[@type='text'])[3]") private WebElement email;
	@FindBy (xpath = "(//input[@type='text'])[3]") private WebElement mobNo;
	@FindBy (xpath = "(//input[@type='text'])[4]") private WebElement captcha;
	@FindBy (xpath = "//button[@class='button-orange wide']") private WebElement reset;
	@FindBy (xpath = "//a[@class='text-xsmall text-light reset-account-button']") private WebElement backToLogin;
	
	public ForgotPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnIrememberMyUserId () {
		rememberMyUserId.click();
	}
	
	public void clickOnIforgotMyUserId () {
		forgotMyUserId.click();
	}
	
	public void enterUserId (String user) {
		userId.sendKeys(user);
	}
	
	public void enterPan (String PAN) {
		pan.sendKeys(PAN);
	}
	
	public void clickOnReceiveOnEmail () {
		receiveOnEmail.click();
	}
	
	public void clickOnReceiveOnSms () {
		receiveOnSms.click();
	}
	
	public void enterEmail (String mail) {
		email.sendKeys(mail);
	}
	
	public void enterMobileNumber (String mobno) {
		mobNo.sendKeys (mobno);
	}
	
	public void clickOnReset () {
		reset.click();
	}
	
	public void clickOnBackToLogin () {
		backToLogin.click();
	}
	

}
