Feature: Login 

Scenario: Successfully login with valid credentials 
	Given User Launch Chrome browser 
	When User opens url "http://admin-demo.nopcommerce.com/login" 
	And User enters Email as "admin@yourstore.com" and Passwords as "admin" 
	And Click on Login 
	Then Page Title should be "Dashboard / nopCommerce administration" 
	When User click on Log out link 
	Then Page title should be "Your store. Login" 
	And close browser 
	
Scenario Outline: Login data Driven 
	Given User Launch Chrome browser 
	When User opens url "http://admin-demo.nopcommerce.com/login" 
	And User enters Email as "<email>" and Passwords as "<password>" 
	And Click on Login 
	Then Page Title should be "Dashboard / nopCommerce administration" 
	When User click on Log out link 
	Then Page title should be "Your store. Login" 
	And close browser 
	
	Examples:
	|email|password|
	|admin@yourstore.com|admin|
	|admin1@yourstore.com|admin123|