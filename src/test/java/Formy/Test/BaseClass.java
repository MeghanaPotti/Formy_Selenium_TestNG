package Formy.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Formy.Utils.AssertionUtils;


public class BaseClass {

	 public WebDriver driver;
	 public AssertionUtils assertionUtils;

	 public String baseUrl="https://formy-project.herokuapp.com/";
	 
	 @BeforeClass
	 public void setUp() {
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
	 }
	
	 @AfterClass
	 public void tearDown() {
		 if(driver !=null) {
			 driver.quit();
		 }
	 }

	 public void captureScreenshot(String testName) {
		 try {
			// Convert WebDriver object to TakesScreenshot
	            TakesScreenshot screenshot = (TakesScreenshot) driver;

	            // Capture screenshot as File
	            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

	            // Get the current time stamp
	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
	            String timestamp = dateFormat.format(new Date());

	            // Define the destination path and file name with the time stamp
	            Path destinationPath = Paths.get("screenshots", testName + "_" + timestamp + ".png");

	            // Copy the screenshot to the destination path
	            Files.copy(srcFile.toPath(), destinationPath);

	            System.out.println("Screenshot captured: " + destinationPath.toString());
		 } catch(IOException e) {
			 System.err.println("Failed to capture screenshot "+e.getMessage());
		 }
	 }
}