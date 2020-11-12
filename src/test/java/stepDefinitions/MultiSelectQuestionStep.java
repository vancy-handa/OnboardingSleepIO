package stepDefinitions;


import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pageObjects.MiscFunctions;
import pageObjects.MultiSelectQuestionPage;

public class MultiSelectQuestionStep {
	
	TestContext testContext;
	MultiSelectQuestionPage multiPage;
	MiscFunctions miscFunctions;
	//constructor with TestContext as parameter
	public MultiSelectQuestionStep(TestContext context) {
		testContext = context;
		multiPage=testContext.getPageObjectManager().getMultiSelectPage();
		miscFunctions=testContext.getPageObjectManager().getMiscFunctions();
	}

	@And("^selects None of the Above$")
	public void selects_None_of_the_Above() throws Throwable{
		multiPage.select_None_of_above();
	}
	
	@Then("^multiple answers selected previously should be unselected$")
	public void multiple_answers_selected_previously_should_be_unselected() throws Throwable {
	    Thread.sleep(1000);
		multiPage.verify_NoneOfAbove_selected();
	}
	
	@And("^selects multiple options$")
	public void selects_multiple_options() throws Throwable {
		multiPage.select_multi_options();
	}
	
	@Then("^answer is selected successfully$")
	public void answer_is_selected_successfully() throws Throwable {
	    multiPage.verify_answer_is_selected();
	}
	
}
