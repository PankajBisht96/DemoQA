package demoQA.StepDefinitions;


import demoQA.Steps.HomePageSteps;
import io.cucumber.java.en.Given;

public class HomePageStepDefinitions {
HomePageSteps homePageSteps;
	
	@Given("DemoQA application is launched")
	public void demo_qa_application_is_launched() throws InterruptedException {
		homePageSteps.LaunchURL();
	}
	
	@Given("User clicks on Elements tab")
	public void user_clicks_on_elements_tab() throws InterruptedException {
	    homePageSteps.clickonElementsTab();
	}

}
