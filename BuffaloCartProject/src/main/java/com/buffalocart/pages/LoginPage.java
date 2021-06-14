package com.buffalocart.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;

public class LoginPage extends PageUtility {

		WebDriver driver;
		public LoginPage(WebDriver driver) //constructor (driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//div[@class='panel-heading']")
		WebElement loginpage;
		@FindBy(id="username")
		WebElement username;
		@FindBy(id="password")
		WebElement password;
		@FindBy(xpath="//button[@type='submit']")
		WebElement login;
		@FindBy(xpath="//span[@class='help-block']//strong")
		WebElement errorTextLogin;
		@FindBy(xpath="//a[@class='btn btn-link']")
		WebElement forgetPW;
		@FindBy(xpath="//label[@for='username']")
		WebElement usernameLabel;
		@FindBy(xpath="//label[@for='password']")
		WebElement passwordLabel;
		@FindBy(xpath="//input[@name='remember']")
		WebElement rememberCheckbox;
		@FindBy(linkText="Login")
		WebElement loginLink;
		
		public String getLoginPageTitle()
		{
			
			return driver.getTitle();
		}
		public void enterUsername(String uname) {
			enterText(username,uname);
			
		}
		public void enterPassword(String pw)
		{
			enterText(password,pw);
			
		}
		public HomePage clickLoginButton()
		{
			//sleep(3000);
			waitForElement(driver,"xpath","//button[@type='submit']");
			clickOnElement(login);
			
			return new HomePage(driver);
		}
		public ResetPasswordPage clickResetPassword()
		{
			clickOnElement(forgetPW);	
			return new ResetPasswordPage(driver);
		}
		public String verifyUsernameLabel()
		{
			return getElementText(usernameLabel);
		}
		public String verifyPasswordLabel()
		{
			
			return getElementText(passwordLabel);
		}
		public String verifyLoginButton()
		{
			return getElementText(login);
		}
		public String verifyForgetPasswordLink()
		{
			return getElementText(forgetPW);
		}
		public void clickCheckbox()
		{
			clickOnElement(rememberCheckbox);
		}
		public boolean checkclickCheckbox()
		{
			return getElementDisplayStatus(rememberCheckbox);
		}
		public boolean isLoginPage()
		{
			//sleep(3000);
			waitForElement(driver,"xpath","//div[@class='panel-heading']");
		return  getElementDisplayStatus(loginpage); 	
		}

}
