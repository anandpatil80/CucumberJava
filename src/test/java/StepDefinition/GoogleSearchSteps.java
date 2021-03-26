package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {

	WebDriver driver=null;
	
	@Given("browser is open")
	public void browser_is_open() {
		System.out.println("Inside Step-Browser is Open");
		
		String ProjectPath =System.getProperty("user.dir");
		
		System.out.println("Project path is:"+ProjectPath);
		
		//Relative Path
		System.setProperty("webdriver.chrome.driver",ProjectPath+"/src/test/resources/Drivers/chromedriver.exe");
		
		//Absolute Path
		//System.setProperty("webdriver.chrome.driver","C:/Users/hp/eclipse-workspace/CucumberJava/src/test/resources/Drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@And("User is on Google Search Page")
	public void user_is_on_google_search_page() {
		System.out.println("Inside Step-User is on Search Page");
		
		driver.navigate().to("https://Google.Com");
				
	}

	@When("User Enter a Text in Search Box")
	public void user_enter_a_text_in_search_box() {
		System.out.println("User Enter Text in Search box");
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		
	}

	@When("Hit Enter Button")
	public void hit_enter_button() {
		System.out.println("Inside Step-User hits Enter");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@Then("User is Navigated to Search Results")
	public void user_is_navigated_to_search_results() {
		System.out.println("Inside Step-User is Navigated to Search Results");
		driver.getPageSource().contains("Online Course");
		driver.close();
		driver.quit();
		
	}
}
