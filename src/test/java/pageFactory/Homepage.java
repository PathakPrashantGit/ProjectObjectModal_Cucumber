package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage {
//WebElements + BusinessLogics
	//WebElement todaysdeal = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[1]"));
	@FindBy(xpath="//*[@id=\"nav-main\"]/div[1]/div/div/div[3]/span[1]/span/input") 
	public WebElement dontchange;
	
	@FindBy(xpath="//*[@id=\"nav-xshop\"]/a[1]") 
	public WebElement todaysdeal;
	
	public void clickondontchange(){
		try{
		dontchange.click();
		}catch(Throwable t){}
	}
	
	public void clickontodaysdeal(){
		todaysdeal.click();
	}
}
