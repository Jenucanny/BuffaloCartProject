package com.buffalocart.testscript;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.buffalocart.automationcore.Base;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.utilities.ExcelUtility;

public class LoginTest extends Base {
	static LoginPage login;
	HomePage home;
	@DataProvider(name="credentials")
	public Object[][] credentials() throws IOException
	{ 
		//login=new LoginPage(driver);
		ExcelUtility excel=new ExcelUtility();
		String s=excel.readData(0,0);
		String o=excel.readData(0, 1);
		Object[][] data=new Object[2][2];
		data[0][0]=s;
		data[0][1]=o;
		data[1][0]=s;
		data[1][1]=o;
		System.out.println(data);
		return data;
		
		
	}
	@Test(dataProvider="credentials")
	public void verifyValidLogin(String a,String b)
	{
		login=new LoginPage(driver);
		login.enterUsername(a);
		login.enterPassword(b);
		home=login.clickLoginButton();
		boolean result=home.isHomePageLoaded();
		Assert.assertTrue(result, "User Account Page not Loaded");
		
		
	}
	@Test(priority=1,enabled=true)
	public void verifyLoginPageLoaded()
	{
		login=new LoginPage(driver);
		boolean result=login.isLoginPage();
		Assert.assertTrue(result, "Login Page is not Loaded");
	}
	@Test(priority=2,enabled=true)
	public void verifyLoginPageTitle() {
		
		login=new LoginPage(driver);
		String actualloginTilte=driver.getTitle();
		String expectedloginTitle="Login - Demo POS";
		Assert.assertEquals(actualloginTilte, expectedloginTitle, "Wrong!!Title Mismatch");
	}
	@Test(priority=3,enabled=true)
	public void verifyLoginWithValidCredentials()
	{
		login=new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("123456");
		home=login.clickLoginButton();
		boolean result=home.isHomePageLoaded();
		Assert.assertTrue(result, "User Account Page not Loaded");
		
	}
	@Test(priority=4,enabled=true)
	public void verifyLoginWthInvalidCredentials()
	{
		login=new LoginPage(driver);
		login.enterUsername("admin1");
		login.enterPassword("1234567");
		login.clickLoginButton();
		String actualPage=login.getLoginPageTitle();
		String expectedPage="Login - Demo POS";
		Assert.assertEquals(actualPage, expectedPage,"Wrong!!! Login with invalid Credentials!!");
		}
	@Test(priority=5,enabled=true)
	public void verifyUILoginPageUsername()
	{
		login=new LoginPage(driver);
		String actualUserLabel=login.verifyUsernameLabel();
		String expectedUserLabel="Username";
		Assert.assertEquals(actualUserLabel, expectedUserLabel,"Mismatch!!");
		}
	@Test(priority=6,enabled=true)
	public void verifyUILoginPagePassword()
	{
		login=new LoginPage(driver);
		String actualPasswordLabel=login.verifyPasswordLabel();
		String expectedPasswordLabel="Password";
		Assert.assertEquals(actualPasswordLabel, expectedPasswordLabel,"Mismatch!!");
		}
	@Test(priority=7,enabled=true)
	public void verifyUILoginPageLoginButton()
	{
		login=new LoginPage(driver);
		String actualLoginButton=login.verifyLoginButton();
		String expectedLoginButton="Login";
		Assert.assertEquals(actualLoginButton, expectedLoginButton,"Mismatch!!");
		}
	@Test(priority=8,enabled=true)
	public void verifyUILoginPagePasswordLink()
	{
		login=new LoginPage(driver);
		String actualPasswordLinkText=login.verifyForgetPasswordLink();
		String expectedPasswordLinkText="Forgot Your Password?";
		Assert.assertEquals(actualPasswordLinkText, expectedPasswordLinkText,"Mismatch!!");
		}
	@Test(priority=9,enabled=true)
	public void veifyCheckboxNotClicked()
	{
		login=new LoginPage(driver);
		boolean result=login.checkclickCheckbox();
		Assert.assertTrue(result, "CheckBox Clicked!!");
	}
	

}
