Feature: Search and place order for vegetables

@Seleniumtest1
Scenario: Search for items and validate results

Given User is on GreenKart landing page
When User searched for Beetroot vegetable
Then "Beetroot" results are displayed

@Seleniumtest2
Scenario Outline: Search for items and validate results

Given User is on GreenKart landing page
When User searched for <Name> vegetable
And Add items to cart
And user proceeded to checkout page for payment
Then verify selected <Name> items are displayed in check out page


Examples:

|Name|
|Pumpkin|
|Apple	|
