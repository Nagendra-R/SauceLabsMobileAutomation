Feature:sort the price
  Scenario: filter by price and high to low
    Given user opens the application
    When user login with "username" and "password"
    Then verify user on home page
    When filter the price by "Price (high to low)"
    Then verify the price is sorted in desc order

