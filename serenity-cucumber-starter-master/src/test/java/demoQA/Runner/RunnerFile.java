package demoQA.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@WebTablesAddData", features = { "Resources/Features" }, glue = { "demoQA.StepDefinitions",
		"demoQA.Hooks" })
public class RunnerFile {

}
