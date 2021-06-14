package com.buffalocart.testscript;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.buffalocart.automationcore.Base;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.SalesCommisionAgentsPage;
import com.buffalocart.pages.UserManagementPage;


public class SalesCommisionAgentsTest extends Base {
	LoginPage login;
	HomePage home;
	UserManagementPage mgmt;
	SalesCommisionAgentsPage sale;
	@Test(priority=1)
	public void verifyIsSalesPageLoaded()
	{
		login=new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("123456");
		home=login.clickLoginButton();
		home.handleEndTour();
		mgmt=home.clickOnUserManagementPage();
		sale=mgmt.clickOnSalesPage();	
		boolean result=sale.issalespageload();
		Assert.assertTrue(result, "Sales Page is not Loaded");
		
	}
	@Test(priority=2)
	public void verifySalesPageTitle()
	{
		login=new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("123456");
		home=login.clickLoginButton();
		home.handleEndTour();
		mgmt=home.clickOnUserManagementPage();
		sale=mgmt.clickOnSalesPage();	
		String actualsalesPageTitle=driver.getTitle();
		String expectedsalesPageTitle="Sales Commission Agents - Reobeen LLC";
		Assert.assertEquals(actualsalesPageTitle, expectedsalesPageTitle,"Title Mismatch");
	}
	@Test(priority=3)
	public void verifyAddSalesInformation()
	{
		login=new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("123456");
		home=login.clickLoginButton();
		home.handleEndTour();
		mgmt=home.clickOnUserManagementPage();
		sale=mgmt.clickOnSalesPage();	
		sale.clickOnaddsalesbutton();
		sale.entersur("Mr");
		sale.enterFname("Jo");
		sale.enterLname("Jihan");
		sale.enterEmail("jojihan@gmail.com");
		sale.enterContact("123456789");
		sale.enteraddress("Delhi");
		sale.enterCommission("0.1");
		sale.clickSave();
		
	}
	@Test(priority=4)
	public void VerifyTableContent()
	{
		login=new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("123456");
		home=login.clickLoginButton();
		home.handleEndTour();
		mgmt=home.clickOnUserManagementPage();
		sale=mgmt.clickOnSalesPage();
		String actualResult=sale.checktable("Mr Jo Jihan");
		String expectedResult="Mr Jo Jihan";
		Assert.assertEquals(actualResult, expectedResult,"Element is not present");
		
	}

}
