package com.buffalocart.testscript;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.buffalocart.automationcore.Base;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.UserManagementPage;


public class UserManagementTest extends Base {
	LoginPage login;
	HomePage home;
	UserManagementPage mgmtpage;
	
	
	
	@Test(enabled=true)
	public void verifyChildSidePannelMenu()
	{
		login=new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("123456");
		home=login.clickLoginButton();
		home.handleEndTour();
		mgmtpage=home.clickOnUserManagementPage();
		List<String> actualList=mgmtpage.userManagementList();
		System.out.println(actualList);
		List<String> expectedList=new ArrayList<String>();
		expectedList.add("Users");
		expectedList.add("Roles");
		expectedList.add("Sales Commission Agents");
		Assert.assertEquals(actualList, expectedList,"Mismatch");
		
	}

}
