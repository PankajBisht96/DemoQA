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
	
	//-----------------------------CheckBox---------------------------------------
	
	public void selectCheckBoxTab() {
		elementsPage.clickOnCheckBoxTab();
	}
	
	public void selectHomeCheckBox() {
		elementsPage.clickOnHomeCheckBox();
	}
	
	public void verifyEachCheckBoxSelected() {
		elementsPage.verifyAllCheckBoxSelected();
	}
	
	//-----------------------------RadioButton---------------------------------------
	
	public void selectRadioButtonTab() throws InterruptedException {
		elementsPage.clickOnRadioButtonTab();
	}
	public void selectRadioButton(String option) throws InterruptedException {
		elementsPage.RadioButtonSelection(option);
	}
	
	public void checkSuccessMessage(String option) {
		elementsPage.validateSuccessMessage(option);
	}
	
	//---------------------------WebTables-------------------------------------
	
	public void selectWebTablesTab() throws InterruptedException {
		elementsPage.clickOnWebTablesTab();
	}
	
	public void clickOnAddButton() throws InterruptedException {
		elementsPage.clickOnAdd();
	}
	
	public void addNewRow(String testflow) {
		elementsPage.addNewRecord(testflow);
	}
	
	public void verifyNewRow(String testflow) throws InterruptedException {
		elementsPage.verifyNewRecord(testflow);
	}
	
}
