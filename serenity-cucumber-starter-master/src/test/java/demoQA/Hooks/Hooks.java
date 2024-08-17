package demoQA.Hooks;

import io.cucumber.java.After;
import net.serenitybdd.core.pages.PageObject;

public class Hooks extends PageObject{
	
	@After
	public void AfterScenario() {
		System.out.println("--------------------After Scenario----------------");
		getDriver().quit();
	}
}
