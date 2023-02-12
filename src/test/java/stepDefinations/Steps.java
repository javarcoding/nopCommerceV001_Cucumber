package stepDefinations;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.AddCustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchCustomerPage;
import io.cucumber.java.en.*;

public class Steps extends BaseClass {

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		lp = new LoginPage(driver);
	}

	@When("User opens url {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	@When("User enters Email as {string} and Passwords as {string}")
	public void user_enters_email_as_and_passwords_as(String email, String password) {
		lp.setUserName(email);
		lp.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() {
		lp.clickLogin();

	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {

		if (driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(title, driver.getTitle());
		}
		Thread.sleep(3000);
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		lp.clickLogout();
		Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
		driver.close();
	}

	// Customer feature step definitions
	// ..............................................

	@Then("user can view Dashboard")
	public void user_can_view_dashboard() {

		addCust = new AddCustomerPage(driver);
		String actTitle = "Dashboard / nopCommerce administration";
		// String expTitle=driver.getTitle();
		// Assert.assertEquals(actTitle, expTitle);

		Assert.assertEquals(actTitle, addCust.getPageTitle());

	}

	@When("user click on customers menu")
	public void user_click_on_customers_menu() throws InterruptedException {
		Thread.sleep(3000);
		addCust.clickOnCustomerMenu();
	}

	@When("Click on customers menu Item")
	public void click_on_customers_menu_item() throws InterruptedException {
		Thread.sleep(3000);
		addCust.clickOnCustomerMenuItem();
	}

	@When("Click on Add new button")
	public void click_on_add_new_button() {
		addCust.clickOnAddNew();
	}

	@Then("user can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		String actTitle = "Add a new customer / nopCommerce administration";

		Assert.assertEquals(actTitle, addCust.getPageTitle());
	}

	@When("user enters the info")
	public void user_enters_the_info() throws InterruptedException {
		String email = randomestring() + "@gmail.com";
		addCust.setEmail(email);

		addCust.setPassword("test123");
		addCust.setFirstName("Raj");
		addCust.setLastName("Kumar");
		addCust.setGender("Male");
		addCust.setDateOfBirth("7/05/1985");
		addCust.setCompanyName("busyQA");
		// addCust.clickISTaxExempt();

		// Registered - default
		// The customer cannot be in both 'Guests' and 'Registered' customer role
		// Add the customer to 'Guests' or 'Registered' customer role
		// addCust.setCustomerRole("Guests");
		Thread.sleep(2000);

		addCust.setManagerOfVendor("Vendor 2");

		// format: D/MM/YYYY

		addCust.setAdminComments("This is for testing ....");

	}

	@When("Click on Save button")
	public void click_on_save_button() throws InterruptedException {
		addCust.clickOnSave();
		Thread.sleep(3000);
	}

	@Then("user can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {

		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully."));
	}

	// Steps for customer searching a customer using emailid

	@When("Enter customer Email")
	public void enter_customer_email() {
		SearchCust = new SearchCustomerPage(driver);
		SearchCust.setEmail("victoria_victoria@nopcommerce.com");
	}

	@When("click on search button")
	public void click_on_search_button() throws InterruptedException {
		SearchCust.clickSearch();
		Thread.sleep(3000);
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {

		//boolean status = SearchCust.searchCustomerByEmail("victoria_victoria@nopcommerce.com");
	//	Assert.assertEquals(true, status);

	}
	
	
	//steps for searching a customer by using first Name and lastName
	
	@And("Enter customer firstName")
	public void enter_customer_firstName() {
		SearchCust = new SearchCustomerPage(driver);
		SearchCust.setFirstName("victoria");
	}
	
	@And("Enter customer lastName")
	public void enter_customer_LastName() {
		SearchCust.setLastName("Terces");
	}


	@Then("User should found Name in the Search table")
	public void user_should_found_Name_in_the_search_table() {

		//boolean status =SearchCust.searchCustomerByName("Victoria Terces");
		//Assert.assertEquals(true, status);
	}
}
