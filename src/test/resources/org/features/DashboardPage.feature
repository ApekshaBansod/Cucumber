Feature: Dashboard page feature

@smoke
Scenario: Validate Login Fuctionality
Given User is on login Page
Then User name field is displayed
And Password field is displayed 

And Login button is displayed
And Login logos are displayed
And Dashboard URL is "http://localhost/user/submit_tt.do"
And Dashboard Ttile is "actiTIME - Enter Time-Track"
And Dashboard Displays 4 tabs

