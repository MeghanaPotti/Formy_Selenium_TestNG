package Formy.Test;

import org.testng.annotations.Test;

import Formy.PO.ButtonsPage;
import Formy.Utils.WebActions;

public class ButtonsTest extends BaseClass{
	
	@Test
	public void buttons() {
		System.out.println("Buttons CSS validation method");
		ButtonsPage cssObject = new ButtonsPage(driver);
		cssObject.navigateToURL();
		cssObject.buttonsValidation();
		WebActions.waitForPageToLoad(driver);
		captureScreenshot("Buttons");
	}

}
