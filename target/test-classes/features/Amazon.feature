Feature: Add an item to cart

Scenario: Add an item to cart from automative department

Given user is in the department page
When user select "Health" checkbox, clicks on item
And click on add2cart
Then successfully an item should be added to cart

Scenario: Add an item to cart from furniture department

Given user is in the department page
When user select "furniture" checkbox, clicks on item
And click on add2cart
Then successfully an item should be added to cart

Scenario: Add an item to cart from menswatches department

Given user is in the department page
When user select "menswatches" checkbox, clicks on item
And click on add2cart
Then successfully an item should be added to cart
