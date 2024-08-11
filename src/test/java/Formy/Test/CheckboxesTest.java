package Formy.Test;

import org.testng.annotations.Test;

import Formy.PO.CheckboxesPage;
import Formy.Utils.WebActions;

public class CheckboxesTest extends BaseClass{

	@Test
	public void checkbox() {
		System.out.println("Checkboxes validation method");
		CheckboxesPage newObject = new CheckboxesPage(driver);
		newObject.navigateToURL();
		newObject.checkboxValidation();
		WebActions.waitForPageToLoad(driver);
//		captureScreenshot("Checkbox");
	}
}
