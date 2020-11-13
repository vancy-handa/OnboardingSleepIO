package pageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MultiSelectQuestionPage {
	WebDriver driver;
	String ExpectedMultiErrorMessage="You must select at least 1 answer";
	
	//PageFactoryModel
	public MultiSelectQuestionPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindAll(@FindBy(xpath = ".//div[@class='sl-option-row sl-option-row--checked']"))
	private List<WebElement> selectedOptionsList;
	
	@FindAll(@FindBy(xpath = ".//div[@class='sl-options-wrapper ']/div"))
	private List<WebElement> list;
	
	@FindBy(className = "sl-container-radio-options--error")
	private WebElement multiErrorMessage;
	
	public void select_multi_options() {
		int size = list.size();
		for(int i=1; i<=size;i++) {
			WebElement option = driver.findElement(By.xpath(".//div[@class='sl-options-wrapper ']/div["+i+"]/label/span"));
			if(! option.getText().equalsIgnoreCase("None of the above")) {
				Actions action = new Actions(driver);
				action.moveToElement(option).click().build().perform();
			}
		}
	}
	
	public void select_None_of_above() {
		int size = list.size();
		for(int i=1; i<=size;i++) {
			WebElement option = driver.findElement(By.xpath(".//div[@class='sl-options-wrapper ']/div["+i+"]/label/span"));
			if(option.getText().equalsIgnoreCase("None of the above")) {
				Actions action = new Actions(driver);
				action.moveToElement(option).click().build().perform();
			}
		}
	}
	
	public void verify_NoneOfAbove_selected() {
		for(WebElement el:selectedOptionsList) {
			String actualValue=el.findElement(By.xpath("./label/span")).getText();
			assertEquals(actualValue, "None of the above"); 
		}
	}
	
	public void verify_answer_is_selected() {
		int listSize = selectedOptionsList.size();
		assertTrue(listSize>0);
	}

	public void verify_multi_error_message() {
		String actualMultiErrorMessage=multiErrorMessage.getText();
		System.out.println(actualMultiErrorMessage);
		assertEquals(ExpectedMultiErrorMessage, actualMultiErrorMessage);
	}
}
