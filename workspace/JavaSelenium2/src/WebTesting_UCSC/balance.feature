Feature: Customer Check Balance
  As a valid customer,
  I should be able to check balance

Scenario: Check Balance
  Given the user has logged in with user id "mngr40773" and password "zybEqeq"
  And the user is on the Balance Query page
  When he submits "14694" as account no
  Then ensure the account no is "14694"
  And ensure the account type is "Savings"
  And ensure the balance is "500"