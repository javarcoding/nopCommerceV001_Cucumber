Feature: Customers 

Background: Below are the common steps for each scenario 
	Given User Launch Chrome browser 
	When User opens url "http://admin-demo.nopcommerce.com/login" 
	And User enters Email as "admin@yourstore.com" and Passwords as "admin" 
	And Click on Login 
	Then user can view Dashboard 
	
Scenario: Add a new customer 
	When user click on customers menu 
	And Click on customers menu Item 
	And Click on Add new button 
	Then user can view Add new customer page 
	When user enters the info 
	And Click on Save button 
	Then user can view confirmation message "The new customer has been added successfully." 
	And close browser 
	
Scenario: Search customer by using EmailID 
	When user click on customers menu 
	And Click on customers menu Item 
	And Enter customer Email 
	When click on search button 
	Then User should found Email in the Search table 
	And close browser 
	
	
	
Scenario: Search customer by using Name 
	When user click on customers menu 
	And Click on customers menu Item 
	And Enter customer firstName 
	And Enter customer lastName 
	When click on search button 
	Then User should found Name in the Search table 
	And close browser 
	