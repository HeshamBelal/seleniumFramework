Feature: Login
  Register new user, then login with the created user then recover it.

  Scenario Outline: Login to My Store
    Given The User press Sign in button
    When I entered valid email and password
    Then The registration page is displayed successfully
    Examples: