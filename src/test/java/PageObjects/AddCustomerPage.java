package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {

	public WebDriver ldriver;
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	By lnkCustomerMenu=By.partialLinkText("Customers");
	By lnkCustomerMenuItem=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a");
	
	By btnAddNew=By.xpath("//a[@class=\"btn btn-primary\"]");
	By txtEmail=By.id("Email");
	By txtPassword=By.id("Password");
	By txtFirstName=By.id("FirstName");
	By txtLastName=By.id("LastName");
	By rdMale=By.id("Gender_Male");
	By rdFemale=By.id("Gender_Female");
	By txtDateOfBirth=By.id("DateOfBirth");
	By txtCompanyname=By.id("Company");
	By chkIsTaxExempt=By.id("IsTaxExempt");
	By txtNewsletter=By.xpath("//*[@class=\"k-multiselect-wrap k-floatwrap\"]");
	
	By txtCustomerRole=By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]//li");
	
	By lstitemAdministrators=By.xpath("//li[contains(text(), 'Administrators')]");
	By lstitemRegister=By.xpath("//li[contains(text(), 'Register')]");
	By lstitemGuests=By.xpath("//li[contains(text(), 'Guests')]");
	By lstitemVendor=By.xpath("//li[contains(text(), 'Vendor')]");
	By lstitemForumModerators=By.xpath("//li[contains(text(), 'Forum.Moderators')]");
	By lstitemcapg=By.xpath("//li[contains(text(), 'capg')]");
	
	By txtManagerOfVendor=By.id("VendorId");
	By txtAdminComments=By.id("AdminComment");
	
	By btnSave=By.xpath("//button[@name=\"save\"]");
	
	//Actions Methods
	public String getPageTitle()
	{
		return ldriver.getTitle();
		
	}
	
	public void clickOnCustomerMenu()
	{
		ldriver.findElement(lnkCustomerMenu).click();
	}
	
	public void clickOnCustomerMenuItem()
	{
		ldriver.findElement(lnkCustomerMenuItem).click();
	}
	
	public void clickOnAddNew()
	{
		ldriver.findElement(btnAddNew).click();
	}
	
	public void setEmail(String email)
	{
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		ldriver.findElement(txtPassword).sendKeys(password);
	}
	
	public void setFirstName(String firstName)
	{
		ldriver.findElement(txtFirstName).sendKeys(firstName);
	}
	
	public void setLastName(String lastname)
	{
		ldriver.findElement(txtLastName).sendKeys(lastname);
	}
	

	public void setGender(String gender)
	{
		if (gender.equals("Male")) 
		{
			ldriver.findElement(rdMale).click();
		}else if (gender.equals("Female")) 
		{
			ldriver.findElement(rdFemale).click();
		}else 
		{
			ldriver.findElement(rdMale).click(); //default
		}
	}
	
	public void setDateOfBirth(String dob)
	{
		ldriver.findElement(txtDateOfBirth).sendKeys(dob);
	}
	
	public void setCompanyName(String comname)
	{
		ldriver.findElement(txtCompanyname).sendKeys(comname);
	}
	/*
	public void clickISTaxExempt()
	{
		ldriver.findElement(chkIsTaxExempt).click();
	}
	*/
	
	public void setCustomerRole(String role) throws InterruptedException
	{
		if (!role.equals("Vendors")) //If role is vendors should not delete Register as per
		{
			ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[1]")).click();
		}
		
		ldriver.findElement(txtCustomerRole).click();
		
		WebElement listitem = null ;
		Thread.sleep(3000);
		
		if (role.equals("Administrators")) 
		{
			listitem=ldriver.findElement(lstitemAdministrators);
		}else if (role.equals("Guests")) 
		{
			listitem=ldriver.findElement(lstitemGuests);
		}else if (role.equals("Registered")) 
		{
			listitem=ldriver.findElement(lstitemRegister);
		}else if (role.equals("Forum Moderators")) 
		{
			listitem=ldriver.findElement(lstitemForumModerators);
		}else if (role.equals("capg")) 
		{
			listitem=ldriver.findElement(lstitemcapg);
		}else if (role.equals("Vendors")) 
		{
			listitem=ldriver.findElement(lstitemVendor);
		}else {
			ldriver.findElement(lstitemGuests);
		}
		
		JavascriptExecutor js=(JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].click();", listitem);
		
		Select drp=new Select(listitem);
		listitem.click();
		
		
		
	}
	
	public void setManagerOfVendor(String value)
	{
		Select drp=new Select(ldriver.findElement(txtManagerOfVendor));
		drp.selectByVisibleText(value);
	}
	
	public void setAdminComments(String comment)
	{
		ldriver.findElement(txtAdminComments).sendKeys(comment);
	}
	
	public void clickOnSave()
	{
		ldriver.findElement(btnSave).click();
	}

}