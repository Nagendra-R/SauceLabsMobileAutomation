Feature: validate order functionality
  Scenario: order something
    Given user opens the application
    When user login with "username" and "password"
    Then verify user on home page
    When click on first item
    And scroll till the add to cart is visible
    And click on add to cart button
    And click on cart button
    Then verify item is present in checkout page
    When click on checkoutButton
    Then  verify user on shipping details page
    When fill the firstname "fname" lastname "lname" and postalcode "111"
    And click on continue button
    Then verify user on verification page
    When user click on finish button
    Then  verify user successful message "THANK YOU FOR YOU ORDER"




