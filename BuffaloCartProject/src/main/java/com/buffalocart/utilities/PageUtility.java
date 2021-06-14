package com.buffalocart.utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtility {
	public static int IMPLICIT_TIME=20;
	public static int EXPLICIT_TIME=20;
	public static int PAGELOAD_WAIT=20;
	public WebElement waitForElementToBeVisible(WebDriver driver, WebElement elementToBeLoaded, int time)
	{
		WebDriverWait wait=new WebDriverWait(driver,time);
		WebElement element=wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
		return element;
	}
	public boolean getElementDisplayStatus(WebElement element)
	{
		return element.isDisplayed();
	}
	public void enterText(WebElement element,String text)
	{
		element.sendKeys(text);
	}
	public void clickOnElement(WebElement element)
	{
		element.click();
	}
	public void sleep(long timeout)
	{
		try 
		{
			Thread.sleep(timeout);
		}
		catch(InterruptedException e )
		{
			e.printStackTrace();
		}
	}
	public String getElementText(WebElement element)
	{
		return element.getText();
	}
	public void waitForAnElement(WebDriver driver, String locator)
	{
		WebDriverWait wait=new WebDriverWait(driver,IMPLICIT_TIME);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
	public void waitForElement(WebDriver driver, String locator,String path)
	{
		WebDriverWait wait=new WebDriverWait(driver,IMPLICIT_TIME);
		
		switch(locator)
		{
		case "xpath":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
			break;
		case "id":	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(path)));
			break;
		 default:
			String text= "invalid locator found";
			
		}
	}
	
	public void textSend(WebElement element,String str)
	{
		element.sendKeys(str);
	}	
}