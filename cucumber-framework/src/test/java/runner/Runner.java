package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/feature_files/Tricentis_Webshop_Login.feature",
		glue={"step_definiton_files","common_methods"},
		dryRun = false,
		monochrome = true,
		publish = true,
		plugin = {"pretty","html:test_output/web_report",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:test_output/failed_tests/failed_tests.txt"},
		tags = "@Smoke"
		)
public class Runner {

}
