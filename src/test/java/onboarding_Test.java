import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class onboarding_Test {

	private static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {

		String home= System.getProperty("user.home");
		System.setProperty("webdriver.chrome.driver", home+"/Downloads/chromedriver2");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

		driver.get("https://onboarding.sleepio.com/sleepio/big-health");
		Thread.sleep(1000);
		WebElement getStarted = driver.findElement(By.xpath(".//div[@class='landing-page']/input"));
		getStarted.click();
		Thread.sleep(1000);
		
		WebElement con = driver.findElement(By.xpath(".//div[@class='sl-button-wrapper']/button"));
		Actions action = new Actions(driver);
		action.moveToElement(con).click().build().perform();
		
		WebElement generalError = driver.findElement(By.className("sl-general-error"));
		String error = generalError.getText();
		String expectedErrorMessage ="Please answer all the questions before continuing.";
		
		assertEquals(error, expectedErrorMessage); 
		
		
		List<WebElement> list= driver.findElements(By.xpath(".//div[@class='sl-options-wrapper ']/div"));
		int size = list.size();
		System.out.println("size is"+size);
		for(int i=1; i<=size;i++) {
			System.out.println("entered for");
			WebElement option = driver.findElement(By.xpath(".//div[@class='sl-options-wrapper ']/div["+i+"]/label/span"));
			if(! option.getText().equalsIgnoreCase("None of the above")) {
				System.out.println("entered if");
				WebElement option1 = driver.findElement(By.xpath(".//div[@class='sl-options-wrapper ']/div["+i+"]/label/span"));
				System.out.println(option.getText());
				action.moveToElement(option1).click().build().perform();
				//option.click();
			}else if(option.getText().contains("None of the above")) {
				//WebElement option1 = driver.findElement(By.xpath(".//div[@class='sl-options-wrapper ']/div["+i+"]/label/span"));
				//System.out.println(option.getText());
				List<WebElement> list1= driver.findElements(By.xpath(".//div[@class='sl-option-row sl-option-row--checked']"));
				int noOfOptionSelected=list1.size();
				System.out.println("no of options slected is "+noOfOptionSelected);
				if(list1.size()==0) {
					//WebElement option1 = driver.findElement(By.xpath(".//div[@class='sl-options-wrapper ']/div[1]/label/span"));
					//System.out.println(option.getText());
					action.moveToElement(option).click().build().perform();
				}else {
					action.moveToElement(option).click().build().perform();
					Thread.sleep(1000);
					List<WebElement> list12= driver.findElements(By.xpath(".//div[@class='sl-option-row sl-option-row--checked']"));
					System.out.println("newwww size "+list12.size());
					for(WebElement el:list12) {
						System.out.println(el.getText());
						WebElement optionValue = driver.findElement(By.xpath(".//div[@class='sl-option-row sl-option-row--checked']/label/span"));
						System.out.println("selected option is- "+optionValue.getText());
						assertEquals(optionValue.getText(), "None of the above"); 
					}
				}
				action.moveToElement(option).click().build().perform();
				for(int j = 1;j<=size;j++) {
					WebElement op=driver.findElement(By.xpath(".//div[@class='sl-option-row sl-option-row--checked']"));
					System.out.println(op.getText());
				}
			}
		}
		try {
		action.moveToElement(con).click().build().perform();
		}catch(StaleElementReferenceException e) {
			con = driver.findElement(By.xpath(".//div[@class='sl-button-wrapper']/button"));
			action.moveToElement(con).click().build().perform();
			
		}
		
		
		WebElement dropdown = driver.findElement(By.xpath(".//select[@class='sl-select ']"));
		Select select = new Select(dropdown);
		select.selectByValue("0");
		Thread.sleep(1000);
		try {
			action.moveToElement(con).click().build().perform();
			}catch(StaleElementReferenceException e) {
				con = driver.findElement(By.xpath(".//div[@class='sl-button-wrapper']/button"));
				action.moveToElement(con).click().build().perform();
			}
		WebElement firstOption= driver.findElement(By.xpath(".//div[@class='sl-options-wrapper ']/div[1]/label/span"));
		action.moveToElement(firstOption).click().build().perform();
		Thread.sleep(1000);
		try {
			action.moveToElement(con).click().build().perform();
			}catch(StaleElementReferenceException e) {
				con = driver.findElement(By.xpath(".//div[@class='sl-button-wrapper']/button"));
				action.moveToElement(con).click().build().perform();
			}
		
	}
}
