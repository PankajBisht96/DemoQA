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

}
