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
      Then I choose the travelling date "Fri Nov 17 2023" from calender
      Then I search button
      Then I click on the overlay Cross Icon
      Then I verify search results are displayed
      Then I click on the overlay Cross Icon
      Then I click on view prices button for first item on the list
      Then I click on view booking button
      Then I verify journey section
