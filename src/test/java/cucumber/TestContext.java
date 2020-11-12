package cucumber;

import managers.PageObjectManager;
import managers.WebDriverManager;

public class TestContext {
	
	//this class is created to make sure states are shared between different steps
	//Pico Container is used. It is a Dependency Injection container supported by Cucumber
	private WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;
	
	
	public TestContext() {
		webDriverManager = new WebDriverManager();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
	}
	
	public WebDriverManager getWebDriverManager() {
		return webDriverManager;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

	
}