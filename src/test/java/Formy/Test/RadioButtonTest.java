package Formy.Test;

import org.testng.annotations.Test;

import Formy.PO.RadioButtonsPage;
import Formy.Utils.WebActions;


public class RadioButtonTest extends BaseClass{
	
	@Test
	public void radioButton() {
		System.out.println("Radio buttons validation method");
		RadioButtonsPage radioObject =  new RadioButtonsPage(driver);
		radioObject.navigateToURL();
		radioObject.radioButtonsValidation();
		WebActions.waitForPageToLoad(driver);
		captureScreenshot("Radio buttons");
	}

}
