package pageObjects;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingleSelectQuestionPage {
	
	WebDriver driver;
	String ExpectedSingleErrorMessage ="You must select at least 1 answer";
	//PageFactoryModel
	public SingleSelectQuestionPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = ".//div[@class='sl-options-wrapper ']/div[1]/label/span")
	private WebElement firstOption;
	
	@FindBy(className = "sl-container-radio-options--error")
	private WebElement singleErrorMessage;
	
	public void select_first_option() {
		Actions action = new Actions(driver);
		action.moveToElement(firstOption).click().build().perform();
	}
	
	public void verify_single_error_message() {
		String actualSingleErrorMessage=singleErrorMessage.getText();
		System.out.println(actualSingleErrorMessage);
		assertEquals(ExpectedSingleErrorMessage, actualSingleErrorMessage);
	}

}
