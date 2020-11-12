package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.DropdownQuestionPage;
import pageObjects.LandingPage;
import pageObjects.MiscFunctions;
import pageObjects.MultiSelectQuestionPage;
import pageObjects.SingleSelectQuestionPage;

public class PageObjectManager {
	
	//this class is created to make sure that same page's object should not be created again and again
	//instead there should be single object for all step definition files
	private WebDriver driver;
	private LandingPage landingPage;
	private DropdownQuestionPage dropDownPage;
	private MiscFunctions miscFunctions;
	private SingleSelectQuestionPage singleSelectQuestionPage;
	private MultiSelectQuestionPage multiSelectQuestionPage;
	
	
	public PageObjectManager(WebDriver driver) {
		this.driver=driver; 
	}
	
	public LandingPage getLandingPage() {
		return (landingPage==null)?new LandingPage(driver):landingPage;
	}
	
	public DropdownQuestionPage getDropDownPage() {
		return(dropDownPage==null)?new DropdownQuestionPage(driver):dropDownPage;
	}
	
	public MiscFunctions getMiscFunctions() {
		return(miscFunctions==null)?new MiscFunctions(driver):miscFunctions;
	}
	
	public SingleSelectQuestionPage getSingleSelectPage() {
		return(singleSelectQuestionPage==null)?new SingleSelectQuestionPage(driver):singleSelectQuestionPage;
	}
	
	public MultiSelectQuestionPage getMultiSelectPage() {
		return(multiSelectQuestionPage==null)?new MultiSelectQuestionPage(driver):multiSelectQuestionPage;
	}
	
}
