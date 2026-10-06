Feature: cart

  Background:
    Given the user is on the login page
    When the user logs in "standard" with valid password
    Then the inventory page is displayed

    Scenario: Add item Backpack to the cart
      When user adds "Sauce Labs Backpack" to the cart
      Then the cart badge shows "1"
      When user opens the cart
      Then the cart page is displayed
      And user verifies "Sauce Labs Backpack" is in the cart
      And the cart page header shows "1" item



