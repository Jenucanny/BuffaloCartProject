package com.buffalocart.testscript;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.buffalocart.automationcore.Base;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.RolesPage;
import com.buffalocart.pages.UserManagementPage;

public class RolesTest extends Base {
	LoginPage login;
	HomePage home;
	UserManagementPage mgmt;
	RolesPage role;
	@Test(priority=1)
	public void verifyIsRolesPageLoaded()
	{
		login=new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("123456");
		home=login.clickLoginButton();
		home.handleEndTour();
		mgmt=home.clickOnUserManagementPage();
		role=mgmt.ClickOnRolesPage();	
		boolean result=role.isrolesPage();
		Assert.assertTrue(result, "Roles Page is not Loaded");
	}
	@Test(priority=2)
	public void verifyRolesTitle()
	{
		login=new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("123456");
		home=login.clickLoginButton();
		home.handleEndTour();
		mgmt=home.clickOnUserManagementPage();
		role=mgmt.ClickOnRolesPage();	
		String actualrolesPageTitle=driver.getTitle();
		String expectedrolesPageTitle="Roles - Reobeen LLC";
		Assert.assertEquals(actualrolesPageTitle, expectedrolesPageTitle,"Title Mismatch");
	}
	@Test(priority=3)
public void VerifyaddRoles()
{
		login=new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("123456");
		home=login.clickLoginButton();
		home.handleEndTour();
	mgmt=home.clickOnUserManagementPage();
	role=mgmt.ClickOnRolesPage();	
	role.clickAddRoles();
	role.enterRolesName("Jasel");
	role.clickPermissionUser("Add user");
	role.clickPermissionUser("Edit user");
	role.clickPermissionRoles("Add Role");
	role.clickPermissionSupplier("View supplier");
	role.clickPermissionCustomer("customer");
	role.clickPermissionProduct("Add product");
	role.clickPermissionPurchaseStock(" Edit purchase & Stock Adjustment ");
	role.clickPermissionSell(" Add POS sell ");
	role.clickPermissionBrand("View brand");
	role.clickPermissionTaxRate("View tax rate ");
	role.clickPermissionUnit("View unit");
	role.clickPermissionCategory(" Add category ");
	role.clickPermissionReport("View Tax report");
	role.clickPermissionSetting("Access business settings");
	role.clickPermissionHome("View Home data");
	role.clickPermissionAccount(" All Locations ");
	role.clickPermissionAccountLocation("Demo Company ");
	role.clickPermissionAccessSellingPrice("Default Selling Price ");
	role.clickSave();
}
	@Test(priority=4)
	public void verifyTableElement()
	{
		login=new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("123456");
		home=login.clickLoginButton();
		home.handleEndTour();
		mgmt=home.clickOnUserManagementPage();
		role=mgmt.ClickOnRolesPage();
		String actualResult=role.tablecheck("Cashier");
		String expectedResult="Cashier";
		Assert.assertEquals(actualResult, expectedResult,"Mismatch!!");
		
	}
	@Test(priority=5)
	public void verifySearch()
	{
		login=new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("123456");
		home=login.clickLoginButton();
		home.handleEndTour();
		mgmt=home.clickOnUserManagementPage();
		role=mgmt.ClickOnRolesPage();
		role.searchelement("ddd");
		String actualResult=role.searchelementPresent();
		String expectedResult="ddd";
		Assert.assertEquals(actualResult,expectedResult,"NoElement Present");
	}

}
