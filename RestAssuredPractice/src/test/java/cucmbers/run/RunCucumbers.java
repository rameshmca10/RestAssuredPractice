package cucmbers.run;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/feature/IssueManagement.feature"},
					glue = {"step.def","cucmbers.run"},
					monochrome = true)
public class RunCucumbers extends AbstractTestNGCucumberTests{

}