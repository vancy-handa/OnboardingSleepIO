package pageObjects;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MiscFunctions {
	
	WebDriver driver;
	String expectedErrorMessage ="Please answer all the questions before continuing.";
	String expectedHeader="YOUR SLEEP SCORE";
	
	//PageFactory Model
	public MiscFunctions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = ".//div[@class='sl-button-wrapper']/button")
	private WebElement continueButton;
	
	@FindBy(className = "sl-general-error")
	private WebElement errorMessage;
	
	@FindBy(className = "sl-page__item")
	private WebElement questionType;
	
	@FindBy(xpath = ".//div[@class='sl-page__item']/div[contains(@class,'select')]")
	private WebElement dropDownQuestion;
	
	@FindBy(xpath=".//div[@class='sl-page__item']/div[contains(@class,'multi')]")
	private WebElement multiQuestion;
	
	@FindBy(xpath=".//div[@class='sl-page__item']/div[contains(@class,'single')]")
	private WebElement singleQuestion;
	
	@FindBy(xpath = ".//h1[@class='sl-header__text']")
	private WebElement headerText;
	
	public void click_on_continue() {
		Actions action = new Actions(driver);
		action.moveToElement(continueButton).click().build().perform();
	}
	
	public void verify_error_message() {
		String actualErrorMessage=errorMessage.getText();
		assertEquals(expectedErrorMessage, actualErrorMessage);
		System.out.println("General Error message verified");
	}
	

	public boolean isElementPresent(By locator) {
		try {
			driver.findElement(locator);
			return true;
		}catch (org.openqa.selenium.NoSuchElementException e) {
	        return false;
	    }
	}
	
	public String verify_type_of_question() {
		try {
			if(isElementPresent(By.xpath(".//div[@class='sl-page__item']/div[contains(@class,'select')]"))){
				System.out.println("Type of question is drop");
				return "DropDown";
			}else if(isElementPresent(By.xpath(".//div[@class='sl-page__item']/div[contains(@class,'multi')]"))){
				System.out.println("Type of question is multi");
				return "Multi";
			}else if(isElementPresent(By.xpath(".//div[@class='sl-page__item']/div[contains(@class,'single')]"))){
				System.out.println("Type of question is single");
				return "Single";
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "yet to implement";
	}
	
	public void verify_score_page() {
		String actualHeader=headerText.getText();
		assertEquals(expectedHeader, actualHeader);
	}
	
}
