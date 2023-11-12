Feature: Login tests
  As Customer B2B2B, I can login to Bhinneka.com

  Background: Home page of bhinneka.com
    Given Login form in login page

  @DataTableHeaders
  Scenario: Login to Bhinneka.com using valid account that registered in personal and corporate account type
    Given Login page is displayed
    When Input credentials to login with headers table
    | Email             | Password     | Account Type           |
    | your@email.com    | Yourp@ssw0rd | personal and corporate |
    And Click selanjutnya button

  @SimplyDataTable
  Scenario: Login to Bhinneka.com using valid account that registered in personal account type
    Given Login page is displayed
    When Input credentials to login without headers
      | your@email.com | Yourp@ssw0rd | personal |
    And Click selanjutnya button

  @DataTableHeaders
  Scenario Outline: Login to Bhinneka.com using valid account that registered in personal and corporate account type
    Given Login page is displayed
    When I enter Username as "<username>" and Password as "<password>"
    And Click selanjutnya button
    Examples:
      | username | password |
      | your1@email.com | Your1p@ssw0rd|
      | your2@email.com | Your2p@ssw0rd|
      | your3@email.com | Your3p@ssw0rd|

