Feature: verify add to cart
  Scenario: check the functionality of cart button
    Given user opens the application
    Then verify user open login page
    When user login with "username" and "password"
    Then verify user on home page
    When click on add to cart
    Then verify remove button is displayed




