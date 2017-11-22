Feature: Login

# successful login
Scenario: Successful login to the applications
Given User is present on login page
When User enters username as "xyz@email.com"
And User enters password as "password"
And User clicks on log in button
#Then User should be logged in