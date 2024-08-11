package Formy.Test;

import org.testng.annotations.Test;

import Formy.PO.LaunchPage;
import Formy.Utils.WebActions;

public class LaunchTest extends BaseClass{
	 
	@Test
	public void launchTest() {
		
		System.out.println("URL launching method");
		LaunchPage launchObject = new LaunchPage(driver);
		launchObject.navigateToURL();
		launchObject.componentsValidation();
		WebActions.waitForPageToLoad(driver);
		captureScreenshot("Launch page");		
	}
}
