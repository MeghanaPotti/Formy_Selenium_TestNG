package Formy.PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Formy.Utils.WebActions;
import junit.framework.Assert;

public class RadioButtonsPage extends XpathsPage{

	public final WebDriver driver;
	public final WebActions app;
	
	public RadioButtonsPage(WebDriver driver) {
		this.driver = driver;
		this.app = new WebActions(driver);
	}
	
	public void navigateToURL() {
		String url = "https://formy-project.herokuapp.com/";
		System.out.println("Navigating to "+url);
		driver.get(url);
		app.waitForSeconds(2);
	}
	
	public void radioButtonsValidation() {
		
		app.click(radioButtonLocator);
		app.waitForSeconds(2);
		
		WebElement pageTitle =  driver.findElement(pageTitleLocator);
		String actualText = pageTitle.getText();
		System.out.println("Page title is "+actualText);
		String expectedText = "Radio buttons";
		Assert.assertEquals("Page title is not matching ", expectedText, actualText);
		
		app.click(radioButton1Locator);
		app.click(radioButton2Locator);
		app.click(radioButton1Locator);
		app.click(radioButton3Locator);
				
	}
}
