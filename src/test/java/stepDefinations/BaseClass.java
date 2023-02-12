package stepDefinations;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import PageObjects.AddCustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchCustomerPage;

public class BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage addCust;
	public SearchCustomerPage SearchCust;
	
	//Created for generating random String for unique email
	public static String randomestring()
	{
		String generateString1 =RandomStringUtils.randomAlphabetic(5);
		return generateString1;
	}
	
	
}
