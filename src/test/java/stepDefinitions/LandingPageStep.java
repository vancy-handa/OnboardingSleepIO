package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObjects.LandingPage;

public class LandingPageStep {
	TestContext testContext;
	LandingPage landingPage;
	
	//constructor with TestContext as parameter
	public LandingPageStep(TestContext context) {
		testContext = context;
		landingPage=testContext.getPageObjectManager().getLandingPage();
	}
	
	@Given("^user is on landingPage$")
	public void user_is_on_landingPage()  {
		landingPage.navigate_to_landingPage();
	}

	@When("^user clicks on Get Started$")
	public void user_clicks_on_Get_Started() throws InterruptedException  {
		landingPage.click_on_getStarted();
		Thread.sleep(1000);
	}
}
