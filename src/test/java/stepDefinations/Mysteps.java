package stepDefinations;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.netty.util.concurrent.SucceededFuture;
import pageFactory.Add2cartpage;
import pageFactory.Departmentpage;
import pageFactory.Homepage;
import pageFactory.Itemspage;
import pageFactory.Itemsublistpage;
import pageFactory.Sucessmsgpage;
import testBase.TestBase;

public class Mysteps extends TestBase{
	@BeforeAll
	public static void beforeAll() throws Throwable{
		openBrowser();
	}
	@AfterAll
	public static void afterAll(){
		closeBrowser();
	}
	
	 	@Given("^user is in the department page$")
	    public void user_is_in_the_department_page() throws Throwable {
	      // Homepage hp=new Homepage();
	 		Homepage hp = PageFactory.initElements(driver, Homepage.class);
	       hp.clickondontchange();
	       hp.clickontodaysdeal();
	    }

	    @When("^user select \"([^\"]*)\" checkbox, clicks on item$")
	    public void user_select_something_checkbox_clicks_on_item(String checkbox) throws Throwable {
	        Departmentpage dp = PageFactory.initElements(driver, Departmentpage.class);
	        Itemspage ip = PageFactory.initElements(driver, Itemspage.class);
	        Itemsublistpage isp = PageFactory.initElements(driver, Itemsublistpage.class);
	        
	        dp.selectcheckbox(checkbox);
	        ip.clickonfirstitem();
	        isp.clickonfirstiteminsublist();
	    }

	    @Then("^successfully an item should be added to cart$")
	    public void successfully_an_item_should_be_added_to_cart() throws Throwable {
	       Sucessmsgpage sp = PageFactory.initElements(driver, Sucessmsgpage.class);
	       sp.verifysucessmsg();
	    }

	    @And("^click on add2cart$")
	    public void click_on_add2cart() throws Throwable {
	       Add2cartpage acp = PageFactory.initElements(driver, Add2cartpage.class);
	       acp.clickonadd2cart();
	    }

	    @AfterStep
	    public void takescreenshots(Scenario scenario){
	        final  byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	        scenario.attach(screenshot,"image/png","image");
	    }
}
