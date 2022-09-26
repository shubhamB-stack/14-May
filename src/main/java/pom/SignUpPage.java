package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {
	
	@FindBy (xpath = "//input[@id='user_mobile']") private WebElement mobNUmber;
	@FindBy (xpath = "//button[@id='open_account_proceed_form']") private WebElement continueButton;
	@FindBy (xpath = "//a[text()='Want to open an NRI account?']") private WebElement nriAccount; 
	
	public SignUpPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
	
	public void enterMobileNumber (String mob,WebDriver driver) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
//		wait.until(ExpectedConditions.visibilityOf(mobNUmber));
		
//		FluentWait <WebDriver> wait = new FluentWait <WebDriver> (driver);
//		wait.withTimeout(Duration.ofMillis(2000));
//		wait.pollingEvery(Duration.ofMillis(10));
//		wait.ignoring(Exception.class);
//		wait.until(ExpectedConditions.visibilityOf(mobNUmber));
//		
		mobNUmber.sendKeys(mob);
	}
	
	public void clickOnContinue () {
		continueButton.click();
	}
	
	public void clickOnOpenNriAcount () {
		nriAccount.click();
	}

}
