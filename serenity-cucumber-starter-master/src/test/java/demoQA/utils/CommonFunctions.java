package demoQA.utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.thucydides.core.pages.PageObject;

public class CommonFunctions extends PageObject{
	
	public Boolean elementIsVisible(WebElement e) {
		Boolean ele = e.isDisplayed();
		return ele;

	}
	
	public Boolean waitForElementToAppear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(ele));
		return ele.isDisplayed();
	}
	
	public Boolean waitForElementToBeClickable(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		return ele.isDisplayed();
	}
	
	public void clickOnElement(WebElement ele) throws InterruptedException
	{
		if(waitForElementToBeClickable(ele))
		{
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].click()", ele);
			
		}
		else {
			System.out.println(ele + "is not displayed");
		}
	}
	
	public void launch_DemoQA_portal() {
		//String URL = System.getProperty("");
		String URL = "https://demoqa.com";
		getDriver().get(URL);
		
		System.out.println("URL is : " + URL);
		String s = getDriver().getTitle();
		System.out.println("Title of the page is: " + s);
	}
	
	public int getRowNo_for_testdata(String sheetName, String testflow, XLSReader XLS) {
		int Row_count = XLS.getRowCount(sheetName);
		int Row = 0;
		
		for(int i=1;i<=Row_count;i++)
		{
			if(XLS.getCellData(sheetName, "TCID", i).equalsIgnoreCase(testflow)) {
				Row=i;
				break;
			}
		}
		return Row;
	}
	
	public void enterData(WebElement e, String text) {
		waitForElementToAppear(e);
		e.clear();
		e.sendKeys(text);
		Actions action = new Actions(getDriver());
		action.sendKeys(Keys.TAB).build().perform();
	}
	
	public void enterData(WebElement e, int text) {
		waitForElementToAppear(e);
		e.clear();
		e.sendKeys(String.valueOf(text));
		Actions action = new Actions(getDriver());
		action.sendKeys(Keys.TAB).build().perform();
	}
	
	public void clickOn(final WebElement webElement)  {
		element(webElement).click();
	}
	
	public void explicitWait() {
//		WebDriverWait wait = new WebDriverWait(getDriver());
	}

}
