package Formy.Test;

import org.testng.annotations.Test;

import Formy.PO.SwitchWindowPage;
import Formy.Utils.WebActions;


public class SwitchWindowTest extends BaseClass{

	@Test
	public void switchWindow() {
		System.out.println("Switching windows method");
		SwitchWindowPage switchObject = new SwitchWindowPage(driver);
		switchObject.navigateToUrl();
		switchObject.switchingWindowValidation();
		WebActions.waitForPageToLoad(driver);
		captureScreenshot("Switch");
	}
}
