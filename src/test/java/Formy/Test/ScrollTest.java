package Formy.Test;

import org.testng.annotations.Test;

import Formy.PO.ScrollPage;
import Formy.Utils.WebActions;

public class ScrollTest extends BaseClass{
	
	@Test	
	public void scrolling() {
		
		System.out.println("This is scrolling method");
		ScrollPage scrollObject = new ScrollPage(driver);
		scrollObject.navigateToUrl();
		scrollObject.scrollingValidation("Meghana Potti", "04/14/2024");
		WebActions.waitForPageToLoad(driver);
		captureScreenshot("Scroll");
	}
	
}
