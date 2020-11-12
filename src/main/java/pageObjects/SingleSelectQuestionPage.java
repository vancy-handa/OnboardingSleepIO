package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingleSelectQuestionPage {
	
	WebDriver driver;
	
	//PageFactoryModel
	public SingleSelectQuestionPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = ".//div[@class='sl-options-wrapper ']/div[1]/label/span")
	private WebElement firstOption;
	
	public void select_first_option() {
		Actions action = new Actions(driver);
		action.moveToElement(firstOption).click().build().perform();
	}

}
