Feature: flight booking scenarios
  As a customer , i want to complete the booking
  Background: Home page of makemytrip

    @TestCase1
    Scenario: Guest User ,verify the search results
      Given makemytrip home page
      Then  I closed login popup page
      Then  I entered the from "Pune" city
      Then I choose the from "Pune, India" city from drop down
      Then I entered the to "Delhi" city
      Then I choose the to "New Delhi, India" city from drop down

