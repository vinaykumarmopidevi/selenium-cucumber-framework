Feature: Sauce login scenarios
  As a customer , i am able to login into application
  Background: Home page of Sauce

  @SauceTestCase
  Scenario: login user , verify the landing page
    Given Sauce home page
    Then  I entered the username "standard_user" in filed
    Then I entered the password "secret_sauce" in filed
    Then I click on login button
    Then I verified the logo and shopping card link in the page
