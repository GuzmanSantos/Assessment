Feature: Assessment

Scenario: Add the last item from the search results to the Cart and empty the Cart
  Given User navigates to the WebstaurantStore homepage
  When User searches for "stainless work table"
  Then User should see search results with the word "Table" in the title for every product
  And User adds the last item from the search results to the cart
  And User empties the cart
