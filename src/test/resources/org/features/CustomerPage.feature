Feature: customer page feature

@smoke
Scenario: Validate add Customer Page
Given User is on login page
When User enters username
And User enters password
And User clicks on Login button 
And Dashboard displays 4 tabs
When User clicks on "Tasks" tab
Then Task page is Displayed 
When user clicks on new Add new Customer
Then Add Customer page is displayed 
And Verify Add Customer page 

@Regression
Scenario: verify add new customer functionality
Given User is on login page
When User enters username
And User enters password
And User clicks on Login button 
And Dashboard displays 4 tabs
When User clicks on "Tasks" tab
Then Task page is Displayed 
When user clicks on new Add new Customer
Then Add Customer page is displayed
When user enters new customer details
And clicks on create customer button
Then Verify notification for newly created Customer 
And Created customer is displayed in customer & Project section
