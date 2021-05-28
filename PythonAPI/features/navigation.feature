Feature: Navigate through webpages

  Scenario:
    Given The user is on home.html page
    When The user clicks the login button
    And They input their login credentials to the modal
    Then The user will be on batch_home.html page
    When The user filters the batches by year
    And Clicks on the batch they wish to see in that year
    Then The user will be on the specific_batch.html page
    When The user clicks on the week of the batch they wish to view
    Then The user will be on the specific_batch_week.html page