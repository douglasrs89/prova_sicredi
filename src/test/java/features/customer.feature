Feature: Customers
  This feature deals with the customer functionality of application

  Background:
    Given User navigate to the grocery page
    And Select the Bootstrap V4 Theme version

  @sicredi
  Scenario: Validate new customer add
    When I click on Add Customer button
    And I fill the fields with the customer data
    And I click on Save button
    Then I should see the success message Your data has been successfully stored into the database. Edit Customer or Go back to list

  #normally I use an integration with the database, to clear data, but since I don't have access, I created this other scenario
  @sicredi
  Scenario: Prepare to next scenario
    And I enter Teste Sicredi on Search Name
    And I click on the checkbox to select all
    And I click on Action button Delete
    And I click on Delete button of popup

  @sicredi
  Scenario: Remove the customer Test Sicredi
    When I click on Add Customer button
    And I fill the fields with the customer data
    And I click on Save button
    And I click on the link Go back to list
    And I enter Teste Sicredi on Search Name
    And I click on the checkbox to select all
    And I click on Action button Delete
    Then I should see the confirm message Are you sure that you want to delete this 1 item?
    And I click on Delete button of popup
    And I should see the success alert message Your data has been successfully deleted from the database.