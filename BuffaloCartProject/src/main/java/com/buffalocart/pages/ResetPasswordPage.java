package com.buffalocart.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;

public class ResetPasswordPage extends PageUtility{
	WebDriver driver;
	public ResetPasswordPage(WebDriver driver) //constructor (driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='panel-heading']")
	WebElement resetpage;
	@FindBy(id="email")
	WebElement email;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement submitEmail;
	@FindBy(xpath="//span[@class='help-block']/strong")
	WebElement errorMsg;
	public void enterEmailForRecovery(String emailtxt) {
		
		enterText(email,emailtxt);
	}
	public void clickSubmitEmail()
	{
		clickOnElement(submitEmail);
		//return new ResetPasswordPage(driver);
	}
	public String getTextOfErrorMessage()
	{
		//sleep(2000);
		waitForElement(driver,"xpath","//span[@class='help-block']/strong");
		return getElementText(errorMsg);
	}
	public boolean isresetPage()
	{
		//sleep(3000);
		waitForElement(driver,"xpath","//div[@class='panel-heading']");
	return  getElementDisplayStatus(resetpage); 	
	}

}
