Feature: Flex booking scenarios
  As a customer , i want to complete the booking
  Background: Home page of scandic hotels

    @Regression
    Scenario: Guest User got to complete booking page
      Given Scandic home page
      Then Accept all cooking of the website
      When I enter hotel "Scandic Klara" name
      When I choose the arrival date "2023-11-15" and  departure  date "2023-11-16" from calendar
      And  I click on See rooms and prices button
      And I click on rate code "FLEX" button for room type "Superior" from the list room types
      Then I validate the enter details page


