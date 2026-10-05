Feature: login

  Background:
    Given the user is on the login page

  Scenario: Successful login
    When the user logs in "standard" with valid password
    Then the inventory page is displayed

  Scenario Outline: Unsuccessful login
    When the user logs in with username "<username>" and password "<password>"
    Then the error message "<error>" is displayed
    And the user is on the login page

    Examples:
      | username  | password | error             |
      | locked    | password | locked user       |
      | not.match | password | wrong credentials |
      |           | password | empty username    |
      | standard  |          | empty password    |