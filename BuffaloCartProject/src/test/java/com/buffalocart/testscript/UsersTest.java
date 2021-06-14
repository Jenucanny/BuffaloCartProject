package com.buffalocart.testscript;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.buffalocart.automationcore.Base;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.UserManagementPage;
import com.buffalocart.pages.UsersPage;

public class UsersTest extends Base {
	LoginPage login;
	HomePage home;
	UserManagementPage mgmtpage;
	UsersPage userpage;
	@Test(enabled=true,priority=1)
	public void verifyIsUsersPageLoaded()
	{
		login=new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("123456");
		home=login.clickLoginButton();
		home.handleEndTour();
		mgmtpage=home.clickOnUserManagementPage();
		userpage=mgmtpage.ClickOnUserPage();
		boolean result=userpage.isusersPage();
		Assert.assertTrue(result, "Users Page is not Loaded");
	}
	@Test(enabled=true,priority=2)
	public void verifyUserPageTitle()
	{
		login=new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("123456");
		home=login.clickLoginButton();
		home.handleEndTour();
		mgmtpage=home.clickOnUserManagementPage();
		userpage=mgmtpage.ClickOnUserPage();
		
		
		String actualuserPageTitle=driver.getTitle();
		String expecteduserPageTitle="Users - Reobeen LLC";
		Assert.assertEquals(actualuserPageTitle, expecteduserPageTitle,"Title Mismatch");
	}
	@Test(enabled=true,priority=3)
	public void VerifyAddList()
	{
		login=new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("123456");
		home=login.clickLoginButton();
		home.handleEndTour();
		mgmtpage=home.clickOnUserManagementPage();
		userpage=mgmtpage.ClickOnUserPage();
		userpage.clickToAddUser();
		userpage.enterSurname("Mr");
		userpage.enterFirstName("Tom");
		userpage.enterLastName("cat");
		userpage.enterEmail("tomcat@gmail.com");
		
		userpage.selectRole("staff");
		userpage.enterpassword("123456");
		userpage.enterconfirmPassword("123456");
		userpage.enterSalesCommission("10");
		userpage.clickAllowSelectedContactCheckbox();
		userpage.clickSelectContact();
		userpage.selectContactOptions("Anantara - (1234)");
		userpage.clickSave();	
	}
	@Test(enabled=true,priority=4)
	public void verifyTableRow()
	{
		login=new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("123456");
		home=login.clickLoginButton();
		home.handleEndTour();
		mgmtpage=home.clickOnUserManagementPage();
		userpage=mgmtpage.ClickOnUserPage();
		List<String> actualTableList=userpage.verifyTable();
		List<String> expectedTableList=new ArrayList<String>();
		expectedTableList.add("0044");
		expectedTableList.add("Mr Tom cat");
		expectedTableList.add("Admin");
		expectedTableList.add("tomcat@gmail.com");
		Assert.assertEquals(actualTableList, expectedTableList,"Mismatch List!!!");
		
	}
	@Test(enabled=true,priority=5)
	public void verifyUsersSearch()
	{
		login=new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("123456");
		home=login.clickLoginButton();
		home.handleEndTour();
		mgmtpage=home.clickOnUserManagementPage();
		userpage=mgmtpage.ClickOnUserPage();
		userpage.searchuserelement("Mr Tom cat");
		String actualresult=userpage.searchuserelementPresent();
		String expectedresult="Mr Tom cat";
		Assert.assertEquals(actualresult,expectedresult,"NoElement Present");
		
	}

}
