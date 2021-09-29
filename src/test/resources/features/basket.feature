Feature: Check Eldorado's basket

  Scenario: Add item to basket and delete it
    Given Open the Eldorado main page "https://www.eldorado.ru/"
    And Click on agree with city button
    And Enter search parameter "Iphone"
    And Press enter button
    When Remember first found items vendor code and name
    And Add first item to the basket
    And Click on basket button
    Then Check that the item was added to the basket

    Given Remove item from the basket
    Then Item successfully removed from the basket

