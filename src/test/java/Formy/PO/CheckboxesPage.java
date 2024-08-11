package Formy.PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Formy.Utils.WebActions;
import junit.framework.Assert;

public class CheckboxesPage extends XpathsPage{

	public final WebDriver driver;
	public final WebActions app;
	
	public CheckboxesPage(WebDriver driver) {
		this.driver = driver;
        this.app = new WebActions(driver);
	}
	
	public void navigateToURL() {
		String url="https://formy-project.herokuapp.com/";
		System.out.println("Navigating to "+url);
		driver.get(url);
	    app.waitForSeconds(2);
	}
	
	public void checkboxValidation() {
		
		app.click(checkboxLocator);
		app.waitForSeconds(2);
		 
		WebElement componentTitle = driver.findElement(checkboxesText);
		String actualComponent = componentTitle.getText();
		System.out.println("Displayed component title is "+actualComponent);
		String expectedComponent = "Checkboxes";
		Assert.assertEquals("Component title doesn't match", expectedComponent, actualComponent);
		
		app.click(checkboxe1Locator);	
		app.click(checkboxe2Locator);
		app.click(checkboxe3Locator);
		app.click(checkboxe2Locator);
		app.click(checkboxe1Locator);		
		
	}
}
