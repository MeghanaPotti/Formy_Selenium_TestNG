package Formy.PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Formy.Utils.WebActions;
import junit.framework.Assert;

public class FileUploadPage extends XpathsPage{
	
	public final WebDriver driver;
	public final WebActions app;
	
	public FileUploadPage(WebDriver driver) {
		this.driver = driver;
		this.app = new WebActions(driver);
	}
	
	public void navigateToURL() {
		String url="https://formy-project.herokuapp.com/";
		System.out.println("Navigating to "+url);
		driver.get(url);
	    app.waitForSeconds(2);
	}
	
	public void fileUploadingValidation() {
		
		app.click(fileUploadLocator);
		app.waitForSeconds(2);
		
		WebElement pageTitle = driver.findElement(pageTitleLocator);
		String actualText = pageTitle.getText();
		System.out.println("Actual title is "+actualText);
		String expectedText = "File upload";
		Assert.assertEquals("Page title is not matching ", expectedText, actualText);
		
		WebElement fileInput = driver.findElement(inputBoxLocator);
		String filePath = "C:\\Users\\Potti.Meghana\\Downloads\\Rohith_Resume";
		fileInput.sendKeys(filePath);
		System.out.println("File uploaded successfully.");
	}

}
