Feature: Login page feature

@smoke
Scenario: Validate Login Page
Given User is on login Page
Then User name field is displayed
And Password field is displayed 
And Keep me login check box is displayed
And Login button is displayed
And Login logos are displayed

@Regression @smoke

Scenario: Verify Login functionality
Given User is on login Page
Then User enters username
And user enters password 
And user clicks on Login button
Then Dashboard Ttile is "actiTime - Enter Time-Track123"
