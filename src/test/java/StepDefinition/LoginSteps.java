package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	WebDriver driver = null;
	
	@Given("chrome browser is open")
	public void chrome_browser_is_open() {
		
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
	@When("user is on login page")
	public void user_is_on_login_page() {
		
		System.out.println("Inside Step-User is on Login Page");
		
		driver.navigate().to("https://example.testproject.io/web/");
	}

	@And("user enters username and password")
	public void user_enters_username_and_password() throws InterruptedException {
		
		System.out.println("Inside Step-User enters username and Password");
		
		driver.findElement(By.id("name")).sendKeys("Anand");
		driver.findElement(By.id("password")).sendKeys("12345");
		Thread.sleep(2000);
		
	}

	@When("clicks on login button")
	public void clicks_on_login_button() throws InterruptedException {
		
		System.out.println("Inside Step - User clicks on login button");
		driver.findElement(By.id("login")).click();
		Thread.sleep(2000);
		
	}

	@Then("user navigated to homepage")
	public void user_navigated_to_homepage() {
		
	
		boolean Text = driver.getPageSource().contains("Community Powered Test Automation");
		driver.getTitle().contains("Community Powered Test Automation");
		System.out.println("Inside Step-User is navigated to Home Page"+Text);
		
	}

}
