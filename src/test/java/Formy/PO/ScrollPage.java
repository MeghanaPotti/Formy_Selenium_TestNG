package Formy.PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Formy.Utils.Utilities.ScrollUtil;
import Formy.Utils.WebActions;
import junit.framework.Assert;

public class ScrollPage extends XpathsPage{

	public final WebDriver driver;
	public final WebActions app;
	
	public ScrollPage(WebDriver driver) {
		this.driver = driver;
		this.app = new WebActions(driver);			
	}
	
	public void navigateToUrl() {
		String url = "https://formy-project.herokuapp.com/";
		System.out.println("Navigating to "+url);
		driver.get(url);
		app.waitForSeconds(2);
	}
	
	public void scrollingValidation(String name, String date) {
		
		app.click(scrollPageLocator);
		app.waitForSeconds(2);
		
		WebElement pageTitleText = driver.findElement(scrollPageTextLocator);
		String actualText = pageTitleText.getText();
		System.out.println("Actual text is "+actualText);
		String expectedText = "Large page content";
		Assert.assertEquals("Page title text are not matching. ", expectedText, actualText);
	
		WebElement scrollToName = driver.findElement(nameLocator);
		ScrollUtil.scrollToElement(driver, scrollToName);
		scrollToName.sendKeys(name);
		
		WebElement scrollToDate = driver.findElement(dateLocator);
		ScrollUtil.scrollToElement(driver, scrollToDate);
		scrollToDate.sendKeys(date);
	}
}
