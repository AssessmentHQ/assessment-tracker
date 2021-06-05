Feature: Navigate through webpages

  Scenario:
    Given The user is on home.html page
    When The user clicks the login button
    And They input their login credentials to the modal
    And The user clicks on a batch they wish to view
    Then The user will be on batch_home.html page
    When The user adds an assessment to a batch week
