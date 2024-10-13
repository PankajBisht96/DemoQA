package demoQA.StepDefinitions;

import demoQA.Steps.ElementPageSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ElementsPageStepDefinitions {
	
	ElementPageSteps elementsPageSteps;
	
	@Given("User is on Elements page")
	public void user_is_on_elements_page() {
	    elementsPageSteps.verifyElementsTabSelected();
		
	}

	@When("User clicks on Text-Box button")
	public void user_clicks_on_text_box_button() {
	    elementsPageSteps.clickOnTextBoxButton();
	}
	
	@When("enters the required details {string}")
	public void enters_the_required_details(String testflow) {
	    elementsPageSteps.enterTextBoxDetails(testflow);
	}
	
	@When("clicks on submit button")
	public void clicks_on_submit_button() {
	    elementsPageSteps.clickOnSubmit();
	}
	
	@Then("entered data is displayed correctly {string}")
	public void entered_data_is_displayed_correctly(String testflow) {
	    elementsPageSteps.verifyEnteredData(testflow);
	}
	
	//-----------------------------CheckBox---------------------------------------
	
	@When("User clicks on Check Box tab")
	public void user_clicks_on_check_box_tab() {
	    elementsPageSteps.selectCheckBoxTab();
	}
	
	@When("selects Home checkbox")
	public void selects_home_checkbox() {
	    elementsPageSteps.selectHomeCheckBox();
	}
	
	@Then("all checkboxes are selected")
	public void all_checkboxes_are_selected() {
	    elementsPageSteps.verifyEachCheckBoxSelected();
	}
	
	//-----------------------------RadioButton---------------------------------------
	@When("User clicks on RadioButton tab")
	public void user_clicks_on_radio_button_tab() throws InterruptedException {
	    elementsPageSteps.selectRadioButtonTab();
	}
	
	@When("selects a {string}")
	public void selects_a(String option) throws InterruptedException {
	    elementsPageSteps.selectRadioButton(option);;
	}
	
	@Then("success message is displayed as per selected {string}")
	public void success_message_is_displayed_as_per_selected(String option) {
	    elementsPageSteps.checkSuccessMessage(option);
	}
	
	//--------------------------------WebTables----------------------------------------
	@When("User clicks on WebTables tab")
	public void user_clicks_on_web_tables_tab() throws InterruptedException {
	    elementsPageSteps.selectWebTablesTab();
	}
	
	@When("clicks on Add button")
	public void clicks_on_add_button() throws InterruptedException {
	    elementsPageSteps.clickOnAddButton();
	}
	
	@When("enters details for a new record {string}")
	public void enters_details_for_a_new_record(String testflow) {
	    elementsPageSteps.addNewRow(testflow);
	}
	
	@Then("record is added successfully {string}")
	public void record_is_added_successfully(String testflow) throws InterruptedException {
	    elementsPageSteps.verifyNewRow(testflow);
	}

}
