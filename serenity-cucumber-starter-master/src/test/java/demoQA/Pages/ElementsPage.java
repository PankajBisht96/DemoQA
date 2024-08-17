package demoQA.Pages;

import org.junit.Assert;
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
	XLSReader XLS = new XLSReader(root + "/TestData/ElementsTab.xlsx");
	String sheetName = "ElementsTab";
	
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
	
	//---------------------------To Check Result---------------------------
	@FindBy (xpath="//p[@id='name']")
	private WebElement Rname;
	
	@FindBy (xpath="//p[@id='email']")
	private WebElement Remail;
	
	@FindBy (xpath="//p[@id='currentAddress']")
	private WebElement RcurrentAddress;
	
	@FindBy (xpath="//p[@id='permanentAddress']")
	private WebElement RpermanentAddress;
	
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
		Assert.assertTrue("Full name doesn't amtch", Rname.getText().contains(actualName));
		
		String actualEmail = XLS.getCellData(sheetName, "Email", row);
		Assert.assertTrue("Email address doesn't amtch", Remail.getText().contains(actualEmail));
				
		String actualCurrentAddress = XLS.getCellData(sheetName, "CurrentAddress", row);
		Assert.assertTrue("Current address doesn't amtch", RcurrentAddress.getText().contains(actualCurrentAddress));	
		
		String actualPermanentAddress = XLS.getCellData(sheetName, "PermanentAddress", row);
		Assert.assertTrue("Permanent address doesn't amtch", RpermanentAddress.getText().contains(actualPermanentAddress));
	}
}
