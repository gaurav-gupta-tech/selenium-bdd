#Author : Gaurav Gupta
Feature: Order T-Shirts And Update Personal Info

  @Scenario1
  Scenario Outline:Order T-Shirts and validate in order history
    Given I am on application homepage
    When I click on SignIn
    And I enter email address as "<email>"
    And I enter Password as "<password>"
    And I click on SignIn Button
    Then I successfully logged in to application
    When I search for "T-Shirts" in search items box
    And I click on search button
    Then I can see "T-Shirts" in search result
    When I add item to cart
    And I click on proceed to checkout from cart
    And I click on proceed to checkout from cart summary
    And I click on proceed to checkout from addresses page
    And I accept terms & conditions from shipping page
    And I click on proceed to checkout from shipping page
    And I select on Pay by bank wire option from payment page
    And I confirm My order
    Then Order should be added
    When I click on back to orders
    Then I can see recent oder is added to order history
    Examples:
      |email|password|
      | testuser@email.com|test@1234|

  @Scenario2
  Scenario Outline:Update Personal information First name in my account
    Given I have logged in with "<email>" and "<password>"
    When I click My personal info under my account
    Then I can see Personal Information page
    And I update first name from personal info page
    And I enter current password as "<password>"
    And I click on Save button
    Then I can see first name is updated
    Examples:
      |email|password|
      | testuser@email.com|test@1234|
