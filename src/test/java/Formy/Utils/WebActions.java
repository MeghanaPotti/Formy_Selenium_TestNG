package Formy.Utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebActions {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public WebActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
    }

    public void click(By locator) {
        WebElement element = waitUntilClickable(locator);
        element.click();
        System.out.println("clicked on "+locator);
    }

    public void sendKeys(By locator, String text) {
        WebElement element = waitUntilVisible(locator);
        element.sendKeys(text);
        System.out.println("Entered text is "+text);
    }
    
    public void sendKeys(By locator, int number) {
        WebElement element = waitUntilVisible(locator);
        element.sendKeys(String.valueOf(number));
        System.out.println("Entered text is "+number);
    }
    
    public String getText(By locator) {
        WebElement element = waitUntilVisible(locator);
        System.out.println("Fetched text is "+element.getText());
        return element.getText();
    }
    
    public void dragAndDrop(WebElement source, WebElement target) {         
    	JavascriptExecutor js = (JavascriptExecutor) driver;         
    	js.executeScript("function createEvent(typeOfEvent) {\n" + "var event = document.createEvent(\"CustomEvent\");\n" + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n" + "setData: function (key, value) {\n" +                 "this.data[key] = value;\n" +                 "},\n" +                 "getData: function (key) {\n" +                 "return this.data[key];\n" +                 "}\n" +                 "};\n" +                 "return event;\n" +                 "}\n" +                 "\n" +                 "function dispatchEvent(element, event,transferData) {\n" +                 "if (transferData !== undefined) {\n" +                 "event.dataTransfer = transferData;\n" +                 "}\n" +                 "if (element.dispatchEvent) {\n" +                 "element.dispatchEvent(event);\n" +                 "} else if (element.fireEvent) {\n" +                 "element.fireEvent(\"on\" + event.type, event);\n" +                 "}\n" +                 "}\n" +                 "\n" +                 "function simulateHTML5DragAndDrop(element, destination) {\n" +                 "var dragStartEvent =createEvent('dragstart');\n" +                 "dispatchEvent(element, dragStartEvent);\n" +                 "var dropEvent = createEvent('drop');\n" +                 "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" +                 "var dragEndEvent = createEvent('dragend');\n" +                 "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" +                 "}\n" +                 "\n" +                 "var source = arguments[0];\n" +                 "var destination = arguments[1];\n" +                 "simulateHTML5DragAndDrop(source,destination);", source, target);    
    	System.out.println("Performed drag and drop from source to target");
    }
    
    public void clickDownArrow(By locator) {
    	 WebElement element = waitUntilVisible(locator);
    	 element.sendKeys(Keys.ARROW_DOWN);
    }
    
    public void clickEnterKey(By locator) {
   	 WebElement element = waitUntilVisible(locator);
   	 element.sendKeys(Keys.ENTER);
   }
    
    public void waitForVisibilityOfElement(By locator) {
        waitUntilVisible(locator);
    }

    public void waitForElementToBeClickable(By locator) {
        waitUntilClickable(locator);
    }
    
    public boolean isElementVisible(By locator) {        
    	 try {            
    		 WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));             
    		 return element.isDisplayed();         
    	 } 
    	 catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) 
    	 {             
    		 return false;         
    	 }     
    }

    private WebElement waitUntilVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private WebElement waitUntilClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForPageToLoad(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete");
            }
        });
    }

    public void waitForSeconds(int seconds) {
	    try {
	        Thread.sleep(seconds*1000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
    
}

