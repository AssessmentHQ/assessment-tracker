Feature: Navigate through webpages

  Scenario:
    Given The user is on home.html page
    When The user clicks the login button
    And They input their login credentials to the modal
    And The user clicks on a batch they wish to view
    Then The user will be on batch_home.html page
    When The user adds an assessment to a batch week
    And The user clicks on the created assessment
    Then The user can be able to adjust the weight of the assessment
