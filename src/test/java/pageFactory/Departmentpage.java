package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Departmentpage {
	@FindBy(xpath="//*[@id=\"grid-main-container\"]/div[2]/span[3]/ul/li[20]/label/input")
	public WebElement Health;

	@FindBy(xpath="//*[@id=\"grid-main-container\"]/div[2]/span[3]/ul/li[15]/label/input")
	public WebElement furniture;
	
	@FindBy(xpath="//*[@id=\"grid-main-container\"]/div[2]/span[3]/ul/li[31]/label/input")
	public WebElement menswatches;
	
	public void selectcheckbox(String checkbox){
		if(checkbox.equalsIgnoreCase("Health"))
			Health.click();
		else if(checkbox.equalsIgnoreCase("furniture"))
			furniture.click();
		else if(checkbox.equalsIgnoreCase("menswatches"))
			menswatches.click();
	}
}
