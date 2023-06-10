package pageFactory;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginBySelenium {

 WebDriver driver ;
 SoftAssert st;
	
	
	@Given("User is in the Login page")
	public void user_is_in_the_login_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40000));
	    	}
	@When("user enter valid username and password")
	public void user_enter_valid_username_and_password() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
	    
	}
	@When("click on the Login button")
	public void click_on_the_login_button() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@Then("user should successfully Login")
	public void user_should_successfully_login() {
        
		st = new SoftAssert();
		
		String expectedTittle = "OrangeHRM"; 
		
		String actualTittle = driver.getTitle();
		
		st.assertEquals(expectedTittle, actualTittle);
		st.assertAll();
		
		System.out.println(actualTittle);
	    
	}
}
