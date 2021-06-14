package com.buffalocart.pages;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;

public class RolesPage extends PageUtility {
	WebDriver driver;

	public RolesPage(WebDriver driver) // constructor (driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//section[@class='content-header']")
    WebElement rolespage;
	@FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
	WebElement addroles;
	@FindBy(id = "name")
	WebElement rolename;
	@FindBys(@FindBy(xpath = "//form[@id='role_add_form']//div[3][@class='row check_group']//div[@class='icheckbox_square-blue']//ins"))
	List<WebElement> permissionUser;
	@FindBys(@FindBy(xpath = "//form[@id='role_add_form']//div[4][@class='row check_group']//div[@class='icheckbox_square-blue']//ins"))
	List<WebElement> permissionRoles;
	@FindBys(@FindBy(xpath = "//form[@id='role_add_form']//div[5][@class='row check_group']//div[@class='icheckbox_square-blue']//ins"))
	List<WebElement> permissionSupplier;
	@FindBys(@FindBy(xpath = "//form[@id='role_add_form']//div[6][@class='row check_group']//div[@class='icheckbox_square-blue']//ins"))
	List<WebElement> permissionCustomer;
	@FindBys(@FindBy(xpath = "//form[@id='role_add_form']//div[7][@class='row check_group']//div[@class='icheckbox_square-blue']//ins"))
	List<WebElement> permissionProduct;
	@FindBys(@FindBy(xpath = "//form[@id='role_add_form']//div[8][@class='row check_group']//div[@class='icheckbox_square-blue']//ins"))
	List<WebElement> permissionPurchaseStock;
	@FindBys(@FindBy(xpath = "//form[@id='role_add_form']//div[9][@class='row check_group']//div[@class='icheckbox_square-blue']//ins"))
	List<WebElement> permissionSell;
	@FindBys(@FindBy(xpath = "//form[@id='role_add_form']//div[10][@class='row check_group']//div[@class='icheckbox_square-blue']//ins"))
	List<WebElement> permissionBrand;
	@FindBys(@FindBy(xpath = "//form[@id='role_add_form']//div[11][@class='row check_group']//div[@class='icheckbox_square-blue']//ins"))
	List<WebElement> permissionTaxRate;
	@FindBys(@FindBy(xpath = "//form[@id='role_add_form']//div[12][@class='row check_group']//div[@class='icheckbox_square-blue']//ins"))
	List<WebElement> Unit;
	@FindBys(@FindBy(xpath = "//form[@id='role_add_form']//div[13][@class='row check_group']//div[@class='icheckbox_square-blue']//ins"))
	List<WebElement> permissionCategory;
	@FindBys(@FindBy(xpath = "//form[@id='role_add_form']//div[14][@class='row check_group']//div[@class='icheckbox_square-blue']//ins"))
	List<WebElement> permissionReport;
	@FindBys(@FindBy(xpath = "//form[@id='role_add_form']//div[15][@class='row check_group']//div[@class='icheckbox_square-blue']//ins"))
	List<WebElement> permissionSetting;
	@FindBys(@FindBy(xpath = "//form[@id='role_add_form']//div[16][@class='row check_group']//div[@class='icheckbox_square-blue']//ins"))
	List<WebElement> permissionHome;
	@FindBys(@FindBy(xpath = "//form[@id='role_add_form']//div[17][@class='row check_group']//div[@class='icheckbox_square-blue']//ins"))
	List<WebElement> permissionAccount;
	@FindBys(@FindBy(xpath = "//form[@id='role_add_form']//div[18][@class='row check_group']//div[@class='icheckbox_square-blue']//ins"))
	List<WebElement> permissionAccessLocation;
	@FindBys(@FindBy(xpath = "//form[@id='role_add_form']//div[19][@class='row check_group']//div[@class='icheckbox_square-blue']//ins"))
	List<WebElement> permissionAccessSellingPrice;
	@FindBy(xpath="//button[@class='btn btn-primary pull-right']")
	WebElement save;
@FindBys(@FindBy(xpath="//table[@id='roles_table']//tbody//tr//td"))
    List<WebElement> table;
@FindBys(@FindBy(xpath="//button[@class='btn btn-xs btn-danger delete_role_button']"))
    List<WebElement> tableEle;
@FindBy(xpath="//input[@class='form-control input-sm']")
    WebElement search;
@FindBy(xpath="//td[@class='sorting_1']")
    WebElement searchElement;
	public void clickAddRoles() {
		//sleep(2000);
		waitForElement(driver,"xpath","//a[@class='btn btn-block btn-primary']");
		clickOnElement(addroles);
		

	}

	public void enterRolesName(String rname) {
		//sleep(2000);
		waitForElement(driver,"id","name");
		enterText(rolename, rname);
		//sleep(2000);
	}

	public void clickPermissionUser(String option) {
		for (int i = 0; i < permissionUser.size(); i++) {
			if (permissionUser.get(i).getText().equalsIgnoreCase(option)) {
				permissionUser.get(i).click();
			}
		}
	}

	public void clickPermissionRoles(String option) {
		for (int i = 0; i < permissionRoles.size(); i++) {
			if (permissionRoles.get(i).getText().equalsIgnoreCase(option)) {
				permissionRoles.get(i).click();
			}
		}
	}
	
