package BDDCheck.gittest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\Arjun BR\\workspace\\gittest\\features\\MyApplication.feature",
		glue={"StepDefinition"}
		)
public class TestRunner {

}
