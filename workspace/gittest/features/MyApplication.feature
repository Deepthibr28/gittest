Feature: Login
Description: This feature is to test the login functionality

Scenario: Successful Login with Valid Credentials
Given User is on Home Page
When User enters Username and Password
And Clicks Go button
Then He can visit the practice page
And A message is displayed