package Formy.Utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Formy.Test.BaseClass;

public class Utilities extends BaseClass{

	public void setInputText(WebDriver driver,String xpath,String inputText) {
		driver.findElement(By.xpath(xpath)).sendKeys(inputText);
	}
	public void click(WebDriver driver,String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void softAssert(String actualText, String expectedText) {
		if(actualText.equals(expectedText)) //or String.equals and for int, we use text== 
		{
		Assert.assertTrue(true);
	}
	else {
		System.out.println("actualText is "+actualText + ", expectedText is "+expectedText);
		Assert.assertTrue(false);
	}
	}
	public void softAssert(int actualNumber, int expectedNumber) {
		if(actualNumber==expectedNumber) //or String.equals and for int, we use text== 
		{
		Assert.assertTrue(true);
	}
	else {
		System.out.println("actualNumber is "+actualNumber + ", expectedNumber is "+expectedNumber);
		Assert.assertTrue(false);	
	}
	}
	
	public void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(fileWithPath);
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		}
	
	public String getTimeStamp() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());
        return timestamp;
	}
	
	 /**
     * Updates the current date and time based on the input days and returns the result in London time.
     *
     * @param days the number of days to add to (or subtract from) the current date and time
     * @return the updated date and time in London time formatted as "yyyy-MM-dd HH:mm"
     */
	 public static String updateEventStartTime(int days) {
	        // Get the current system date and time
	        LocalDateTime currentDateTime = LocalDateTime.now();
	        
	        // Convert the current date and time to London time
	        ZonedDateTime londonDateTime = currentDateTime.atZone(ZoneId.systemDefault())
	                                                      .withZoneSameInstant(ZoneId.of("Europe/London"));
	        
	        // Add the input days to the London date and time
	        ZonedDateTime updatedTime = londonDateTime.plusDays(days);
	        
	        // Define the desired format
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	        
	        // Format and return the updated time
	        return updatedTime.format(formatter);
	    }	 
	 
	    public static String getDynamicTimestamp() {
	        // Get the current date and time
	        LocalDateTime now = LocalDateTime.now();

	        // Add the desired amount of time to get the dynamic date and time
	        LocalDateTime dynamicTime = now.plusDays(0).withHour(14).withMinute(30).withSecond(0);

	        // Define the desired format
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	        // Format the LocalDateTime to a string
	        return dynamicTime.format(formatter);
	    }
	    
	    public static class ScrollUtil {

	        // Method to scroll to a specific element
	        public static void scrollToElement(WebDriver driver, WebElement element) {
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	        }

	        // Method to scroll to the bottom of the page
	        public static void scrollToBottom(WebDriver driver) {
	            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
	        }

	        // Method to scroll to the top of the page
	        public static void scrollToTop(WebDriver driver) {
	            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
	        }

	        // Method to scroll by a specific number of pixels
	        public static void scrollByPixels(WebDriver driver, int x, int y) {
	            ((JavascriptExecutor) driver).executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
	        }
	    }
	    
	    public static String getOrdinalSuffix(int number) {
	        if (number >= 11 && number <= 13) {
	            return "th";
	        }
	        switch (number % 10) {
	            case 1: return "st";
	            case 2: return "nd";
	            case 3: return "rd";
	            default: return "th";
	        }
	    }

}

