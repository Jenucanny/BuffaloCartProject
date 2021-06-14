package com.buffalocart.pages;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;

public class SalesCommisionAgentsPage extends PageUtility {
	WebDriver driver;
	public SalesCommisionAgentsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//section[@class='content-header']")
	WebElement salespage;
	@FindBy(xpath="//div[@class='box-tools']//button")
	WebElement addsales;
	@FindBy(id="surname")
	WebElement sur;
	@FindBy(id="first_name")
	WebElement fname;
	@FindBy(id="last_name")
	WebElement lname;
	@FindBy(id="email")
	WebElement email;
	@FindBy(id="contact_no")
	WebElement contact;
	@FindBy(id="address")
	WebElement adr;
	@FindBy(id="cmmsn_percent")
	WebElement comsn;
	@FindBy(xpath="//button[@type='submit']")
	WebElement save;
	@FindBys(
	@FindBy(xpath="//table[@id='sales_commission_agent_table']//tbody//tr[1]//td"))
	List <WebElement> checkoptions;
	
	
	
	public boolean issalespageload()
	{
		//sleep(3000);
		waitForElement(driver,"xpath","//section[@class='content-header']");
		return  getElementDisplayStatus(salespage); 
		
	}
	public void clickOnaddsalesbutton()
	{
		//sleep(2000);
		waitForElement(driver,"xpath","//div[@class='box-tools']//button");
		clickOnElement(addsales);
		//sleep(2000);
	}
	public void entersur(String str)
	{   //sleep(2000);
		waitForElement(driver,"id","surname");
		enterText(sur,str);
	}
public void enterFname(String str)
{
	enterText(fname,str);
}
public void enterLname(String str)
{
	enterText(lname,str);	
}

public void enterEmail(String str)
{
	enterText(email,str);	
}
public void enterContact(String str)
{
	enterText(contact,str);	
}
public void enteraddress(String str)
{
	enterText(adr,str);	
}
public void enterCommission(String str)
{
	enterText(comsn,str);	
}
public void clickSave()
{
	waitForElement(driver,"xpath","//button[@type='submit']");
	//sleep(2000);
	clickOnElement(save);	
}
public String checktable(String str)
{
	//sleep(2000);
	waitForElement(driver,"xpath","//table[@id='sales_commission_agent_table']//tbody//tr[1]//td");
	String str1="";
	for(int i=0;i<checkoptions.size();i++)
	{
		if(checkoptions.get(i).getText().equalsIgnoreCase(str))
				{
			str1=checkoptions.get(i).getText();
				}
	}
	return str1;
}

}
