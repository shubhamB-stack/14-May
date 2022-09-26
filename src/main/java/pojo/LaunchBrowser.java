package pojo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	
	public static WebDriver chromeBrowser () {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "F:\\software\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver (option);
		driver.navigate().to("https://kite.zerodha.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		return driver;
	}
	

}
