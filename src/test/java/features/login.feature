Feature: Login into Application

  Scenario Outline: Positive test validating login
    Given Initialize the browser with chrome
    And Navigate to the "http://qaclickacademy.com" website
    And Validate title and navigation bar
    And Click on Login link in the homepage to land on sign in page
    When User enters "<username>" and "<password>" and logs in
    And Close browsers

    Examples:
    |username         |password   |
    |test99@gmail.com |123456     |
    |test123@gmail.com|12345      |