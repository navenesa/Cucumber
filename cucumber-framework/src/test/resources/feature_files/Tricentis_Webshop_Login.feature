@Smoke
Feature: Login Feature
  
  Scenario: Successful Login
    Given The user is on the login page
    When The user enters the credentials
    |Username         |Password  |
    |samalt@gmail.com |Sam@1234  |
    And clicks on the login button
    Then the user should be logged in


