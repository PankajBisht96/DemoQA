@ElementsTab
Feature: Verify Elements Tab

  Background: User is on Elements home page
    Given DemoQA application is launched
    And User clicks on Elements tab
    And User is on Elements page

@TextBox
  Scenario: Validate Text-Box tab
    When User clicks on Text-Box button
    And enters the required details "TB01"
    And clicks on submit button
    Then entered data is displayed correctly "TB01"

@CheckBox    
    Scenario: Validate Check Box tab
    When User clicks on Check Box tab
    And selects Home checkbox
    Then all checkboxes are selected
    
@RadioButton
		Scenario Outline: Validate RadioButton tab
		When User clicks on RadioButton tab
		And selects a "<RadioButton>"
		Then success message is displayed as per selected "<RadioButton>"

		Examples:
		|RadioButton|
#		|Yes|
		|No|
#		|Impressive|

@WebTablesAddData
Scenario: Validate WebTables tab Add functionality
When User clicks on WebTables tab
And clicks on Add button
And enters details for a new record "WT01"
And clicks on submit button
Then record is added successfully "WT01"

#@WebTablesEditData
#Scenario: Validate WebTables Edit functionality
#When User clicks on WebTables tab
#And clicks on edit button for record name as 'Alden'
#And updates the last name to 'Thor'
#And clicks on submit button
#Then last name in the webtable is updated to 'Thor' for record name as 'Alden'
