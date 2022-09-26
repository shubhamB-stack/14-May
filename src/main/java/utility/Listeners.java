package utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends BaseTest implements ITestListener {
	// WebDriver driver    base test ka complete driver use hora jo test class k browser wale code se complete hota
	
	public void onTestStart (ITestResult result) {
		System.out.println("Test Started "+result.getName());
	}
	
	public void onTestSuccess (ITestResult result) {
		System.out.println("Test Passes "+result.getName());
	}
	
	public void onTestFailure (ITestResult result) {
		//System.out.println("Test Failled "+result.getName());
		try {
			Screenshot.takesScreenshot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped (ITestResult result) {
		System.out.println("Test Skipped "+result.getName());
	}
	
	
	
	
	

}
