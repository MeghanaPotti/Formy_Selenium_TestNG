package Formy.PO;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Formy.Utils.WebActions;
import junit.framework.Assert;
import Formy.Utils.Utilities;

public class LaunchPage extends XpathsPage {

	public final WebDriver driver;
	public final WebActions app;
	
	public LaunchPage(WebDriver driver) {
		this.driver = driver;
        this.app = new WebActions(driver);
	}
	
	public void navigateToURL() {
		String url="https://formy-project.herokuapp.com/";
		System.out.println("Navigating to "+url);
		driver.get(url);
	    app.waitForSeconds(2);
	}
	
	public void componentsValidation() {		

		WebElement brandElement = driver.findElement(brandTitle);		
		String actualBrand = brandElement.getText();
		System.out.println("Displayed brand is "+actualBrand);
		String expectedBrand = "FORMY";
		Assert.assertEquals("The brand logo text does not match the expected value.", expectedBrand, actualBrand);
		 
		 List<WebElement> homePageOptions = driver.findElements(homePageList);
		 List<String> homePageOptionTexts = new ArrayList<>();
		 int homePageCount=1;
         for (WebElement option : homePageOptions) {
             String homePageOptionText = option.getText();
             homePageOptionTexts.add(homePageOptionText);
             String suffix = Utilities.getOrdinalSuffix(homePageCount);
             System.out.println(homePageCount+ suffix+ " Option from homepage is "+homePageOptionText);
             homePageCount++;
         }		

		 WebElement dropdownElement = driver.findElement(componentsDropdown);
         dropdownElement.click();
		   
         List<WebElement> dropdownOptions = driver.findElements(dropdownList);
         List<String> dropdownOptionTexts = new ArrayList<>();
         int dropDownCount=1;
         for (WebElement option1 : dropdownOptions) {
             String dropdownOptionText = option1.getText();
             dropdownOptionTexts.add(dropdownOptionText);
             String suffix = Utilities.getOrdinalSuffix(dropDownCount);
             System.out.println(dropDownCount+ suffix+ " Option from dropdown is "+dropdownOptionText);
             dropDownCount++;
         }	
         
         Assert.assertEquals("The list of components doesn't match", homePageOptionTexts, dropdownOptionTexts); 
	}

}
