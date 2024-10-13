package demoQA.Pages;

import java.util.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import demoQA.utils.CommonFunctions;
import demoQA.utils.XLSReader;
import net.serenitybdd.core.pages.PageObject;

public class ElementsPage extends PageObject{
	
	CommonFunctions common_functions;
	
	String root = System.getProperty("user.dir");
	XLSReader XLS = new XLSReader(root + "/TestData/ToolsQA_TestData.xlsx");
	String sheetName = "ElementsTab";
	
	//--------------------------------TextBox-------------------------------
	
	@FindBy(xpath="//span[contains(text(),'Text Box')]")
	public WebElement textBox;
	
	@FindBy(xpath="//input[@id=\"userName\"]")
	public WebElement fullName;
	
	@FindBy(xpath="//input[@id=\"userEmail\"]")
	public WebElement Email;
	
	@FindBy (xpath="//textarea[@id=\"currentAddress\"]")
	public WebElement currentAddress;
	
	@FindBy (xpath="//textarea[@id=\"permanentAddress\"]")
	public WebElement permanentAddress;
	
	@FindBy (xpath="//button[@id=\"submit\"]")
	public WebElement submitButton;
	
	//---------------------------To Check Text Box Result---------------------------
	
		@FindBy (xpath="//p[@id='name']")
		private WebElement Rname;
		
		@FindBy (xpath="//p[@id='email']")
		private WebElement Remail;
		
		@FindBy (xpath="//p[@id='currentAddress']")
		private WebElement RcurrentAddress;
		
		@FindBy (xpath="//p[@id='permanentAddress']")
		private WebElement RpermanentAddress;
		
		
		@FindBy (xpath="//input[@name='password']")
		private WebElement pwd;
		
		@FindBy (xpath="//button[@type='submit']")
		private WebElement SubmitBtn;
	
	//------------------------------------CheckBox------------------------------------------
	
	@FindBy (xpath="//span[contains(text(),'Check Box')]")
	private WebElement checkBox;
	
	@FindBy (xpath="//span[contains(text(),'Home')]")
	private WebElement HomeCheckBox;
	
	@FindBy (xpath="//button[@title='Toggle']")
	private WebElement CheckBoxToggleButton;
	
	@FindBy(xpath="//span[contains(text(),'Desktop')]//parent::span//preceding-sibling::span")
	private WebElement DesktopCheckBox;
	
	@FindBy(xpath="//span[contains(text(),'Documents')]")
	private WebElement DocumentsCheckBox;
	
	@FindBy(xpath="//span[contains(text(),'Downloads')]")
	private WebElement DownloadsCheckBox;
	
	//------------------------------------RadioButton------------------------------------------
	
	@FindBy(xpath="//span[contains(text(),'Radio Button')]")
	private WebElement RadioButton;
	
//	@FindBy (xpath="//input[@id='yesRadio']")
	@FindBy (xpath="//label[@for='yesRadio']")
	private WebElement YesOption;
	
	@FindBy (xpath="//label[@for='impressiveRadio']")
	private WebElement ImpressiveOption;
	
//	@FindBy (xpath="//label[@class='custom-control-label disabled']")
	@FindBy(xpath="//input[@class='custom-control-input disabled']")
	private WebElement NoOption;
	
	@FindBy (xpath="//span[@class='text-success']")
	private WebElement successMessage;
	
	//--------------------------------------WebTables---------------------------------------
	
	@FindBy (xpath="//span[contains(text(),'Web Tables')]")
	WebElement WebTables;
	
	@FindBy (xpath="//button[@id='addNewRecordButton']")
	WebElement WebTableAddButton;
	
	@FindBy (xpath="//input[@id='firstName']")
	WebElement firstName;
	
	@FindBy (xpath="//input[@id='lastName']")
	WebElement lastName;
	
	@FindBy (xpath="//input[@id='age']")
	WebElement age;
	
	@FindBy (xpath="//input[@id='salary']")
	WebElement salary;
	
