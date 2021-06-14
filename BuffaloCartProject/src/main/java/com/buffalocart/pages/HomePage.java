package com.buffalocart.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;

public class HomePage extends PageUtility {
	WebDriver driver;
	public HomePage(WebDriver driver) //constructor (driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//@FindBy(xpath="//a[@class='dropdown-toggle']//span")
	@FindBy(xpath="//span[@class='logo-lg']")
	WebElement userpage;
	@FindBy(xpath="//button[@data-role='end']")
	WebElement endTour; 
	@FindBy(xpath="//section[@class='sidebar']/ul/li[2]/a")
	WebElement clickUserManagementPage;
	@FindBy(xpath="//div[@class='m-8 pull-left mt-15 hidden-xs']//strong")
	WebElement date;
	public boolean isHomePageLoaded() {
		//sleep(3000);
		waitForElement(driver,"xpath","//span[@class='logo-lg']");
		return getElementDisplayStatus(userpage);
		
	}
	public void handleEndTour()
	{
		waitForElement(driver,"xpath","//button[@data-role='end']");
		clickOnElement(endTour);
		
	}
	public UserManagementPage clickOnUserManagementPage() {
		//sleep(2000);
		waitForElement(driver,"xpath","//section[@class='sidebar']/ul/li[2]/a");
		clickOnElement(clickUserManagementPage);
		return new UserManagementPage(driver);
		
	}
	public String checkDate()
	{
		//sleep(3000);
		waitForElement(driver,"xpath","//div[@class='m-8 pull-left mt-15 hidden-xs']//strong");
		return date.getText();
		
	}

}
