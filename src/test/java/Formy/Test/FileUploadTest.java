package Formy.Test;

import org.testng.annotations.Test;

import Formy.PO.FileUploadPage;
import Formy.Utils.WebActions;

public class FileUploadTest extends BaseClass{

	@Test	
	public void fileUpload() {
		
		System.out.println("This is file uploading method");
		FileUploadPage fileObject = new FileUploadPage(driver);
		fileObject.navigateToURL();
		fileObject.fileUploadingValidation();
		WebActions.waitForPageToLoad(driver);
		captureScreenshot("File upload");
	}
}