	@FindBy (xpath="//input[@id='department']")
	WebElement department;
	
//	@FindBy (xpath="//div[@class='rt-tbody']//div[@class='rt-tr-group']")
//	WebElement totalRows;
	
	
	public void verifyElementPageIsLoaded() {
		common_functions.waitForElementToAppear(textBox);
		Assert.assertTrue("Element Page is not loaded", textBox.isDisplayed());	
		
	}
	
//------------------------------------------TextBox---------------------------------------------
	public void clickOnTextBoxTab() {
		common_functions.waitForElementToBeClickable(textBox);
		common_functions.clickOn(textBox);
		}
	
	public void addTextBoxDetails(String testflow) {
		enterAddTextBoxDetails(XLS,sheetName,testflow);
	}
	
	public void enterAddTextBoxDetails(XLSReader workBookXlS, String sheetName, String testflow) {
		addFullName(XLS,sheetName, testflow, "FullName");
		addEmail(XLS,sheetName, testflow, "Email");
		addCurrentAddress(XLS,sheetName, testflow, "CurrentAddress");
		addPermanentAddress(XLS,sheetName, testflow, "PermanentAddress");
	}
	
	public void addFullName(XLSReader workbookXLS, String sheetName, String testflow, String columnName) {
		int row = common_functions.getRowNo_for_testdata(sheetName, testflow, workbookXLS);
		System.out.println("row :" + row);
		
		String name = workbookXLS.getCellData(sheetName, columnName, row);
		if(name.isEmpty()==false)
		{
			common_functions.waitForElementToAppear(fullName);
			common_functions.enterData(fullName, name);
		}
				
	}
	
	public void addEmail(XLSReader workbookXLS, String sheetName, String testflow, String columnName) {
		int row = common_functions.getRowNo_for_testdata(sheetName, testflow, workbookXLS);
		System.out.println("row :" + row);
		
		String email = workbookXLS.getCellData(sheetName, columnName, row);
		if(email.isEmpty()==false)
		{
			common_functions.waitForElementToAppear(Email);
			common_functions.enterData(Email, email);
		}
	}
	
	public void addCurrentAddress(XLSReader workbookXLS, String sheetName, String testflow, String columnName) {
		int row = common_functions.getRowNo_for_testdata(sheetName, testflow, workbookXLS);
		System.out.println("row :" + row);
		
		String cAddress = workbookXLS.getCellData(sheetName, columnName, row);
		if(cAddress.isEmpty()==false)
		{
			common_functions.waitForElementToAppear(currentAddress);
			common_functions.enterData(currentAddress, cAddress);
		}
	}
	
	public void addPermanentAddress(XLSReader workbookXLS, String sheetName, String testflow, String columnName) {
		int row = common_functions.getRowNo_for_testdata(sheetName, testflow, workbookXLS);
		System.out.println("row :" + row);
		
		String pAddress = workbookXLS.getCellData(sheetName, columnName, row);
		if(pAddress.isEmpty()==false)
		{
			common_functions.waitForElementToAppear(permanentAddress);
			common_functions.enterData(permanentAddress, pAddress);
		}
	}
	
	public void clickOnSubmitButton() {
		common_functions.waitForElementToBeClickable(submitButton);
		Actions action = new Actions(getDriver());
		action.sendKeys(Keys.TAB).build().perform();
		common_functions.clickOn(submitButton);
	}
	
	public void verifySubmittedDataInTextBox(String testflow) {
		int row = common_functions.getRowNo_for_testdata(sheetName, testflow, XLS);
		System.out.println("row :" + row);

		String actualName = XLS.getCellData(sheetName, "FullName", row);
		Assert.assertTrue("Full name doesn't match", Rname.getText().contains(actualName));
		
		String actualEmail = XLS.getCellData(sheetName, "Email", row);
		Assert.assertTrue("Email address doesn't match", Remail.getText().contains(actualEmail));
				
		String actualCurrentAddress = XLS.getCellData(sheetName, "CurrentAddress", row);
		Assert.assertTrue("Current address doesn't match", RcurrentAddress.getText().contains(actualCurrentAddress));	
		
		String actualPermanentAddress = XLS.getCellData(sheetName, "PermanentAddress", row);
		Assert.assertTrue("Permanent address doesn't match", RpermanentAddress.getText().contains(actualPermanentAddress));
	}
	
