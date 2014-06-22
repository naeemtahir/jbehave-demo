Shopping Cart Story

Scenario: Remove items from shopping cart
Given a non-empty shopping cart 
When user removes an item from the cart
Then cart has one fewer items
And removed item is no longer in the cart