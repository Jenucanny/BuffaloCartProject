package com.buffalocart.testscript;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.buffalocart.automationcore.Base;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;

public class HomeTest extends Base{
	LoginPage login;
	HomePage home;
	@Test(enabled=true,priority=1)
	public void verifyHomePageTitle()
	{
		login=new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("123456");
		home=login.clickLoginButton();
		home.handleEndTour();
		String actualHomePageTitle=driver.getTitle();
		String expectedHomePageTilte="Home - Reobeen LLC";
		Assert.assertEquals(actualHomePageTitle, expectedHomePageTilte,"Title Mismatch!!");
		
	}
	@Test(enabled=true,priority=2)
	public void verifyHomePageLoaded()
	{
		login=new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("123456");
		home=login.clickLoginButton();
		boolean result=home.isHomePageLoaded();
		Assert.assertTrue(result, "Home Account Page not Loaded");
	}
	@Test(enabled=true,priority=3)
	public void verifyDate()
	{
		login=new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("123456");
		home=login.clickLoginButton();
		home.handleEndTour();
		String actualresult=home.checkDate();
		String expectedresult="06/12/2021";
		Assert.assertEquals(actualresult, expectedresult,"Date differs!!!");
	}

	
}