	//------------------------------------CheckBox------------------------------------------
	public void clickOnCheckBoxTab() {
		common_functions.waitForElementToBeClickable(checkBox);
		common_functions.clickOn(checkBox);
		}
	
	public void clickOnHomeCheckBox() {
		common_functions.waitForElementToAppear(HomeCheckBox);
		common_functions.clickOn(HomeCheckBox);
		}
	
	public void verifyAllCheckBoxSelected() {
		common_functions.clickOn(CheckBoxToggleButton);
		Assert.assertTrue("Desktop checkbox is not available", DocumentsCheckBox.isDisplayed());
		Assert.assertTrue("Desktop checkbox is not available", DesktopCheckBox.isDisplayed());
		Assert.assertTrue("Desktop checkbox is not available", DownloadsCheckBox.isDisplayed());
		System.out.println("All checkboxes are selected");
	}
	
	//-------------------------------------RadioButton------------------------------------------
	
	public void clickOnRadioButtonTab() throws InterruptedException {
		common_functions.waitForElementToBeClickable(RadioButton);
		common_functions.clickOn(RadioButton);
		}
	
	public void RadioButtonSelection(String option) throws InterruptedException {
		if(option.equalsIgnoreCase("Yes")) {
			common_functions.clickOnElement(YesOption);
		}
		
		else if(option.equalsIgnoreCase("Impressive")) {
				common_functions.clickOnElement(ImpressiveOption);
		}
		
		else if(option.equalsIgnoreCase("No")){
			Assert.assertFalse("No Option is not disabed",NoOption.isEnabled());
		}
	}
	
	public void validateSuccessMessage(String testflow) {
		common_functions.waitForElementToAppear(successMessage);
		switch(testflow) {
		case "Yes":
			Assert.assertTrue("Yes Option is not selected",successMessage.getText().contains("Yes"));
			break;
			
		case "Impressive":
			Assert.assertTrue("Impressive Option is not selected",successMessage.getText().contains("Impressive"));
			break;
			
		}
		
		
	}
	
	//-------------------------------------WebTables-------------------------------
	public void clickOnWebTablesTab() throws InterruptedException {
		common_functions.waitForElementToBeClickable(WebTables);
		common_functions.clickOnElement(WebTables);
	}
	
	public void clickOnAdd() throws InterruptedException {
		common_functions.clickOnElement(WebTableAddButton);;
	}
	
	public void addNewRecord(String testflow) {
		enterNewRecordData(XLS,sheetName,testflow);
	}
	
	public void enterNewRecordData(XLSReader workBookXlS, String sheetName, String testflow) {
		addFirstName(XLS,sheetName, testflow, "FirstName");
		addLastName(XLS,sheetName, testflow, "LastName");
		addEmail(XLS,sheetName, testflow, "Email");
		addAge(XLS,sheetName, testflow, "Age");
		addSalary(XLS,sheetName, testflow, "Salary");
		addDepartment(XLS,sheetName, testflow, "Department");
	}
	
	public void addFirstName(XLSReader workbookXLS, String sheetName, String testflow, String columnName) {
		int row = common_functions.getRowNo_for_testdata(sheetName, testflow, workbookXLS);
		System.out.println("row :" + row);
		
		String name = workbookXLS.getCellData(sheetName, columnName, row);
		if(name.isEmpty()==false)
		{
			common_functions.waitForElementToAppear(firstName);
			common_functions.enterData(firstName, name);
		}
				
	}
	
