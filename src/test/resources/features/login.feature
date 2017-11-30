Feature: Login

	Scenario Outline: Login to the application
		Given User is present on login page
		When User enters username as <username> and password as <password>
		And User clicks on log in button
#		Then User should be logged in

Examples:
|username|password|
|"user1@gmail.com"|"pass1"|
|"user2@gmail.com"|"pass2"|
|"user3@gmail.com"|"pass3"|