package testBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestBase {
	
	public static Properties prop;
	public static String Browser;
	public static WebDriver driver;
	public static SoftAssert st;
	
	public static void openBrowser() throws Throwable{
		st=new SoftAssert();
		prop=new Properties();
		prop.load(new FileReader("src\\test\\java\\config\\Global.properties"));
		Browser=prop.getProperty("Browser");
		System.out.println("Browser choosen is "+Browser);
		if(Browser.equalsIgnoreCase("chrome"))
			driver=new ChromeDriver();
		else if(Browser.equalsIgnoreCase("mozilla"))
			driver=new FirefoxDriver();
		else if(Browser.equalsIgnoreCase("edge"))
			driver=new EdgeDriver();
		
		driver.get(prop.getProperty("url")); //open url
		driver.manage().window().maximize();//maximize browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void closeBrowser(){
		driver.quit();
	}
}
