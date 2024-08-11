package Formy.PO;

import org.openqa.selenium.By;

public class XpathsPage {
 
	By brandTitle = By.xpath("//*[@id='logo']");
	By homePageList = By.xpath("// *[@class='btn btn-lg']"); 
	By componentsDropdown = By.xpath("//*[@id='navbarDropdownMenuLink']");
	By dropdownList = By.xpath("//*[@class='dropdown-item']");	
	By pageTitleLocator = By.xpath("//*[@class='container']//h1");
	
	By checkboxLocator = By.xpath("//*[@class='jumbotron-fluid']//*[text()='Checkbox']");
	By checkboxesText = By.xpath("//*[text()='Checkboxes']");
	By checkboxe1Locator = By.xpath("//*[@id='checkbox-1']");
	By checkboxe2Locator = By.xpath("//*[@id='checkbox-2']");
	By checkboxe3Locator = By.xpath("//*[@id='checkbox-3']");
	
	By buttonsLocator = By.xpath("//*[@class='jumbotron-fluid']//*[text()='Buttons']");
	By primaryLocator = By.xpath("//*[text()='Primary']");
	By successLocator = By.xpath("//*[text()='Success']");
	By infoLocator = By.xpath("//*[text()='Info']");
	By warningLocator = By.xpath("//*[text()='Warning']");
	By dangerLocator = By.xpath("//*[text()='Danger']");
	By linkLocator = By.xpath("//*[text()='Link']");
	
	By fileUploadLocator = By.xpath("//*[@class='jumbotron-fluid']//*[text()='File Upload']");
	By chooseLocator = By.xpath("//*[@class='btn btn-secondary btn-choose' and @type='button']");
	By inputBoxLocator = By.xpath("//*[@id='file-upload-field']");
	By resetLocator = By.xpath("//*[@class='btn btn-warning btn-reset' and @type='button']");
	
	By scrollPageLocator = By.xpath("//*[@class='jumbotron-fluid']//*[text()='Page Scroll']");
	By scrollPageTextLocator = By.xpath("//*[@class='container']//h1");
	By contentLocator  = By.xpath("//*[@class='col-sm-12']");
	By nameLocator = By.xpath("//*[@id='name']");
	By dateLocator = By.xpath("//*[@id='date']");
	
	By radioButtonLocator = By.xpath("//*[@class='jumbotron-fluid']//*[text()='Radio Button']");	
	By radioButton1Locator = By.xpath("//*[@value='option1']");
	By radioButton2Locator = By.xpath("//*[@value='option2']");
	By radioButton3Locator = By.xpath("//*[@value='option3']");
		
	By switchWindowLocator = By.xpath("//*[@class='jumbotron-fluid']//*[text()='Switch Window']");
	By openTabLocator = By.xpath("//*[@id='new-tab-button']");
	By openAlertLocator = By.xpath("//*[@id='alert-button']");
	
}
