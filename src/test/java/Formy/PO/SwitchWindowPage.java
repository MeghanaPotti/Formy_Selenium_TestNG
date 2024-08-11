package Formy.PO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Formy.Utils.WebActions;
import junit.framework.Assert;

public class SwitchWindowPage extends XpathsPage{

	public final WebDriver driver;
	public final WebActions app;
	
	public SwitchWindowPage(WebDriver driver) {
		this.driver = driver;
		this.app = new WebActions(driver);
	}
	
	public void navigateToUrl(){
		String url = "https://formy-project.herokuapp.com/";
		System.out.println("Navigating to "+url);
		driver.get(url);
		app.waitForSeconds(2);
	}
	
	public void switchingWindowValidation() {
		
		app.click(switchWindowLocator);
		app.waitForSeconds(2);
		
		app.click(openAlertLocator);
		app.waitForSeconds(2);
		Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);
        alert.accept();
        
		app.click(openTabLocator);
		app.waitForSeconds(2);
		WebElement brandText = driver.findElement(brandTitle);
		String actualText = brandText.getText();
		System.out.println("Displayed title is "+actualText);
		String expectedText = "FORMY";
		Assert.assertEquals("Switched window brand title is not matching. ", expectedText, actualText);		
	
	}
}
