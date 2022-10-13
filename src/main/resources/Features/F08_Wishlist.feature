@smoke
  Feature: adding product to wishlist and open it
    Scenario: adding product to wishlist and verify success message
      When user press on add product to wishlist
      Then success message is displayed with green color

    Scenario: adding product to wishlist and open wishlist
      When user press on add product to wishlist
      And success message is displayed with green color
      And user press on wishlist tab
      Then user could view product in wishlist with quantity