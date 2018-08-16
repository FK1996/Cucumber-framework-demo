package SeleniumGlueCode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginTest {
	
	public static WebDriver driver;
	
	@Given("^user is  on DT ITS Portal$")
	public void user_is_on_DT_ITS_Portal() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver","src//main//java//driver//chromedriver.exe");
	    driver =new ChromeDriver();
	    driver.navigate().to("https://control.dtitsupport247.net");//navigate to the link
	    driver.manage().window().maximize();//maximze the window
	    
	    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
}

	@Then("^user enters username and Password$")
	public void user_enters_username_and_Password() throws Throwable {
	    
		driver.findElement(By.cssSelector("[type=\"text\"]")).sendKeys("farheen.kamal@continuum.net");//email field 
	    driver.findElement(By.cssSelector("[type=\"password\"]")).sendKeys("Abc@1234");//password field
	   
	    WebDriverWait wait = new WebDriverWait(driver, 50);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type=\"password\"]")));
}

	@Then("^click on Log In button$")
	public void click_on_Log_In_button() throws Throwable {
		
		 driver.findElement(By.cssSelector("#loginButton_0")).click();//password next click
		 driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
}

	@Then("^success message is displayed$")
	public void success_message_is_displayed() throws Throwable {
		String at = driver.getTitle();
		String et = "itsupport247";
		if(at.equalsIgnoreCase(et))
		{
			System.out.println("Test Success");
		}
		else
		{
			System.out.println("Test Failure");
		}
	}
		
}
