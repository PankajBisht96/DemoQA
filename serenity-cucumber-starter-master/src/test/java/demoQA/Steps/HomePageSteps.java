package demoQA.Steps;

import demoQA.Pages.HomePage;
import demoQA.utils.CommonFunctions;
import net.thucydides.core.pages.PageObject;

public class HomePageSteps extends PageObject {
	CommonFunctions common_functions;
	HomePage homepage;
	
	public void LaunchURL() throws InterruptedException {
		common_functions.launch_DemoQA_portal();
	}
	
	public void clickonElementsTab() throws InterruptedException{
		homepage.clickOnElementsTab();
	}
}