	public void addLastName(XLSReader workbookXLS, String sheetName, String testflow, String columnName) {
		int row = common_functions.getRowNo_for_testdata(sheetName, testflow, workbookXLS);
		System.out.println("row :" + row);
		
		String name = workbookXLS.getCellData(sheetName, columnName, row);
		if(name.isEmpty()==false)
		{
			common_functions.waitForElementToAppear(lastName);
			common_functions.enterData(lastName, name);
		}
	}
	
	public void addAge(XLSReader workbookXLS, String sheetName, String testflow, String columnName) {
		int row = common_functions.getRowNo_for_testdata(sheetName, testflow, workbookXLS);
		System.out.println("row :" + row);
		
		int name = workbookXLS.getNumericCellData(sheetName, columnName, row);
		if(name!=0)
		{
			common_functions.waitForElementToAppear(age);
			common_functions.enterData(age, name);
		}				
	}
	
	public void addSalary(XLSReader workbookXLS, String sheetName, String testflow, String columnName) {
		int row = common_functions.getRowNo_for_testdata(sheetName, testflow, workbookXLS);
		System.out.println("row :" + row);
		
		int name = workbookXLS.getNumericCellData(sheetName, columnName, row);
		if(name!=0)
		{
			common_functions.waitForElementToAppear(salary);
			common_functions.enterData(salary, name);
		}				
	}
	
	public void addDepartment(XLSReader workbookXLS, String sheetName, String testflow, String columnName) {
		int row = common_functions.getRowNo_for_testdata(sheetName, testflow, workbookXLS);
		System.out.println("row :" + row);
		
		String name = workbookXLS.getCellData(sheetName, columnName, row);
		if(name.isEmpty()==false)
		{
			common_functions.waitForElementToAppear(department);
			common_functions.enterData(department, name);
		}
				
	}
	
	public void getRowCount() {
		List<WebElement> numberOfRows= getDriver().findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr-group"));
		int rows = numberOfRows.size();
		System.out.println("Total rows in webtable are" + rows);
	}
	
	public void getOriginalRownumber() {
		List<WebElement> rowData= getDriver().findElements(By.xpath("//div[@class='rt-tr -even'] | //div[@class='rt-tr -odd']"));
		int rows = rowData.size();
		System.out.println("Total rows in webtable are" + rows);
	}
	
	public void verifyNewRecord(String testflow) throws InterruptedException {
		int row = common_functions.getRowNo_for_testdata(sheetName, testflow, XLS);
		System.out.println("row :" + row);
		
		List<WebElement> rowCount= getDriver().findElements(By.xpath("//div[@class='rt-tr -even'] | //div[@class='rt-tr -odd']"));
		int rows = rowCount.size();
		System.out.println("Total rows in webtable are" + rows);
		
		Thread.sleep(2000);
		WebElement last = rowCount.get(rows-1);
		
		String lastRowData = last.getText();
		Thread.sleep(2000);
		System.out.println(lastRowData);		

		String actualFirstName = XLS.getCellData(sheetName, "FirstName", row);
		Assert.assertTrue("First name doesn't match", lastRowData.contains(actualFirstName));
		
		String actualLastName = XLS.getCellData(sheetName, "LastName", row);
		Assert.assertTrue("Last name doesn't match", lastRowData.contains(actualLastName));
				
		String actualEmail = XLS.getCellData(sheetName, "Email", row);
		Assert.assertTrue("Email address doesn't match", lastRowData.contains(actualEmail));	
		
		int actualAge = XLS.getNumericCellData(sheetName, "Age", row);
		Assert.assertTrue("Age doesn't match", lastRowData.contains(String.valueOf(actualAge)));
		
		int actualSalary = XLS.getNumericCellData(sheetName, "Salary", row);
		Assert.assertTrue("Salary doesn't match", lastRowData.contains(String.valueOf(actualSalary)));
		
		String actualDepartment = XLS.getCellData(sheetName, "FullName", row);
		Assert.assertTrue("Department name doesn't match", lastRowData.contains(actualDepartment));
	}
}
	
