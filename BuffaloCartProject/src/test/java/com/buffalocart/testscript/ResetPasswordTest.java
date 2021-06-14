package com.buffalocart.testscript;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.buffalocart.automationcore.Base;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.ResetPasswordPage;

public class ResetPasswordTest extends Base {
	LoginPage login;
	ResetPasswordPage reset;
	@Test(priority=3)
	public void verifyErrorMessage()
	{
		login=new LoginPage(driver);
		reset=login.clickResetPassword();
		reset.enterEmailForRecovery("juju@gmail.com");
		reset.clickSubmitEmail();
		String actualresult=reset.getTextOfErrorMessage();
		String expectedresult="We can't find a user with that e-mail address.";
		Assert.assertEquals(actualresult, expectedresult,"Wrong");
	}
	@Test(priority=2)
	public void verifyResetPageTitle()
	{
		
		login=new LoginPage(driver);
		reset=login.clickResetPassword();
		String actualResetPWTilte=driver.getTitle();
		String expectedResetPWTitle="Reset Password - Demo POS";
		Assert.assertEquals(actualResetPWTilte, expectedResetPWTitle, "Wrong!!Title Mismatch");
	}
	@Test(priority=1)
	public void verifyResetPageLoaded()
	{
		login=new LoginPage(driver);
		reset=login.clickResetPassword();
		boolean result=reset.isresetPage();
		Assert.assertTrue(result, "Reset Password Page not Loaded");
	}

}
