package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import managers.FileReaderManager;

public class LandingPage {
	
	WebDriver driver;

	//creating an instance of the class with driver as parameter
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = ".//div[@class='landing-page']/input")
	private WebElement getStarted;
	
	public void click_on_getStarted() {
		Actions action = new Actions(driver);
		action.moveToElement(getStarted).click().build().perform();
		System.out.println("Clicked on Get Started");
	}
	
	public void navigate_to_landingPage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}
	
}