	public void clickPermissionSupplier(String option) {
		for (int i = 0; i < permissionSupplier.size(); i++) {
			if (permissionSupplier.get(i).getText().equalsIgnoreCase(option)) {
				permissionSupplier.get(i).click();
			}
		}
	}
	public void clickPermissionCustomer(String option) {
		for (int i = 0; i < permissionCustomer.size(); i++) {
			if (permissionCustomer.get(i).getText().equalsIgnoreCase(option)) {
				permissionCustomer.get(i).click();
			}
		}
	}
	public void clickPermissionProduct(String option) {
		for (int i = 0; i < permissionProduct.size(); i++) {
			if (permissionProduct.get(i).getText().equalsIgnoreCase(option)) {
				permissionProduct.get(i).click();
			}
		}
	}
	public void clickPermissionPurchaseStock(String option) {
		for (int i = 0; i < permissionPurchaseStock.size(); i++) {
			if (permissionPurchaseStock.get(i).getText().equalsIgnoreCase(option)) {
				permissionPurchaseStock.get(i).click();
			}
		}
	}
	public void clickPermissionSell(String option) {
		for (int i = 0; i < permissionSell.size(); i++) {
			if (permissionSell.get(i).getText().equalsIgnoreCase(option)) {
				permissionSell.get(i).click();
			}
		}
	}
	public void clickPermissionBrand(String option) {
		for (int i = 0; i < permissionBrand.size(); i++) {
			if (permissionBrand.get(i).getText().equalsIgnoreCase(option)) {
				permissionBrand.get(i).click();
			}
		}
	}
	public void clickPermissionTaxRate(String option) {
		for (int i = 0; i < permissionTaxRate.size(); i++) {
			if (permissionTaxRate.get(i).getText().equalsIgnoreCase(option)) {
				permissionTaxRate.get(i).click();
			}
		}
	}
	public void clickPermissionUnit(String option) {
		for (int i = 0; i < Unit.size(); i++) {
			if (Unit.get(i).getText().equalsIgnoreCase(option)) {
				Unit.get(i).click();
			}
		}
	}
	public void clickPermissionCategory(String option) {
		for (int i = 0; i < permissionCategory.size(); i++) {
			if (permissionCategory.get(i).getText().equalsIgnoreCase(option)) {
				permissionCategory.get(i).click();
			}
		}
	}
	public void clickPermissionReport(String option) {
		for (int i = 0; i < permissionReport.size(); i++) {
			if (permissionReport.get(i).getText().equalsIgnoreCase(option)) {
				permissionReport.get(i).click();
			}
		}
	}
	public void clickPermissionSetting(String option) {
		for (int i = 0; i < permissionSetting.size(); i++) {
			if (permissionSetting.get(i).getText().equalsIgnoreCase(option)) {
				permissionSetting.get(i).click();
			}
		}
	}
	public void clickPermissionHome(String option) {
		for (int i = 0; i < permissionHome.size(); i++) {
			if (permissionHome.get(i).getText().equalsIgnoreCase(option)) {
				permissionHome.get(i).click();
			}
		}
	}
	public void clickPermissionAccount(String option) {
		for (int i = 0; i < permissionAccount.size(); i++) {
			if (permissionAccount.get(i).getText().equalsIgnoreCase(option)) {
				permissionAccount.get(i).click();
			}
		}
	}
	public void clickPermissionAccountLocation(String option) {
		for (int i = 0; i < permissionAccessLocation.size(); i++) {
			if (permissionAccessLocation.get(i).getText().equalsIgnoreCase(option)) {
				permissionAccessLocation.get(i).click();
			}
		}
	}
	public void clickPermissionAccessSellingPrice(String option) {
		for (int i = 0; i < permissionAccessSellingPrice.size(); i++) {
			if (permissionAccessSellingPrice.get(i).getText().equalsIgnoreCase(option)) {
				permissionAccessSellingPrice.get(i).click();
			}
		}
	}
	public void clickSave()
	{
		//sleep(2000);
		waitForElement(driver,"xpath","//button[@class='btn btn-primary pull-right']");
		clickOnElement(save);
	}
	
	public String tablecheck(String value)
	{ 
		//sleep(2000);
		waitForElement(driver,"xpath","//table[@id='roles_table']//tbody//tr//td");
		String tablevalue="";
		for(int i=0;i<table.size();i++)
		{
			if(table.get(i).getText().equalsIgnoreCase(value))
			{
				tablevalue=table.get(i).getText();
			}
		}
		return tablevalue;
	}
	public void searchelement(String str)
	{
		waitForElement(driver,"xpath","//input[@class='form-control input-sm']");
		clickOnElement(search);
textSend(search,str);
sleep(2000);
	}
	public String searchelementPresent()
	{
		//sleep(2000);
		waitForElement(driver,"xpath","//td[@class='sorting_1']");
		return searchElement.getText();
	}
	
	public boolean isrolesPage()
	{
		//sleep(3000);
		waitForElement(driver,"xpath","//section[@class='content-header']");
	return  getElementDisplayStatus(rolespage); 	
	}

} 
