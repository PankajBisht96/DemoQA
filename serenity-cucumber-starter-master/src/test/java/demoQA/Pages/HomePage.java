package demoQA.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import demoQA.utils.CommonFunctions;
import net.serenitybdd.core.pages.PageObject;

public class HomePage extends PageObject{
	CommonFunctions common_functions;
	
	@FindBy(xpath="//h5[contains(text(),'Elements')]")
	private WebElement Elements;

	@FindBy(xpath="//h5[contains(text(),'Elements')]")
	private WebElement Forms;
	
	public void clickOnElementsTab() throws InterruptedException {
		common_functions.waitForElementToAppear(Elements);
		common_functions.clickOnElement(Elements);
	}
}
