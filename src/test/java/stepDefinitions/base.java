package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class base {
TestContext testContext;
	
	public base(TestContext context) {
		testContext = context;
	}
	
	@Before
	public void setUp() {
		System.out.println("--Test Case starts--");
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		testContext.getWebDriverManager().closeDriver();
	}

}
