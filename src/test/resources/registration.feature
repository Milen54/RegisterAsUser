Feature: Customer Registration process
  As a customer,
  I want to register an account
  so that I can easily order

  @regression
  Scenario Outline: Successful registration
    Given I am on the home page
    When I click on 'My Account' and then 'Register'
    And I fill in the registration form with valid data
    And I accept the privacy policy
    And I submit the form
    Then I should see the success page with the message <expectedMessage>
    Examples:
      | expectedMessage                  |
      | "Your Account Has Been Created!" |
