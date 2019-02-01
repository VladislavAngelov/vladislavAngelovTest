Feature: Shopping basket
  As a user
  I want to be able to add items to my shopping basket with quantity up to 100

  Background: Open login page
    Given I am on the login page

  Scenario Outline: Check items and images in products
    When I log in with '<user>' and password: secret_sauce in the website
    Then User is able to see 6 product items with their images
    Examples:
      |user                   |
      |standard_user          |
      |locked_out_user        |
      |problem_user           |
      |performance_glitch_user|


  Scenario Outline: Check that user is able to add each/any item with quantity 1
    When I log in with '<user>' and password: secret_sauce in the website
    And I click add to cart button for item <number>
    Then The item is added to the shopping cart with quantity 1
    And I can checkout successfully with correct total amount 1 for item
    Examples:
      |user                   |number|
      |standard_user          |1     |
      |standard_user          |2     |
      |standard_user          |3     |
      |standard_user          |4     |
      |standard_user          |5     |
      |standard_user          |6     |
      |locked_out_user        |1     |
      |locked_out_user        |2     |
      |locked_out_user        |3     |
      |locked_out_user        |4     |
      |locked_out_user        |5     |
      |locked_out_user        |6     |
      |problem_user           |1     |
      |problem_user           |2     |
      |problem_user           |3     |
      |problem_user           |4     |
      |problem_user           |5     |
      |problem_user           |6     |
      |performance_glitch_user|1     |
      |performance_glitch_user|2     |
      |performance_glitch_user|3     |
      |performance_glitch_user|4     |
      |performance_glitch_user|5     |
      |performance_glitch_user|6     |


  Scenario Outline: Check that user is able to add each/any item with quantity 100
    When I log in with '<user>' and password: secret_sauce in the website
    And I click add to cart button for item <number>
    Then In the shopping cart I can type quantity 100 for the item
    And I can checkout successfully with correct total amount 100 for item
    Examples:
      |user                   |number|
      |standard_user          |1     |
      |standard_user          |2     |
      |standard_user          |3     |
      |standard_user          |4     |
      |standard_user          |5     |
      |standard_user          |6     |
      |locked_out_user        |1     |
      |locked_out_user        |2     |
      |locked_out_user        |3     |
      |locked_out_user        |4     |
      |locked_out_user        |5     |
      |locked_out_user        |6     |
      |problem_user           |1     |
      |problem_user           |2     |
      |problem_user           |3     |
      |problem_user           |4     |
      |problem_user           |5     |
      |problem_user           |6     |
      |performance_glitch_user|1     |
      |performance_glitch_user|2     |
      |performance_glitch_user|3     |
      |performance_glitch_user|4     |
      |performance_glitch_user|5     |
      |performance_glitch_user|6     |

  Scenario Outline: Check that user is able to add all items with quantity 1
    When I log in with '<user>' and password: secret_sauce in the website
    Then I am able to add all items to shopping cart with quantity 1
    And I can checkout successfully with correct total amount 1 for item
    Examples:
      |user                   |
      |standard_user          |
      |locked_out_user        |
      |problem_user           |
      |performance_glitch_user|

  Scenario Outline: Check that user is able to add all items with quantity 100
    When I log in with '<user>' and password: secret_sauce in the website
    Then I am able to add all items to shopping cart with quantity 1
    And In the shopping cart I can type quantity 100 for each item
    And I can checkout successfully with correct total amount 1 for item
    Examples:
      |user                   |
      |standard_user          |
      |locked_out_user        |
      |problem_user           |
      |performance_glitch_user|


  Scenario Outline: Check that user is able to add all items with quantity 100
    When I log in with '<user>' and password: secret_sauce in the website
    Then I am able to add all items to shopping cart with quantity 1
    And In the shopping cart I can type quantity 100 for each item
    And I can checkout successfully with correct total amount 1 for item
    Examples:
      |user                   |
      |standard_user          |
      |locked_out_user        |
      |problem_user           |
      |performance_glitch_user|



  Scenario Outline: Verify shopping cart counter by adding and removing each item
    When I log in with '<user>' and password: secret_sauce in the website
    And I click add to cart button for item 1
    Then The cart counter is correct displaying 1
    And I remove the item from the cart and click continue shopping
    Then The cart counter is not displayed

    And I click add to cart button for item 2
    Then The cart counter is correct displaying 1
    And I remove the item from the cart and click continue shopping
    Then The cart counter is not displayed

    And I click add to cart button for item 3
    Then The cart counter is correct displaying 1
    And I remove the item from the cart and click continue shopping
    Then The cart counter is not displayed

    And I click add to cart button for item 4
    Then The cart counter is correct displaying 1
    And I remove the item from the cart and click continue shopping
    Then The cart counter is not displayed

    And I click add to cart button for item 5
    Then The cart counter is correct displaying 1
    And I remove the item from the cart and click continue shopping
    Then The cart counter is not displayed

    And I click add to cart button for item 6
    Then The cart counter is correct displaying 1
    And I remove the item from the cart and click continue shopping
    Then The cart counter is not displayed

    Examples:
      |user                   |
      |standard_user          |
      |locked_out_user        |
      |problem_user           |
      |performance_glitch_user|


  Scenario Outline: Verify shopping cart counter by adding and removing all item one by one
    When I log in with '<user>' and password: secret_sauce in the website
    Then I add one by one all items verifying shopping cart counter on each adding
    And I remove one by one all items from shopping cart verifying counter on each removing
    Then The cart counter is not displayed

    Examples:
      |user                   |
      |standard_user          |
      |locked_out_user        |
      |problem_user           |
      |performance_glitch_user|