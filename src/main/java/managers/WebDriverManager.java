package managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import enums.DriverType;

public class WebDriverManager {
	//this class is used to get and close the driver 
	//if driver is null, then it will create the driver
	//we only need to specify the type of driver(browser) we require in the Configuration.properties file
	
	
	private WebDriver driver;
	private static DriverType driverType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	public WebDriverManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
	}
	
	public WebDriver getDriver() {
		if (driver == null) driver = createDriver(); 
		return driver;
	}
	
	private WebDriver createDriver() {
		switch(driverType) {
		case CHROME:
			System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case SAFARI:
			driver = new SafariDriver();
			break;
		}
		if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}
	
	public void closeDriver() {
		driver.close();
		driver.quit();
	}
}