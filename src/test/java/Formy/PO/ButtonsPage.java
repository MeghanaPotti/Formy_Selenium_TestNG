package Formy.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Formy.Utils.WebActions;
import junit.framework.Assert;

public class ButtonsPage extends XpathsPage{

	public final WebDriver driver;
	public final WebActions app;
	
	public ButtonsPage(WebDriver driver) {
		
		this.driver = driver;
        this.app = new WebActions(driver);
	}
	
	public void navigateToURL() {
		String url="https://formy-project.herokuapp.com/";
		System.out.println("Navigating to "+url);
		driver.get(url);
	    app.waitForSeconds(2);
	}
	
	public void buttonsValidation() {
		
		 app.click(buttonsLocator);
	        app.waitForSeconds(2);

	        // Test buttons
	        testButton(primaryLocator, "Primary", "rgba(0, 123, 255, 1)", "20px", "rgba(255, 255, 255, 1)");
	        testButton(successLocator, "Success", "rgba(40, 167, 69, 1)", "20px", "rgba(255, 255, 255, 1)");
	        testButton(infoLocator, "Info", "rgba(23, 162, 184, 1)", "20px", "rgba(255, 255, 255, 1)");
	        testButton(warningLocator, "Warning", "rgba(255, 193, 7, 1)", "20px", "rgba(33, 37, 41, 1)");
	        testButton(dangerLocator, "Danger", "rgba(220, 53, 69, 1)", "20px", "rgba(255, 255, 255, 1)");
	        testButton(linkLocator, "Link", "rgba(0, 0, 0, 0)", "20px", "rgba(0, 123, 255, 1)");
	    }

	public void testButton(By locator, String expectedText, String expectedBgColor, String expectedFontSize, String expectedColor) {
	        WebElement button = driver.findElement(locator);
	        String actualText = button.getText();
	        String actualBgColor = button.getCssValue("background-color");
	        String actualFontSize = button.getCssValue("font-size");
	        String actualColor = button.getCssValue("color");

	        System.out.println("Button text: " + actualText);
	        System.out.println("Background color: " + actualBgColor);
	        System.out.println("Font size: " + actualFontSize);
	        System.out.println("Color: " + actualColor);

	        Assert.assertEquals("Button text does not match", expectedText, actualText);
	        Assert.assertEquals("Background color does not match", expectedBgColor, actualBgColor);
	        Assert.assertEquals("Font size does not match", expectedFontSize, actualFontSize);
	        Assert.assertEquals("Color does not match", expectedColor, actualColor);
	    }
}

//app.click(buttonsLocator);
//app.waitForSeconds(2);
//		
//WebElement primary = driver.findElement(primaryLocator);		
//String actualButtonText = primary.getText();
//System.out.println("Actual button text is "+actualButtonText);
//String expectedButtonText = "Primary";
//Assert.assertEquals("Button names are not matching ", expectedButtonText, actualButtonText);
//
//String actualButtonBgColor= primary.getCssValue("background-color");
//System.out.println("Primary background color is "+actualButtonBgColor);
//String expectedButtonBgColor = "rgba(0, 123, 255, 1)";
//Assert.assertEquals("BG is not matching ", expectedButtonBgColor, actualButtonBgColor);
//
//String actualFontSize = primary.getCssValue("font-size");
//System.out.println("Primary fontsize is "+actualFontSize);
//String expectedFontSize = "20px";
//Assert.assertEquals("Font is not matching ", expectedFontSize, actualFontSize);
//
//String actualColor = primary.getCssValue("color");
//System.out.println("Primary color is "+actualColor);
//String expectedColor = "rgba(255, 255, 255, 1)";
//Assert.assertEquals("Font is not matching ", expectedColor, actualColor);
//
//WebElement success = driver.findElement(successLocator);
//String actualSuccessText = success.getText();
//System.out.println("Actual text is "+actualSuccessText);
//String actualSuccessBgColor = success.getCssValue("background-color");
//System.out.println("Success bg is "+actualSuccessBgColor);  // rgba(0, 123, 255, 1)
//String actualSuccessFontSize = success.getCssValue("font-size");		
//System.out.println("Success fontsize is "+actualSuccessFontSize);
//String actualSuccessColor = success.getCssValue("color");
//System.out.println("Success color is "+actualSuccessColor);
//
//WebElement info = driver.findElement(infoLocator);	
//String actualInfoText = info.getText();
//System.out.println("Actual text is "+actualInfoText);
//String actualInfoBgColor= info.getCssValue("background-color");
//System.out.println("Info Bg is "+actualInfoBgColor);
//String actualInfoFontSize = info.getCssValue("font-size");
//System.out.println("Info fontsize is "+actualInfoFontSize);
//String actualInfoColor = info.getCssValue("color");
//System.out.println("Info color is "+actualInfoColor);
//
//WebElement warning = driver.findElement(warningLocator);
//String actualWarningText = warning.getText();
//System.out.println("Actual text is "+actualWarningText);
//String actualWarningBgColor= warning.getCssValue("background-color");
//System.out.println("Warning Bg is "+actualWarningBgColor);
//String actualWarningFontSize = warning.getCssValue("font-size");
//System.out.println("Warning fontsize is "+actualWarningFontSize);
//String actualWarningColor = warning.getCssValue("color");
//System.out.println("Warning color is "+actualWarningColor);
//
//WebElement danger = driver.findElement(dangerLocator);
//String actualDangerText = danger.getText();
//System.out.println("Actual text is "+actualDangerText);
//String actualDangerBgColor= danger.getCssValue("background-color");
//System.out.println("Danger Bg is "+actualDangerBgColor);
//String actualDangerFontSize = danger.getCssValue("font-size");
//System.out.println("Danger fontsize is "+actualDangerFontSize);
//String actualDangerColor = danger.getCssValue("color");
//System.out.println("Danger color is "+actualDangerColor);
//
//WebElement link = driver.findElement(linkLocator);	
//String actualLinkText = link.getText();
//System.out.println("Actual text is "+actualLinkText);
//String actualLinkBgColor= link.getCssValue("background-color");
//System.out.println("Link Bg is "+actualLinkBgColor);
//String actualLinkFontSize = link.getCssValue("font-size");
//System.out.println("Link fontsize is "+actualLinkFontSize);
//String actualLinkColor = link.getCssValue("color");
//System.out.println("Link color is "+actualLinkColor);
//}		

   
