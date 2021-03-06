package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/features",glue="stepdefinitions",
		tags="@Seleniumtest1,@Seleniumtest2",
		strict=true,monochrome=true,
		plugin = {"pretty","html:target/cucumberhtmlreport", "json:target/jsonReports/cucumber-report.json"}
		)

public class TestRunner 
{

	
}
