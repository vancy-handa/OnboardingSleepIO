package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.DropdownQuestionPage;
import pageObjects.MiscFunctions;
import pageObjects.MultiSelectQuestionPage;
import pageObjects.SingleSelectQuestionPage;

public class miscStep {
	
	TestContext testContext;
	DropdownQuestionPage dropDownPage;
	MiscFunctions miscFunctions;
	SingleSelectQuestionPage singlePage;
	MultiSelectQuestionPage multiPage;
	
	//constructor with TestContext as parameter
	public miscStep(TestContext context) {
		testContext = context;
		dropDownPage=testContext.getPageObjectManager().getDropDownPage();
		miscFunctions=testContext.getPageObjectManager().getMiscFunctions();
		singlePage=testContext.getPageObjectManager().getSingleSelectPage();
		multiPage=testContext.getPageObjectManager().getMultiSelectPage();
	}
	
	@When("^navigates to sleep score page$")
	public void navigates_to_sleep_score_page() throws Throwable {
	    miscFunctions.verify_score_page();
	}
	
	@When("^selects no answer and clicks on Continue$")
	public void selects_no_answer_and_clicks_on_Continue() throws Throwable {
		miscFunctions.click_on_continue();
	}
	
	@Then("^error message is shown$")
	public void error_message_is_shown() throws Throwable {
		miscFunctions.verify_error_message();
	}
	
	@When("^verifies the type of question and selects answer$")
	public void verifies_the_type_of_question_and_selects_answer() throws InterruptedException  {
		String type_of_Question = miscFunctions.verify_type_of_question();
	    System.out.println("type of question is "+type_of_Question);
	    if(type_of_Question.equalsIgnoreCase("DropDown")) {
	    	dropDownPage.select_firstOption();
	    }else if(type_of_Question.equalsIgnoreCase("Multi")) {
	    	multiPage.select_multi_options();
	    }else if(type_of_Question.equalsIgnoreCase("Single")) {
	    	singlePage.select_first_option();
	    }else{
	    	System.out.println("Yet to implement");
	    }
	}
	
	@Then("^clicks on Continue$")
	public void clicks_on_Continue() throws Throwable {
	    miscFunctions.click_on_continue();
	}

	@Then("^user navigates to sleep score page and Your Sleep Score header is shown$")
	public void user_navigates_to_sleep_score_page_and_Your_Sleep_Score_header_is_shown() throws Throwable {
		miscFunctions.verify_score_page();
	}
}
