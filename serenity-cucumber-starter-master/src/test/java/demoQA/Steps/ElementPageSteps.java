package demoQA.Steps;

import demoQA.Pages.ElementsPage;
import net.serenitybdd.core.pages.PageObject;

public class ElementPageSteps extends PageObject{

	ElementsPage elementsPage;
	
	public void verifyElementsTabSelected() {
		elementsPage.verifyElementPageIsLoaded();
	}
	
	public void clickOnTextBoxButton() {
		elementsPage.clickOnTextBoxTab();
	}
	
	public void enterTextBoxDetails(String testflow) {
		elementsPage.addTextBoxDetails(testflow);
	}
	
	public void clickOnSubmit() {
		elementsPage.clickOnSubmitButton();
	}
	
	public void verifyEnteredData(String testflow) {
		elementsPage.verifySubmittedDataInTextBox(testflow);
	}
}
