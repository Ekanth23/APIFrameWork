package cucumber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * TestRunner class is the entry point for running Cucumber tests.
 * Uses JUnit runner to execute Cucumber features.
 * Configures Cucumber options like feature files location, glue code package, and reporting.
 * Framework Feature: Integrates Cucumber BDD with JUnit for test execution.
 * Allows running scenarios with specific tags for selective execution.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features", // Path to feature files
					glue= {"stepDefinations"}, // Package containing step definitions
						plugin= "json:target/jsonReports/cucumber-report.json") // Reporting plugin for JSON output

public class TestRunner {
	
	//tags ="@DeletePlace" // Uncomment to run only scenarios with @DeletePlace tag

}
