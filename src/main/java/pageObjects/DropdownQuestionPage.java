package pageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropdownQuestionPage {

	WebDriver driver;
	
	//creating an instance of the class with driver as parameter
	public DropdownQuestionPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = ".//select[@class='sl-select ']")
	private WebElement dropDown;
	
	@FindBy(className = "sl-select sl-select--has-error")
	private WebElement DropdownError;
	
	public void select_firstOption() {
		Select select = new Select(dropDown);
		select.selectByValue("0");
	}
	
	public void verify_dropDown_error() {
		assertTrue(DropdownError.isDisplayed());
	}

}
